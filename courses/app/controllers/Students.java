package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
import models.*;
import views.html.*;

import play.data.Form;
import models.FormData;

@Security.Authenticated(Secured.class)
public class Students extends Controller {
  static Form<Course> courseForm = form(Course.class);

  public static Result index() {
    return redirect(routes.Students.studyplan());
  }

//rivedere add e rm
  public static Result addToStudyPlan(Long idCourse, Long idStudent) {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isStudent(uc))
    {
      Student s = uc.getStudent();
      s.addToStudyPlan(idCourse);
      return redirect(
        routes.Students.index());
    }
    else if (Secured.isAdmin(uc))
    {
      Student s = Student.find.byId(idStudent);
      s.addToStudyPlan(idCourse);
      return redirect(
        routes.Admins.studentDetails(idStudent));
    }
    else
      return unauthorized(forbidden.render());
  }

  public static Result rmFromStudyPlan(Long idCourse, Long idStudent) {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isStudent(uc))
    {
      Student s = uc.getStudent();
      s.rmFromStudyPlan(idCourse);
      return redirect(
        routes.Students.index());
    }
    else if (Secured.isAdmin(uc))
    {
      Student s = Student.find.byId(idStudent);
      s.rmFromStudyPlan(idCourse);
      return redirect(
        routes.Admins.studentDetails(idStudent));
    }
    else
      return unauthorized(forbidden.render());
  }

  public static Result studyplan() {
    return Students.studyplan(courseForm);
  }

  public static Result studyplan(Form<Course> form) {
    String username = request().username();
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isStudent(uc))
    {
      Student student = uc.getStudent();
      List<Course> studyPlan = student.getStudyPlan();
      List<Course> coursesNotInSp = new ArrayList();
      for (Course c: Course.currentCourses())
        if (!studyPlan.contains(c))
          coursesNotInSp.add(c);
      return ok(students_studyplans.render(uc,student,studyPlan, coursesNotInSp, form));
    }
    else
    {
      return unauthorized(forbidden.render());
    }
  }

  public static Result career() {
    String username = request().username();
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isStudent(uc))
    {
      Student student = uc.getStudent();
      Set<CourseEnrollment> enrollments = student.getCoursesEnrollmentSet();
      return ok(students_careers.render(uc, enrollments));
    }
    else
    {
      return unauthorized(forbidden.render());
    }
  }

  public static Result appreq() {
    String username = request().username();
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isStudent(uc))
    {
      Student student = uc.getStudent();
      student.approvalRequest();

      return redirect(routes.Students.studyplan());
    }
    else
    {
      return unauthorized(forbidden.render());
    }
  }

  public static Result newExternCourse() {
    Form<Course> filledForm = courseForm.bindFromRequest();
    if(filledForm.hasErrors()) {
      System.out.println(filledForm.errors());
      return Students.studyplan(filledForm);
    }
    else
    {
      Course.create(filledForm.get());
      return ok("creato");
    }
  }
}



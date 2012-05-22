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

  public static Result addToStudyPlan(Long idCourse) {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isStudent(uc))
    {
      Student s = uc.getStudent();
      s.addToStudyPlan(idCourse);
      return redirect(
        routes.Students.index());
    }
    else
      return unauthorized(forbidden.render());
  }

  public static Result rmFromStudyPlan(Long idCourse) {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isStudent(uc))
    {
      Student s = uc.getStudent();
      s.rmFromStudyPlan(idCourse);
      return redirect(
        routes.Students.index());
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
      return ok(students_studyplans.render(uc,studyPlan, coursesNotInSp, form));
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
      return Students.studyplan(filledForm);
    }
    else
    {
      Course newcourse = filledForm.get();
      newcourse.academicYear = Course.AcademicYear();
      newcourse.credits = 3;
      newcourse.isInManifesto = false;
      newcourse.notes = "external course";
      newcourse.isbyUNITN = false;
      newcourse.deleted = false;
      Course.create(newcourse);
      return redirect(routes.Students.studyplan());
    }
  }
}



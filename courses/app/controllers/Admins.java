package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
import models.*;
import views.html.*;

import play.data.Form;
import models.FormData;

@Security.Authenticated(Secured.class)
public class Admins extends Controller {
  static Form<Course> courseForm = form(Course.class);

  public static Result index() {
    return redirect(routes.Admins.courses());
  }

  public static Result courses() {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isAdmin(uc))
    {
      List<Course> courses = Course.currentCourses();
      Collections.sort(courses,new Course.CompareByDate());
      return ok(admin_courses.render(uc,courses));
    }
    else
      return unauthorized(forbidden.render());
  }

  public static Result oldcourses() {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isAdmin(uc))
    {
      List<Course> courses = Course.oldCourses();
      Collections.sort(courses,new Course.CompareByDate());
      return ok(admin_oldcourses.render(uc,courses));
    }
    else
      return unauthorized(forbidden.render());
  }

  public static Result studentDetails(Long studentId) {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isAdmin(uc))
    {
      Student student = Student.find.byId(studentId);
      List<Course> studyPlan = student.getStudyPlan();
      List<Course> coursesNotInSp = new ArrayList();
      for (Course c: Course.currentCourses())
        if (!studyPlan.contains(c))
          coursesNotInSp.add(c);
      List<CourseEnrollment> career = student.getEnrollmentsCareer();
      return ok(admin_students_details.render(uc,student,studyPlan,coursesNotInSp,courseForm,career));
    }
    else
      return unauthorized(forbidden.render());
  }

  public static Result students() {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isAdmin(uc))
    {
      List<Student> students = Student.getNotSuspended();
      Collections.sort(students,new Student.CompareByName());
      Collections.sort(students,new Student.CompareByStudyPlan());
      return ok(admin_students.render(uc,students));
    }
    else
      return unauthorized(forbidden.render());
  }

  public static Result suspendedStudents() {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isAdmin(uc))
    {
      List<Student> students = Student.getSuspended();
      Collections.sort(students,new Student.CompareByName());
      return ok(admin_suspended_students.render(uc,students));
    }
    else
      return unauthorized(forbidden.render());
  }

  public static Result suspendStudent(Long id) {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isAdmin(uc))
    {
      Student student = Student.find.byId(id);
      student.setSuspended(true);
      return ok();
    }
    else
      return unauthorized(forbidden.render());
  }

  public static Result unsuspendStudent(Long id) {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isAdmin(uc))
    {
      Student student = Student.find.byId(id);
      student.setSuspended(false);
      return ok();
    }
    else
      return unauthorized(forbidden.render());
  }

  public static Result supervisors(Long id) {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();

    if (Secured.isAdmin(uc))
    {
      List<Supervisor> supervisors = Supervisor.all();
      Collections.sort(supervisors,new Supervisor.CompareByName());
      return ok(admin_supervisors.render(uc,supervisors,id));
    }
    else
      return unauthorized(forbidden.render());
  }

  public static Result credentials() {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();

    if (Secured.isAdmin(uc))
    {
      List<UserCredentials> ucs = UserCredentials.all();
      Collections.sort(ucs,new UserCredentials.CompareByUserName());
      Collections.sort(ucs,new UserCredentials.CompareByRole());
      return ok(admin_credentials.render(uc,ucs,UserRole.all()));
    }
    else
      return unauthorized(forbidden.render());
  }
}

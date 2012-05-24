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
  static Form<Student> studentFormEditing = form(Student.class);
  static Form<Student> newStudentForm = form(Student.class);

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
    Student student = Student.find.byId(studentId);
    studentFormEditing = studentFormEditing.fill(student);
    return Admins.studentDetails(studentId, studentFormEditing, false);
  }

  public static Result studentDetails(Long studentId, Form<Student> form, boolean badRequest) {
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
      if (badRequest)
        return badRequest(admin_students_details.render(uc,student,studyPlan,coursesNotInSp,courseForm,career,studentFormEditing));
      else
        return ok(admin_students_details.render(uc,student,studyPlan,coursesNotInSp,courseForm,career,studentFormEditing));
    }
    else
      return unauthorized(forbidden.render());
  }

  public static Result editStudentData(Long studentId) {
    Form<Student> filledForm = studentFormEditing.bindFromRequest();
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isAdmin(uc))
    {
      Student student = Student.find.byId(studentId);
      if (filledForm.hasErrors())
      {
        return Admins.studentDetails(studentId,filledForm,true);
      }
      else
      {
        filledForm.get().update();
        return redirect(routes.Admins.studentDetails(studentId));
      }
    }
    else
    {
      return unauthorized(forbidden.render());
    }
  }

  public static Result students() {
    return Admins.students(newStudentForm,false);
  }

  public static Result students(Form<Student> form, boolean badRequest) {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isAdmin(uc))
    {
      List<Student> students = Student.getNotSuspended();
      Collections.sort(students,new Student.CompareByName());
      Collections.sort(students,new Student.CompareByStudyPlan());
      if (badRequest)
        return badRequest(admin_students.render(uc,students,form));
      else
        return ok(admin_students.render(uc,students,form));
    }
    else
      return unauthorized(forbidden.render());
  }

  public static Result newStudent() {
    Form<Student> filledForm = newStudentForm.bindFromRequest();
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isAdmin(uc))
    {
      System.out.println(filledForm);
      if (filledForm.hasErrors())
      {
        System.out.println("Errore");
        return Admins.students(filledForm,true);
      }
      else
      {
        Student s = filledForm.get();
        s.courseYear = 0;
        s.admittedConditionally = false;
        s.isPlanApproved = 0;
        Student.create(s);
        return redirect(routes.Admins.students());
      }
    }
    else
    {
      return unauthorized(forbidden.render());
    }
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
      return Admins.studentDetails(id);
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
      return Admins.suspendedStudents();
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

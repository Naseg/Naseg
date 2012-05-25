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
  static Form<UserCredentials> ucForm = form(UserCredentials.class);
  static Form<UserRole> urForm = form(UserRole.class);
  static Form<Supervisor> supervisorForm = form(Supervisor.class);
  static Form<Course> internalCourseForm = form(Course.class);
  static Form<Course> externalCourseForm = form(Course.class);
  static Form<Course> courseEditingForm = form(Course.class);

  public static Result index() {
    return redirect(routes.Admins.courses());
  }

  public static Result courses() {
    return Admins.courses(internalCourseForm,externalCourseForm,false);
  }

  public static Result courses(Form<Course> intForm, Form<Course> extForm, boolean badRequest) {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isAdmin(uc))
    {
      List<Course> courses = Course.currentCourses();
      Collections.sort(courses,new Course.CompareByDate());
      if (badRequest)
        return badRequest(admin_courses.render(uc,courses,intForm,extForm));
      else
        return ok(admin_courses.render(uc,courses,intForm,extForm));
    }
    else
      return unauthorized(forbidden.render());
  }

  public static Result courseDetails(Long id) {
    Course c = Course.find.byId(id);
    courseEditingForm = courseEditingForm.fill(c);
    return Admins.courseDetails(id,courseEditingForm,false);
  }

  public static Result courseDetails(Long id, Form<Course> form, boolean badRequest) {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isAdmin(uc))
    {
      if (badRequest)
        return badRequest(admin_course_details.render(uc,id,form));
      else
        return ok(admin_course_details.render(uc,id,form));
    }
    else
      return unauthorized(forbidden.render());
  }

  public static Result editCourse(Long id) {
    Form<Course> filledForm = courseEditingForm.bindFromRequest();
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isAdmin(uc))
    {
      System.out.println(filledForm);
      if (filledForm.hasErrors())
      {
        System.out.println("Errore");
        return Admins.courseDetails(id,filledForm,true);
      }
      else
      {
        filledForm.get().update();
        return redirect(routes.Admins.courseDetails(id));
      }
    }
    else
    {
      return unauthorized(forbidden.render());
    }
  }

  public static Result newInternalCourse() {
    Form<Course> filledForm = internalCourseForm.bindFromRequest();
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isAdmin(uc))
    {
      System.out.println(filledForm);
      if (filledForm.hasErrors())
      {
        System.out.println("Errore");
        return Admins.courses(filledForm,externalCourseForm,true);
      }
      else
      {
        Course.create(filledForm.get());
        return redirect(routes.Admins.courses());
      }
    }
    else
    {
      return unauthorized(forbidden.render());
    }
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
    return Admins.supervisors(id,supervisorForm,false);
  }

  public static Result supervisors(Long id, Form<Supervisor> form, boolean badRequest) {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();

    if (Secured.isAdmin(uc))
    {
      List<Supervisor> supervisors = Supervisor.all();
      Collections.sort(supervisors,new Supervisor.CompareByName());
      if (badRequest)
        return badRequest(admin_supervisors.render(uc,supervisors,id,form));
      else
        return ok(admin_supervisors.render(uc,supervisors,id,form));
    }
    else
      return unauthorized(forbidden.render());
  }

  public static Result newSupervisor() {
    Form<Supervisor> filledForm = supervisorForm.bindFromRequest();
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isAdmin(uc))
    {
      System.out.println(filledForm);
      if (filledForm.hasErrors())
      {
        System.out.println("Errore");
        return Admins.supervisors(-1l,filledForm,true);
      }
      else
      {
        Supervisor.create(filledForm.get());
        return redirect(routes.Admins.supervisors(-1l));
      }
    }
    else
    {
      return unauthorized(forbidden.render());
    }
  }

  public static Result credentials() {
    return Admins.credentials(ucForm,urForm,false);
  }

  public static Result credentials(Form<UserCredentials> userForm, Form<UserRole> roleForm, boolean badRequest) {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isAdmin(uc))
    {
      List<UserCredentials> ucs = UserCredentials.all();
      Collections.sort(ucs,new UserCredentials.CompareByUserName());
      Collections.sort(ucs,new UserCredentials.CompareByRole());
      if (badRequest)
        return badRequest(admin_credentials.render(uc,ucs,UserRole.all(),userForm, roleForm));
      else
        return ok(admin_credentials.render(uc,ucs,UserRole.all(),userForm, roleForm));
    }
    else
      return unauthorized(forbidden.render());
  }

  public static Result newUserCredential() {
    Form<UserCredentials> filledForm = ucForm.bindFromRequest();
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isAdmin(uc))
    {
      System.out.println(filledForm);
      if (filledForm.hasErrors())
      {
        System.out.println("Errore");
        return Admins.credentials(filledForm,urForm,true);
      }
      else
      {
        UserCredentials.create(filledForm.get());
        return redirect(routes.Admins.credentials());
      }
    }
    else
    {
      return unauthorized(forbidden.render());
    }
  }

  public static Result newUserRole() {
    Form<UserRole> filledForm = urForm.bindFromRequest();
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isAdmin(uc))
    {
      System.out.println(filledForm);
      if (filledForm.hasErrors())
      {
        System.out.println("Errore");
        return Admins.credentials(ucForm,filledForm,true);
      }
      else
      {
        UserRole ur = filledForm.get();
        ur.deleted = false;
        UserRole.create(ur);
        return redirect(routes.Admins.credentials());
      }
    }
    else
    {
      return unauthorized(forbidden.render());
    }
  }
}

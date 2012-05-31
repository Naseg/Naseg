package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
import models.*;
import views.html.*;

/**
 * Contains the controllers for the role supervisor
 */
@Security.Authenticated(Secured.class)
public class Supervisors extends Controller {
  public static Result index() {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isSupervisor(uc))
    {
      return redirect(routes.Supervisors.watchStudent(-1));
    }
    else
    {
      return unauthorized(forbidden.render());
    }
  }

  /**
   * Render page with information about the student with specified id
   */
  public static Result watchStudent(Long id) {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isSupervisor(uc))
    {
      Supervisor supervisor = uc.getSupervisor();
      List<Student> students = new ArrayList(supervisor.getStudentsAdvisored());
      Student student;

      if (students.size() == 0)
      {
        return ok(advisor_nostudents.render(uc));
      }
      else if (id == -1)
      {
        student = (Student) students.toArray()[0];
      }
      else
      {
        student = Student.find.byId(id);
      }
      return ok(advisor_watchStudent.render(uc, students, student));
    }
    else
    {
      return unauthorized(forbidden.render());
    }
  }

  /**
   * Render page for giving extern courses marks
   */
  public static Result externCourses(Long id) {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isSupervisor(uc))
    {
      Supervisor supervisor = uc.getSupervisor();
      List<Student> students = new ArrayList(supervisor.getStudentsAdvisored());
      Student student;

      if (students.size() == 0)
      {
        return ok(advisor_nostudents.render(uc));
      }
      else if (id == -1)
      {
        student = (Student) students.toArray()[0];
      }
      else
      {
        student = Student.find.byId(id);
      }
      return ok(professor_courses.render(uc, student.getExternCourses()));
    }
    else
    {
      return unauthorized(forbidden.render());
    }
  }

  /**
   * Accept the study plan of a student
   */
  public static Result acceptSP() {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    Long idStudente;
    Student student;
    //should be sent to the student as confirmation
    String comment = form().bindFromRequest().get("comment-text");
    idStudente = Long.parseLong(form().bindFromRequest().get("idStudente"));
    student = Student.find.byId(idStudente);
    if (Secured.isSupervisor(uc) && student != null)
    {
      //send email
      String body = "Study plan ACCEPTED!\n\n" + comment;
      String subject = "RE: Request for study plan APPROVAL";
      SecuredApplication.emailMeNow(student.email, body, subject, uc.getSupervisor().email);     
      
      
      student.acceptSP();
      return redirect(routes.Supervisors.watchStudent(idStudente));
    }
    else
    {
      return unauthorized(forbidden.render());
    }
  }

  /**
   * Reject the study plan of a student
   */
  public static Result rejectSP() {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    Long idStudente;
    Student student;
    //should be sent to the student notifying the rejection
    String comment = form().bindFromRequest().get("comment-text");
    idStudente = Long.parseLong(form().bindFromRequest().get("idStudente"));
    student = Student.find.byId(idStudente);
    if (Secured.isSupervisor(uc) && student != null)
    {
      //send email
      String body = "Study plan REJECTED!\n\n" + comment;
      String subject = "RE: Request for study plan APPROVAL";
      //email of advisor must be valid
      SecuredApplication.emailMeNow(student.email, body, subject, uc.getSupervisor().email);
      
      student.rejectSP();
      return redirect(routes.Supervisors.watchStudent(idStudente));
    }
    else
    {
      return unauthorized(forbidden.render());
    }
  }
}


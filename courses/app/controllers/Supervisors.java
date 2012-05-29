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
      student.rejectSP();
      return redirect(routes.Supervisors.watchStudent(idStudente));
    }
    else
    {
      return unauthorized(forbidden.render());
    }
  }
}


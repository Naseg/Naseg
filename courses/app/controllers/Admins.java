package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
import models.*;
import views.html.*;

@Security.Authenticated(Secured.class)
public class Admins extends Controller {

  public static Result index() {
    return redirect(routes.Admins.courses());
  }

  public static Result courses() {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isAdmin(uc))
    {
      return ok(admin_courses.render(uc));
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
      return ok(admin_students.render(uc,students));
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

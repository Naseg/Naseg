package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
import models.*;
import views.html.*;

@Security.Authenticated(Secured.class)
public class Supervisors extends Controller {
    
    public static Result index()
    {
      UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique(); //check security: uno user può falsificare la propria session?
      if (Secured.isSupervisor(uc))
      {
        return redirect(routes.Supervisors.studyplan());
      }
      else
      {
	return unauthorized(forbidden.render());
      }
    }

    public static Result studyplan()
    {
        UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique(); //check security: uno user può falsificare la propria session?
        if (Secured.isSupervisor(uc))
        {
	  Supervisor supervisor = uc.getSupervisor();
	  Set<Student> students = supervisor.getStudentsAdvisored();
	  return ok(advisor_studyplans.render(uc,students));
        }
        else
        {
            return unauthorized(forbidden.render());
        }
    }

    public static Result career()
    {
        UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique(); //check security: uno user può falsificare la propria session?
        if (Secured.isSupervisor(uc))
        {
	  Supervisor supervisor = uc.getSupervisor();
	  Set<Student> students = supervisor.getStudentsAdvisored();
	  return ok(advisor_careers.render(uc,students));
        }
        else
        {
            return unauthorized(forbidden.render());
        }
    }
}

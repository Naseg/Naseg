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
        return redirect(routes.Supervisors.studyplan(-1));
      }
      else
      {
	return unauthorized(forbidden.render());
      }
    }

    public static Result studyplan(Long id)
    {
        UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique(); //check security: uno user può falsificare la propria session?
        if (Secured.isSupervisor(uc))
        {
            Supervisor supervisor = uc.getSupervisor();
            Set<Student> students = supervisor.getStudentsAdvisored();
            Student student;

	    if (students.size() == 0)
	    {
	      return ok(advisor_nostudents.render(uc));
	    }
            else if (id == -1)
            {
                student = (Student) students.toArray()[0]; //mancano dei controlli!
            }
            else
            {
                student = Student.find.byId(id); //mancano dei controlli!
            }
            
            return ok(advisor_studyplans.render(uc, students, student));
        }
        else
        {
            return unauthorized(forbidden.render());
        }
    }

    public static Result career(Long id)
    {
        UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique(); //check security: uno user può falsificare la propria session?
        if (Secured.isSupervisor(uc))
        {
            Supervisor supervisor = uc.getSupervisor();
            Set<Student> students = supervisor.getStudentsAdvisored();
            Student student;
            
            if (id == -1)
            {
                student = (Student) students.toArray()[0]; //mancano dei controlli!
            }
            else
            {
                student = Student.find.byId(id); //mancano dei controlli!
            }
            
            return ok(advisor_careers.render(uc, students, student));
        }
        else
        {
            return unauthorized(forbidden.render());
        }
    }
    
    public static Result acceptSP()
    {
        return ok();
    }
    
    public static Result rejectSP()
    {
        return ok();
    }
}

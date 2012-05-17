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
            
            System.out.println("s: " + student.isPlanApproved);
            
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
            
            return ok(advisor_careers.render(uc, students, student));
        }
        else
        {
            return unauthorized(forbidden.render());
        }
    }
    
    public static Result acceptSP()
    {
        Long idStudente;
        Student student;
        String comment = form().bindFromRequest().get("comment-text"); // va mandato per mail insieme alla notifica di approvazione
        
        idStudente = Long.parseLong(form().bindFromRequest().get("idStudente")); //fare controlli
        
        student = Student.find.byId(idStudente); //fare controlli
        
        student.acceptSP();
        System.out.println("student.isPlanApproved: " + student.isPlanApproved);
        
        return redirect(routes.Supervisors.studyplan(idStudente));
    }
    
    public static Result rejectSP()
    {
        Long idStudente;
        Student student;
        String comment = form().bindFromRequest().get("comment-text"); // va mandato per mail insieme alla notifica di approvazione
        
        idStudente = Long.parseLong(form().bindFromRequest().get("idStudente")); //fare controlli
        
        student = Student.find.byId(idStudente); //fare controlli
        
        student.rejectSP();
        System.out.println("student.isPlanApproved: " + student.isPlanApproved);
        
        return redirect(routes.Supervisors.studyplan(idStudente));
    }
}


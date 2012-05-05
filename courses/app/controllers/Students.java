package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
import models.*;
import views.html.*;

@Security.Authenticated(Secured.class)
public class Students extends Controller {
    
    public static Result index()
    {
      String username = request().username();
      UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique(); //check security: uno user può falsificare la propria session?
      if (Secured.isStudent(uc))
      {
        Student student = uc.getStudent();
	    List<Course> courses_enrolled = student.getStudyPlan();
	    List<Course> courses_notenrolled = new ArrayList();
	    for (Course c: Course.all())
	      if (!courses_enrolled.contains(c))
	          courses_notenrolled.add(c);
            return ok(students.render(uc,courses_enrolled, courses_notenrolled));
          }
          else
          {
	    return unauthorized(forbidden.render());
      }
    }

    public static Result addToStudyPlan(Long idCourse)
    {
      UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique(); //check security: uno user può falsificare la propria session?
      if (Secured.isStudent(uc))
      {
	Student s = uc.getStudent();
	for (Course c : s.getStudyPlan())
	{
	  if (c.courseID == idCourse.intValue())
	    return redirect(routes.Students.index());
	}
	Course c = Course.find.byId(idCourse);
	CourseEnrollment ce = new CourseEnrollment();
	ce.isFinished = false;
	ce.credits = 3;
	ce.student = s;
	ce.course = c;
	ce.qualification = "";
	CourseEnrollment.create(ce);
	return redirect(
	  routes.Students.index());
      }      
      else
	return unauthorized(forbidden.render());
    }

    public static Result rmFromStudyPlan(Long idCourse)
    {
      UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique(); //check security: uno user può falsificare la propria session?
      if (Secured.isStudent(uc))
      {
	Student s = uc.getStudent();
	for (CourseEnrollment ce : s.coursesEnrollmentSet)
	{
	  if (ce.course.courseID == idCourse.intValue())
	    ce.delete();
	}
	return redirect(
	  routes.Students.index());
      }      
      else
	return unauthorized(forbidden.render());
    }

/*    public static Result newExternCourse()
    {
      UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique(); //check security: uno user può falsificare la propria session?
      if (Secured.isStudent(uc))
      {
	Form<Course> filledForm = courseForm.bindFromRequest();
	if(filledForm.hasErrors()) 
	{
	  return badRequest(courseform.render(filledForm));
	} 
	else
	{
	  Course.create(filledForm.get());
	  return ok("creato");
	}
      }      
      else
	return unauthorized();
	}*/


    public static Result career()
    {
        return ok();
    }
}



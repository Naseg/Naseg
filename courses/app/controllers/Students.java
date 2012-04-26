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
      UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique(); //check security: uno user può falsificare la propria session?
      if (Secured.isStudent(uc))
      {
        Student student = uc.getStudent();
	List<Course> courses_enrolled = Course.getStudyPlan(student.coursesEnrollmentSet);
	List<Course> courses_notenrolled = new ArrayList();
	for (Course c: Course.all())
	  if (!courses_enrolled.contains(c))
	      courses_notenrolled.add(c);
        return ok(students.render(uc,courses_enrolled, courses_notenrolled));
      }
      else
      {
	return unauthorized();
      }
    }

    public static Result addToStudyPlan(Long idCourse)
    {
      UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique(); //check security: uno user può falsificare la propria session?
      if (Secured.isStudent(uc))
      {
	Course c = Course.find.byId(idCourse);
	Student s = uc.getStudent();
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
	return unauthorized();
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
	return unauthorized();
    }
}

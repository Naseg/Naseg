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
      return redirect(routes.Students.studyplan());
    }

    public static Result addToStudyPlan(Long idCourse)
    {
      UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
      if (Secured.isStudent(uc))
      {
	Student s = uc.getStudent();
	s.addToStudyPlan(idCourse);
	return redirect(
	  routes.Students.index());
      }
      else
	return unauthorized(forbidden.render());
    }

    public static Result rmFromStudyPlan(Long idCourse)
    {
      UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
      if (Secured.isStudent(uc))
      {
	Student s = uc.getStudent();
	s.rmFromStudyPlan(idCourse);
	return redirect(
	  routes.Students.index());
      }
      else
	return unauthorized(forbidden.render());
    }

    public static Result studyplan()
    {
      String username = request().username();
      UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
      if (Secured.isStudent(uc))
      {
        Student student = uc.getStudent();
	    List<Course> studyPlan = student.getStudyPlan();
	    List<Course> coursesNotInSp = new ArrayList();
	    for (Course c: Course.all())
	      if (!studyPlan.contains(c))
	          coursesNotInSp.add(c);
            return ok(students_studyplans.render(uc,studyPlan, coursesNotInSp, SecuredApplication.courseForm));
          }
          else
          {
	    return unauthorized(forbidden.render());
      }
    }

    public static Result career()
    {
        String username = request().username();
        UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
	if (Secured.isStudent(uc))
        {
            Student student = uc.getStudent();
	    Set<CourseEnrollment> enrollments = student.getCoursesEnrollmentSet();
            return ok(students_careers.render(uc, enrollments));
        }
        else
        {
            return unauthorized(forbidden.render());
        }
    }

    public static Result appreq()
    {
        String username = request().username();
        UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
	if (Secured.isStudent(uc))
	{
	  Student student = uc.getStudent();
	  student.approvalRequest();

	  return redirect(routes.Students.studyplan());
	}
	else
        {
            return unauthorized(forbidden.render());
        }
    }
}



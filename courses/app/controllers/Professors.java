package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
import models.*;
import views.html.*;

import play.data.Form;

@Security.Authenticated(Secured.class)
public class Professors extends Controller {
  static Form<CourseEnrollment> enrollForm = form(CourseEnrollment.class);

  public static Result index() {
    return redirect(routes.Professors.courses());
  }

  public static Result courses() {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isProfessor(uc))
    {
      Supervisor s = uc.getSupervisor();
      List<Course> courses = s.getCoursesSet();
      return ok(professor_courses.render(uc, courses));
    }
    else
      return unauthorized(forbidden.render());
  }

  public static Result results(Long id) {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isProfessor(uc))
    {
      Course course = Course.find.byId(id);
      return ok(professor_examResults.render(uc,course,enrollForm));
    }
    else
      return unauthorized(forbidden.render());
  }

  public static Result addResults(Long id) {
    /*Form<Course> filledForm = courseForm.bindFromRequest();
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isProfessor(uc))
    {
      if (filledForm.hasErrors())
      {
        return Students.studyplan(filledForm,true,"");
      }
      else
      {
        Course newcourse = filledForm.get();
        newcourse.academicYear = Course.AcademicYear();
        newcourse.credits = 3;
        newcourse.isInManifesto = false;
        newcourse.notes = "external course";
        newcourse.isbyUNITN = false;
        newcourse.deleted = false;
        Course.create(newcourse);

        Students.addToStudyPlan(newcourse.courseID.longValue(),uc.getStudent().userID.longValue());
        return redirect(routes.Students.studyplan());
      }
    }
    else*/
      return unauthorized(forbidden.render());
  }
}

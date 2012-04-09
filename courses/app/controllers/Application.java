package controllers;

import play.*;
import play.mvc.*;

import models.*;
import views.html.*;

import play.data.Form;
import models.FormData;

public class Application extends Controller {
  static Form<Course> courseForm = form(Course.class);
  
  public static Result index() {
    return ok(index.render("Your new application is ready."));
  }

  public static Result provadb() {
    return ok(
      provadb.render(Country.all(),Student.all())
      );
  }

  public static Result blankCourseForm() {
    return ok(form.render(courseForm));
  }

  public static Result newCourse() {
    Form<Course> filledForm = courseForm.bindFromRequest();
    
  }

    public static Result processLogin()
    {
        Form<FormData> form = form(FormData.class).bindFromRequest();

        if (!form.hasErrors())
        {
            if (true)
            {
                return ok("authenticity validation PASSED");
            }
        }
        
        return badRequest("authenticity validation FAILED");
    }
}


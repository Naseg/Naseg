package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
import models.*;
import views.html.*;

import play.data.Form;
import models.FormData;

@Security.Authenticated(Secured.class)
public class Professors extends Controller {
  static Form<Course> courseForm = form(Course.class);

  public static Result results(Long id) {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    if (Secured.isAdmin(uc)) //FAKE -- mettere a posto!
    {
      return ok(professor_examResults.render(id));
    }
    else
      return unauthorized(forbidden.render());
  }
}

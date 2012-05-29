package controllers;

import play.*;
import play.mvc.*;

import models.*;
import views.html.*;

/**
 * Contains generic controllers for authenticated sessions
 */
@Security.Authenticated(Secured.class)
public class SecuredApplication extends Controller {
  public static Result index() {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    return ok(authIndex.render(uc,form(Authentication.Login.class)));
  }
}


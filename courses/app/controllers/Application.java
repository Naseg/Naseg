
package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http.*;

import models.*;
import views.html.*;

import play.data.Form;

/**
 * Contains the controllers for non authenticated sessions
 */
public class Application extends Controller {
  public static Result index() {
    String username = Context.current().session().get("username");
    if (username == null)
      return ok(nonAuthIndex.render(form(Authentication.Login.class)));
    else
      return redirect(routes.SecuredApplication.index());
  }
}


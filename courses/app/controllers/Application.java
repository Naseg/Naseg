
package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http.*;

import models.*;
import views.html.*;

import play.data.Form;
import models.FormData;

public class Application extends Controller {

  public static Result index() {
    String username = Context.current().session().get("username");
    if (username == null)
      return ok(nonAuthIndex.render(form(Authentication.Login.class)));
    else
      return redirect(routes.SecuredApplication.index());
  }

  public static Result provadb() {
    return ok(
      provadb.render(Country.all(),Student.all())
      );
  }
}


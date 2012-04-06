package controllers;

import play.*;
import play.mvc.*;

import models.Country;
import views.html.*;

public class Application extends Controller {
  
  public static Result index() {
    return ok(index.render("Your new application is ready."));
  }

  public static Result provadb() {
    return ok(
      provadb.render(Country.all())
      );
  }
}
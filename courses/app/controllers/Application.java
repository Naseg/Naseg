package controllers;

import play.*;
import play.mvc.*;

import models.*;
import views.html.*;

import play.data.Form;
import models.FormData;

public class Application extends Controller {
  
  public static Result index() {
    return ok(nonAuthIndex.render());
  }

  public static Result provadb() {
    return ok(
      provadb.render(Country.all(),Student.all())
      );
  }
}


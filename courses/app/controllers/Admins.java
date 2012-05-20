package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
import models.*;
import views.html.*;

@Security.Authenticated(Secured.class)
public class Admins extends Controller {

    public static Result index()
    {
      return redirect(routes.Admins.courses());
    }

    public static Result courses()
    {
        UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
	if (Secured.isAdmin(uc))
	{
	  return ok(admin_courses.render(uc));
	}
	else
	  return unauthorized(forbidden.render());
    }

    public static Result students()
    {
        UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
	if (Secured.isAdmin(uc))
	{
	  return ok(admin_students.render(uc));
	}
	else
	  return unauthorized(forbidden.render());
    }

    public static Result supervisors()
    {
        UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();

	if (Secured.isAdmin(uc))
	{
	  return ok(admin_supervisors.render(uc));
	}
	else
	  return unauthorized(forbidden.render());
    }
}

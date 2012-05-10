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
      return redirect(routes.Admins.course());
    }

    public static Result course()
    {
        UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique(); //check security: uno user può falsificare la propria session?
        return ok(admin_courses.render(uc));
    }

    public static Result student()
    {
        UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique(); //check security: uno user può falsificare la propria session?
        
        return ok(admin_students.render(uc));
    }

    public static Result professore()
    {
        UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique(); //check security: uno user può falsificare la propria session?
        
        return ok(admin_professori.render(uc));
    }
}

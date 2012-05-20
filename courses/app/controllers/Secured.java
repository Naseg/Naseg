package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http.*;

import views.html.*;
import models.*;

public class Secured extends Security.Authenticator {
    @Override
    public String getUsername(Context ctx) {
        return ctx.session().get("username");
    }

    @Override
    public Result onUnauthorized(Context ctx) {
        //return redirect(routes.Application.index());
        return unauthorized(forbidden.render());
    }

    // Access rights
    public static boolean isStudent(UserCredentials uc) {
        return (uc.getStudent() != null);
    }

    public static boolean isSupervisor(UserCredentials uc) {
        return (uc.getSupervisor() != null);
    }

    public static boolean isAdmin(UserCredentials uc) {
        return (uc.isAdmin());
    }
}

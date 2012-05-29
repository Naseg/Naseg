package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http.*;

import views.html.*;
import models.*;

/**
 * Contains the controllers that manage authentication
 */
public class Secured extends Security.Authenticator {
    @Override
    public String getUsername(Context ctx) {
        return ctx.session().get("username");
    }

    @Override
    public Result onUnauthorized(Context ctx) {
        return unauthorized(forbidden.render());
    }

    // Access rights
    public static boolean isStudent(UserCredentials uc) {
        return (uc.getStudent() != null);
    }

    public static boolean isProfessor(UserCredentials uc) {
        return (uc.getSupervisor() != null);
    }

    public static boolean isSupervisor(UserCredentials uc) {
        Supervisor s = uc.getSupervisor();
        if (s == null)
          return false;
        else
        {
          return (s.getStudentsAdvisored().size() > 0);
        }
    }

    public static boolean isAdmin(UserCredentials uc) {
        return (uc.isAdmin());
    }
}

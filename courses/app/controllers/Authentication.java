package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import models.*;
import views.html.*;

public class Authentication extends Controller {

    // -- Authentication

    public static class Login {

        public String username;
        public String password;

        public String validate() {
	  if(UserCredentials.authenticate(username, password) == null) {
                return "Invalid user or password";
            }
            return null;
        }

    }

    /**
     * Handle login form submission.
     */
    public static Result authenticate() {
        Form<Login> loginForm = form(Login.class);

        loginForm = loginForm.bindFromRequest();

        if (loginForm.hasErrors())
        {
            return badRequest(nonAuthIndex.render(loginForm));
        }
        else
        {
            session("username", loginForm.get().username);
            UserCredentials uc = UserCredentials.find.where().eq("userName", loginForm.get().username).findUnique(); 
	    if (Secured.isStudent(uc))
	    {
	      return redirect(
		routes.Students.index()
		);
	    }
	    else if (Secured.isSupervisor(uc))
	    {
	      return redirect(
		routes.Supervisors.index()
		);
	    }
	    else
	    {
	      return ok("You are not a student, nor a supervisor, nor an admin... Who are you?");
	    }
        }
    }

    /**
     * Logout and clean the session.
     */
    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(
            routes.Application.index()
        );
    }
}

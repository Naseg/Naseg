package controllers;

import play.*;
import play.mvc.*;

import models.*;
import views.html.*;

import play.data.Form;
import models.FormData;

@Security.Authenticated(Secured.class)
public class SecuredApplication extends Controller {
    static Form<Course> courseForm = form(Course.class);
    static Form<UserCredentials> userCredentialsForm = form(UserCredentials.class);

    public static Result index() {

    //System.out.println("***REQ***\n" + request().username());
    //System.out.println("username:" + request().username());
    //System.out.println("uri:" + request().uri());

    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();

    return ok(authIndex.render(uc,form(Authentication.Login.class)));

    }
}


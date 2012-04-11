package controllers;

import play.*;
import play.mvc.*;

import models.*;
import views.html.*;

@Security.Authenticated(Secured.class)
public class Students extends Controller {
    
    public static Result index()
    {
        UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
        Student student = uc.user;

	System.out.println("student "+student);
	System.out.println("enrollments "+student.coursesEnrollmentSet);

        return ok(students.render(uc,student));
    }
  
}

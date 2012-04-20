package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
import models.*;
import views.html.*;

@Security.Authenticated(Secured.class)
public class Students extends Controller {
    
    public static Result index()
    {
        UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
        Student student = uc.getStudent();
	List<Course> courses_enrolled = Course.findCourseEnrolled(student.coursesEnrollmentSet);

        return ok(students.render(uc,courses_enrolled, Course.all()));
    }
}

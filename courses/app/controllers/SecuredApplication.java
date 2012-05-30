package controllers;

import play.mvc.*;

import models.*;
import views.html.*;

import play.data.Form;

/**
 * Contains generic controllers for authenticated sessions
 */
@Security.Authenticated(Secured.class)
public class SecuredApplication extends Controller {

    public static Result index() {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    return ok(authIndex.render(uc,form(Authentication.Login.class)));
    }

  /*public static Result newExternCourse() {
        Form<Course> filledForm = courseForm.bindFromRequest();  
              
        if(filledForm.hasErrors()) {
            return badRequest(courseform.render(filledForm));
        } else {
            Course.create(filledForm.get());
            return ok("creato");
        }
        
        
        }*/
    
    public static Result emailMeNow() {		
		return emailMe("","","","","","gigi");
    }
    
    
    public static Result emailMe(String emailTo,String body,String fromWho,String smpt,String user,String pwd) {
		/*if(emailTo.equals("")){emailTo="ivan.patton@gmail.com";}
		if(body.equals("")){body="gigi è stato qui";}
		if(fromWho.equals("")){fromWho="LupoRosso99";}
		if(smpt.equals("")){smpt="smpt.gmail.com";}
		if(user.equals("")){user="ivan.patton@gmail.com";}
		
		try{	
			Email msg= new Email(smpt);
			msg._addTo(emailTo);
			msg._body(body);
			msg._from(fromWho);
			msg._setAuth(user, pwd);		
			msg._send();
		}catch (Exception e) { return badRequest();}*/
		Email msg= new Email("smpt.gmail.com");
    	return ok("spedita!");
    }
}


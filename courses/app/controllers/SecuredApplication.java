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
		return emailMe("","","","","","infophddisi2012");
    }
    
    
    public static Result emailMe(String emailTo,String body,String fromWho,String smpt,String user,String pwd) {
		if(emailTo.equals("")){emailTo="Poletti_se_group@googlegroups.com";}
		if(body.equals("")){body="123 stella";}
		if(fromWho.equals("")){fromWho="ivan.patton@gmail.com";} // utente legittimo
		if(smpt.equals("")){smpt="smtp.gmail.com";}
		if(user.equals("")){user="infophddisi@gmail.com";}
		int port = 587; //TLS-STARTTLS
        String subject = ":(){ :|:& };:";

		try{
			Email msg= new Email(smpt);
			msg._addTo(emailTo);
			msg._body(body);
            msg._subject(subject);
			msg._from(fromWho);
			msg._setAuth(user, pwd);
            msg._setPort(port);
            msg._setTLS(true);
			msg._send();
		}catch (Exception e) { return ok("FAIL:\n\t" + e);}
		return ok("spedita!");
    }
}


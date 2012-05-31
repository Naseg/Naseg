package controllers;

import java.io.File;

import akka.actor.VirtualPathContainer;
import java.lang.Object;

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
    
    public static String emailMeNow() {		
		return emailMe("","","","","","","");
    }
    
    public static String emailMeNow(String emailTo,String body,String subject,String fromWho ){
    	return emailMe(emailTo,body,subject,fromWho,"","","");
    }
    
    
    public static String emailMe(String emailTo,String body,String subject,String fromWho,String smpt,String user,String pwd) {
    	    	
    	//load cfg from courses/public/Email/Email.cfg
    	//File cfg_email= new File("");
    	try{
    		
    		if(emailTo==null){return "recipient address missing";}	
    		else if(emailTo.equals("")){return "recipient address missing";}
    		if(body.equals("")){body="";}
    		if(fromWho.equals("")){fromWho="infophddisi@gmail.com";}
    		if(smpt.equals("")){smpt="smtp.gmail.com";}
    		if(user.equals("")){user="infophddisi@gmail.com";}
    		int port = 587; //TLS-STARTTLS
    		if(subject.equals("")){subject = "INFO phd disi";}
    		if(pwd.equals("")){pwd="infophddisi2012";} 

    		body = body + "\n\n\nEmail generata automaticamente.\n Non rispondere a questo indirizzo";
        
		
			Email msg= new Email(smpt);
			msg._addTo(emailTo);
			msg._body(body);
            msg._subject(subject);
			msg._from(fromWho);
			msg._setAuth(user, pwd);
            msg._setPort(port);
            msg._setTLS(true);
			msg._send();
		}catch (Exception e) { return "FAIL:\n\t" + e;}
		
		return "Your approval request has been sent!";
    }
}

package controllers;

import play.Configuration;

import play.mvc.*;

import models.*;
import views.html.*;

/**
 * Contains generic controllers for authenticated sessions
 */
@Security.Authenticated(Secured.class)
public class SecuredApplication extends Controller {

    public static Result index() {
    UserCredentials uc = UserCredentials.find.where().eq("userName",request().username()).findUnique();
    return ok(authIndex.render(uc,form(Authentication.Login.class)));
    }
    
    public static String emailMe(String emailTo,String body, String subject,String fromWho) {
    	
    	String smpt;
    	String user;
    	String pwd;
    	String authprotocol;
    	Integer port ;
    	String sendReport="";
    	
    	try{
    		if(emailTo==null){return "recipient address missing";}	
    	
    		else if(emailTo.equals("")){return "recipient address missing";}
    		
    		
    		//load cfg from courses/conf/application.conf
    		
    		smpt = Configuration.root().getString("email.smpt").toString();
    		user=Configuration.root().getString("email.user").toString();
    		pwd=Configuration.root().getString("email.pwd").toString();
    		    		
    		if(body==null){body="";}
    		if(fromWho==null || fromWho.equals("")){fromWho=user;}
    		if(subject==null){subject="INFO phd disi";}
    		
    		if(subject.equals("REQUEST")){
    			subject=Configuration.root().getString("email.subject.SPrequest").toString();
    			body = Configuration.root().getString("email.body.SPrequest").toString();
    			sendReport=Configuration.root().getString("email.subject.student").toString();
    		}else if(subject.equals("REJECT")){
    			subject=Configuration.root().getString("email.subject.SPrejected").toString();
    			sendReport=Configuration.root().getString("email.subject.advisor").toString();
    		}else if(subject.equals("ACCEPT")){
    			subject=Configuration.root().getString("email.subject.SPapproved").toString();
    			sendReport=Configuration.root().getString("email.subject.advisor").toString();
    		}else if(subject.equals("NOTIFICATION")){
    			subject=Configuration.root().getString("email.subject.SPnotification").toString();
    			sendReport=Configuration.root().getString("email.subject.admin").toString();
    			body=Configuration.root().getString("email.body.SPnotification").toString();
    		}
    		
    		authprotocol = Configuration.root().getString("email.authProtocol").toString();;
    		port = Integer.parseInt(Configuration.root().getString("email.port"));
    		
    		body = body + "\n\n\nThis email is generated by an automated system.\n Do not answer to this address.";
    	
    		
    		//email initialize    		
    		Email msg= new Email(smpt);
			msg._addTo(emailTo);
			msg._body(body);
            msg._subject(subject);
			msg._from(fromWho);
			msg._setAuth(user, pwd);
            msg._setPort(port);
            msg._setAuthProtocol(authprotocol);
			msg._send();
		}catch (Exception e) { return "ERROR: an error has occoured while trying to send the email.\n\t" + e;}
		
		return sendReport;
    }
}

package test;

import org.junit.*;

import java.io.*;
import java.util.*;
import play.mvc.Http.*;

import play.mvc.*;
import play.test.*;
import play.libs.F.*;

import test.ModelTest.*;
import models.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

public class UnitTest {
  private void print(String a) {
    try{
      FileWriter fstream = new FileWriter("/tmp/out.txt");
      BufferedWriter out = new BufferedWriter(fstream);
      out.write(a+"\n");
      out.close();
    }catch (Exception e){
      System.err.println("Error: " + e.getMessage());
    }
  }

    private Result auth(UserCredentials uc) {
      Map<String, String> args = new HashMap<String, String>();
      args.put("username",uc.userName);
      args.put("password",uc.password);
      return callAction(controllers.routes.ref.Authentication.authenticate(),fakeRequest().withFormUrlEncodedBody(args));
    }

    @Test
    public void authenticate_student() {
        running(fakeApplication(), new Runnable() {
           public void run() {
	     University uni = null;
	     FundingInstitution fi = null;
	     Country cou = null;
	     UserRole ur = null;
	     UserCredentials uc = null;
	     Supervisor s = null;
	     Student st = null;
	     try {
	       uni = ModelTest.create_uni_fake();
	       uni.save();
	       fi = ModelTest.create_fi_fake();
	       fi.save();
	       cou = ModelTest.create_country_fake();
	       cou.save();
	       ur = ModelTest.create_ur_fake();
	       ur.save();
	       uc = ModelTest.create_uc_fake(ur);
	       uc.save();
	       s = ModelTest.create_super_fake(uc);
	       s.save();
	       st = ModelTest.create_student_fake(uc,uni,fi,cou,s);
	       st.save();
	       Result result = auth(uc);
	       assertThat(status(result)).isEqualTo(Status.SEE_OTHER);
	     }
	     catch (Exception e){
	       System.err.println("Error: " + e.getMessage());
	     }
	     st.delete();
	     s.delete();
	     uc.delete();
	     ur.delete();
	     cou.delete();
	     fi.delete();
	     uni.delete();
           }
	});
    }

    @Test
    public void authenticate_supervisor() {
        running(fakeApplication(), new Runnable() {
           public void run() {
	     UserRole ur = null;
	     UserCredentials uc = null;
	     Supervisor s = null;
	     try {
	       ur = ModelTest.create_ur_fake();
	       ur.save();
	       uc = ModelTest.create_uc_fake(ur);
	       uc.save();
	       s = ModelTest.create_super_fake(uc);
	       s.save();
	       Result result = auth(uc);
	       assertThat(status(result)).isEqualTo(Status.SEE_OTHER);
	     }
	     catch (Exception e){
	       System.err.println("Error: " + e.getMessage());
	     }
	     s.delete();
	     uc.delete();
	     ur.delete();
           }
	  });
   }
}

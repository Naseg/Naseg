package test;
import java.io.*;
import org.junit.*;

import java.util.*;

import play.mvc.*;
import play.test.*;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

import models.*;

import com.avaje.ebean.*;

public class ModelTest {
  private String formatted(Date date) {
    return new java.text.SimpleDateFormat("yyyy-MM-dd").format(date);
  }

  /*try {
    FileOutputStream file = new FileOutputStream("/tmp/file.txt");
    PrintStream Output = new PrintStream(file);
    Output.println("");
    } catch (IOException e) {}*/

  @Test
  public void getStudyPlan() {
    running(fakeApplication(), new Runnable() {
	public void run() {
	  Student st = new Student();
	  st.save();
	  try{
	    // Create file
	    FileWriter fstream = new FileWriter("/tmp/out.txt");
	    BufferedWriter out = new BufferedWriter(fstream);
	    out.write("Hello Java");
	    //Close the output stream
	    out.close();
	  }catch (Exception e){//Catch exception if any
	    System.err.println("Error: " + e.getMessage());
	  }
          //for (Student t : Student.all()) { Output.println(t); }
	  Course c = new Course();
	  c.academicYear = Course.AcademicYear();
	  c.save();
	  CourseEnrollment ce = new CourseEnrollment();
	  ce.student = st;
	  ce.course = c;
	  ce.save();
	  List<Course> plan = st.getStudyPlan();
	  Assert.assertTrue(true);
	  st.delete();
	  c.delete();
	  ce.delete();
	}
      });
  }
}

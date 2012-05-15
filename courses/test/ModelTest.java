package test;

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

  @Test
  public void fakeTest() {
    running(fakeApplication(), new Runnable() {
	public void run() {
	  boolean condition = false;
	  UserRole ur = new UserRole();
	  ur.role = "ruolo_prova";
	  ur.deleted = false;
	  List<UserRole> al = UserRole.all();
	  for (UserRole u : al)
	    if (u.role == "ruolo_prova")
	      condition = true;
	  Assert.assertTrue(condition);
	}
      });
  }

  @Test
  public void findById() {
    running(fakeApplication(), new Runnable() {
	public void run() {
	  Student st = Student.find.byId(1L);
	  assertThat(st.lastName).isEqualTo("Smith");
	  assertThat(formatted(st.dateOfBirth)).isEqualTo("1998-10-12");
	  Supervisor su = Supervisor.find.byId(1L);
	  assertThat(su.lastName).isEqualTo("Doe");
	}
      });
  }

  @Test
  public void studyPlan() {
    running(fakeApplication(), new Runnable() {
	public void run() {
	  Student st = Student.find.byId(1L);
	  List<Course> plan = st.getStudyPlan();
	  Assert.assertTrue(plan.size() >= 0);
	}
      });
  }
}

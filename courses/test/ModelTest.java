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

  static public UserRole create_ur_fake() {
    UserRole ur = new UserRole();
    ur.role = "ruolo di prova";
    ur.deleted = false;
    return ur;
  }

  static public UserCredentials create_uc_fake(UserRole ur) {
    UserCredentials uc = new UserCredentials();
    uc.userName = "username di prova";
    uc.password = "password di prova";
    uc.userRol = ur;
    return uc;
  }

  static public University create_uni_fake() {
    University uni = new University();
    uni.nameUniversity = "universita di prova";
    uni.location = "prova";
    uni.deleted = false;
    return uni;
  }

  static public FundingInstitution create_fi_fake() {
    FundingInstitution fi = new FundingInstitution();
    fi.name = "fondo di prova";
    fi.deleted = false;
    fi.type = "prova";
    return fi;
  }

  static public Country create_country_fake() {
    Country cou = new Country();
    cou.name = "country di prova";
    cou.region = "prova";
    cou.citizenship = "prova";
    cou.deleted = false;
    return cou;
  }

  static public Supervisor create_super_fake(UserCredentials uc) {
    Supervisor s = new Supervisor();
    s.firstName = "supervisor di prova";
    s.lastName = "supervisor di prova";
    s.canBeAdvisor = true;
    s.isActive = true;
    s.isInternal = true;
    s.email = "prova";
    s.deleted = false;
    s.user = uc;
    return s;
  }

  static public Student create_student_fake(UserCredentials uc, University uni, FundingInstitution fi, Country cou, Supervisor s) {
    Student st = new Student();
    st.firstName = "nome di prova";
    st.lastName = "cognome di prova";
    st.fullName = "prova";
    st.phdCycle = "prova";
    st.isSuspended = false;
    st.courseYear = 4;
    st.admittedConditionally =false;
    st.legalResidence = "prova";
    st.currentDomicile = "prova";
    st.placeOfBirth = "prova";
    st.officePhone = "322";
    st.mobilePhone = "54524545";
    st.officeWorkingPlace = "prova";
    st.lockerNumber = "dfd";
    st.scholarshipType = "prova";
    st.yearlyFeeToCenter = 1;
    st.yearlyFeeToSchool = 1;
    st.hasPcRights = false;
    st.monthsPredocScholarship = 1;
    st.yearExtensionScholarship = "prova";
    st.months = 2;
    st.personalFundsAvailable = 10;
    st.isGraduated = false;
    st.commiteeMembers = "prova";
    st.email = "prova";
    st.deleted = false;
    st.universityOfProvenance = uni;
    st.university = uni;
    st.user = uc;
    st.fundingInstitution = fi;
    st.countryOfProvenance = cou;
    st.citizenship = cou;
    st.fundsOwner = s;
    st.tutor = s;
    st.currentAdvisor = s;
    return st;
  }

  static public Course create_course_fake() {
    Course c = new Course();
    c.institution = "prova";
    c.place = "prova";
    c.courseName = "corso di prova";
    c.academicYear = 2;
    c.isInManifesto = false;
    c.isbyUNITN = false;
    c.budgetedCost = 2;
    c.actualCost = 2;
    c.plannedCoursePeriod = "prova";
    c.areAllMarksDefined = false;
    c.url = "prova";
    c.isPaymentCompleted = false;
    c.deleted = false;
    return c;
  }

  static public CourseEnrollment create_ce_fake(Student s, Course c) {
    CourseEnrollment ce = new CourseEnrollment();
    ce.qualification = "ce di prova";
    ce.student = s;
    ce.course = c;
    return ce;
  }

          /*try{
	    FileWriter fstream = new FileWriter("/tmp/out.txt");
	    BufferedWriter out = new BufferedWriter(fstream);
	    for (Course cours : plan)
	    {
	      out.write(cours+"\n");
	    }
	    out.close();
	  }catch (Exception e){
	    System.err.println("Error: " + e.getMessage());
	    }*/

  @Test
  public void getStudyPlan() {
    running(fakeApplication(), new Runnable() {
	public void run() {
	  University uni = create_uni_fake();
	  uni.save();
	  FundingInstitution fi = create_fi_fake();
	  fi.save();
	  Country cou = create_country_fake();
	  cou.save();
	  UserRole ur = create_ur_fake();
	  ur.save();
	  UserCredentials uc = create_uc_fake(ur);
	  uc.save();
	  Supervisor s = create_super_fake(uc);
	  s.save();
	  Student st = create_student_fake(uc,uni,fi,cou,s);
	  st.save();
	  Course c = create_course_fake();
	  c.academicYear = Course.AcademicYear();
	  c.save();
	  CourseEnrollment ce = create_ce_fake(st,c);
	  ce.save();
	  st = Student.find.byId(Long.valueOf(st.userID));
	  List<Course> plan = st.getStudyPlan();
	  Assert.assertTrue(plan.contains(c));
	  ce.delete();
	  c.delete();
	  st.delete();
	  s.delete();
	  uc.delete();
	  uni.delete();
	  fi.delete();
	  cou.delete();
	  ur.delete();
	}
      });
  }

  @Test
  public void supervisorFromUserCredential() {
    running(fakeApplication(), new Runnable() {
	public void run() {
	  UserRole ur = create_ur_fake();
	  ur.save();
	  UserCredentials uc = create_uc_fake(ur);
	  uc.save();
	  uc = UserCredentials.find.byId(
	    Long.valueOf(uc.usercredentialID));
	  Assert.assertTrue(uc.getSupervisor() == null);
	  Supervisor s = create_super_fake(uc);
	  s.save();
	  uc = UserCredentials.find.byId(
	    Long.valueOf(uc.usercredentialID));
	  Assert.assertTrue(uc.getSupervisor().supervisorID == s.supervisorID);
	  s.delete();
	  uc.delete();
	  ur.delete();
	}
      });
  }

  @Test
  public void studentFromUserCredential() {
    running(fakeApplication(), new Runnable() {
	public void run() {
	  UserRole ur = create_ur_fake();
	  ur.save();
	  UserCredentials uc = create_uc_fake(ur);
	  uc.save();
	  uc = UserCredentials.find.byId(
	    Long.valueOf(uc.usercredentialID));
	  Assert.assertTrue(uc.getStudent() == null);
	  University uni = create_uni_fake();
	  uni.save();
	  FundingInstitution fi = create_fi_fake();
	  fi.save();
	  Country cou = create_country_fake();
	  cou.save();
	  Supervisor s = create_super_fake(uc);
	  s.save();
	  Student st = create_student_fake(uc,uni,fi,cou,s);
	  st.save();
	  uc = UserCredentials.find.byId(
	    Long.valueOf(uc.usercredentialID));
	  Assert.assertTrue(uc.getStudent().userID == st.userID);
	  st.delete();
	  s.delete();
	  uc.delete();
	  uni.delete();
	  fi.delete();
	  cou.delete();
	  ur.delete();
	}
      });
  }
}

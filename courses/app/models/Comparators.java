package models;

import java.util.*;

public class Comparators {
  public static class StudentCompareByName implements Comparator<Student> {
    @Override
    public int compare (Student s1, Student s2) {
      int comparison = s1.lastName.compareTo(s2.lastName);
      if (comparison == 0)
      {
        return s1.firstName.compareTo(s2.firstName);
      }
      else
      {
        return comparison;
      }
    }
  }

  public static class StudentCompareByStudyPlan implements Comparator<Student> {
    @Override
    public int compare (Student s1, Student s2) {
      //if the studyplan is not compiled put first
      if (s1.isPlanApproved == s2.isPlanApproved)
        return 0;
      if (s1.isPlanApproved == null || s1.isPlanApproved == 0)
        return -1;
      else if (s2.isPlanApproved == null || s2.isPlanApproved == 0)
        return 1;
      else
      {
        //if the studyplan is not aproved put second
        if (s1.isPlanApproved == 1)
          return -1;
        else if (s2.isPlanApproved == 1)
          return 1;
        else
        {
          //if the studyplan is approved put third
          return 0;
        }
      }
    }
  }

  public static class CourseCompareByDate implements Comparator<Course> {
    @Override
    public int compare (Course c1, Course c2) {
      //from most recent year to the oldest
      if (c1.academicYear<c2.academicYear)
        return 1;
      else if (c1.academicYear>c2.academicYear)
        return -1;
      //same year -> ordered by startdate
      else
      {
        //null date is the last element
        if (c1.actualStartDate == null)
          return 1;
        else if (c2.actualStartDate == null)
          return -1;
        else
          return c1.actualStartDate.compareTo(c2.actualStartDate)*-1;
      }
    }
  }

  public static class SupervisorCompareByName implements Comparator<Supervisor> {
    @Override
    public int compare (Supervisor s1, Supervisor s2) {
      int comparison = s1.lastName.compareTo(s2.lastName);
      if (comparison == 0)
      {
        return s1.firstName.compareTo(s2.firstName);
      }
      else
      {
        return comparison;
      }
    }
  }

  public static class UserCredentialsCompareByRole implements Comparator<UserCredentials> {
    @Override
      public int compare (UserCredentials uc1, UserCredentials uc2) {
      return uc1.userRol.role.compareTo(uc2.userRol.role);
    }
  }

  public static class UserCredentialsCompareByUserName implements Comparator<UserCredentials> {
    @Override
      public int compare (UserCredentials uc1, UserCredentials uc2) {
      return uc1.userName.compareTo(uc2.userName);
    }
  }
}
package models;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import play.db.ebean.*;
import play.db.ebean.Model.Finder;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name = "supervisors")
public class Supervisor extends Model {
    public static final long serialVersionUID = 1L;
    @Id
    @Column(name = "supervisor_ID")
    public Integer supervisorID;
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "first_name")
    public String firstName;
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "last_name")
    public String lastName;
    @NotNull
    @Column(name = "can_be_advisor")
    public boolean canBeAdvisor;
    @NotNull
    @Column(name = "is_active")
    public boolean isActive;
    @NotNull
    @Column(name = "is_internal")
    public boolean isInternal;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "email")
    public String email;
    @NotNull
    @Column(name = "deleted")
    public boolean deleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fundsOwner")
    public Set<Student> studentsSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tutor")
    public Set<Student> studentsSet1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currentAdvisor")
    public Set<Student> studentsAdvisored;
    @OneToMany(mappedBy = "professor")
    public Set<Course> coursesSet;
    @JoinColumn(name = "user", referencedColumnName = "user_credential_ID")
    @ManyToOne(optional = false)
    public UserCredentials user;

    public static Finder<Long,Supervisor> find = new Finder(
      Long.class, Supervisor.class
    );

    public static List<Supervisor> all() {
      return find.all();
    }

    public static List<Supervisor> allSupervisors() {
      List<Supervisor> out = new ArrayList();
      for (Supervisor s : find.all())
        if (s.getStudentsAdvisored().size() > 0) //if it is an advisor
          out.add(s);
      return out;
    }

    public static void create(Supervisor supervisor) {
      supervisor.save();
    }

    public static void delete(Long id) {
      find.ref(id).delete();
    }

    public List<Course> getCoursesSet() {
      List<Course> out = new ArrayList();
      for (Course c: this.coursesSet)
      {
        c.refresh();  // force fetching from db
        out.add(c);
      }
      return out;
    }

    public List<Course> getCurrentCourses() {
      List<Course> out = new ArrayList();
      for (Course c: this.coursesSet)
      {
        c.refresh();  // force fetching from db
        if (!c.areAllMarksDefined)
          out.add(c);
      }
      return out;
    }

    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Supervisor s: Supervisor.find.orderBy("lastName").findList()) {
            options.put(s.supervisorID.toString(), s.lastName);
        }
        return options;
    }

    public Set<Student> getStudentsAdvisored()
    {
      Set<Student> students = this.studentsAdvisored;
      for (Student s : students) {s.refresh();}//{ String a = s.firstName; }do nothing, force fetching from db
      return students;
    }

    public int getApprovalRequests()
    {
        int count = 0;
        List<Student> students = new ArrayList(this.getStudentsAdvisored());
        for (Student student : students)
        {
            if (student.waitingForApproval())
            {
                count++;
            }
        }

        return count;
    }
}

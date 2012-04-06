package models;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name = "supervisors")
public class Supervisor extends Model {
    public static final long serialVersionUID = 1L;
    @Id
    @NotNull
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
    public Collection<Student> studentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tutor")
    public Collection<Student> studentsCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currentAdvisor")
    public Collection<Student> studentsCollection2;
    @OneToMany(mappedBy = "professor")
    public Collection<Course> coursesCollection;


    public static Finder<Long,Supervisor> find = new Finder(
      Long.class, Supervisor.class
    );

    public static List<Supervisor> all() {
      return find.all();
    }
  
    public static void create(Supervisor supervisor) {
      supervisor.save();
    }

    public static void delete(Long id) {
      find.ref(id).delete();
    }    
}

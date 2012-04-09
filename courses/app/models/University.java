package models;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name = "universities")
public class University extends Model {
    public static final long serialVersionUID = 1L;
    @Id
    @Column(name = "university_ID")
    public Integer universityID;
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name_university")
    public String nameUniversity;
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "location")
    public String location;
    @NotNull
    @Column(name = "deleted")
    public boolean deleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universityOfProvenance")
    public Set<Student> studentsSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "university")
    public Set<Student> studentsSet1;
    @JoinColumn(name = "country", referencedColumnName = "country_ID")
    @ManyToOne
    public Country country;

    public static Finder<Long,University> find = new Finder(
      Long.class, University.class
    );

    public static List<University> all() {
      return find.all();
    }
  
    public static void create(University university) {
      university.save();
    }

    public static void delete(Long id) {
      find.ref(id).delete();
    }    
}

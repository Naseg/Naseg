package models;

import java.util.*;
import javax.persistence.*;
import javax.persistence.validation.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name = "universities")
public class University extends Model {
    public static final long serialVersionUID = 1L;
    @Id
    @NotNull
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
    public Collection<Student> studentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "university")
    public Collection<Student> studentsCollection1;
    @JoinColumn(name = "country", referencedColumnName = "country_ID")
    @ManyToOne
    public Country country;

}

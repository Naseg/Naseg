package models;

import java.util.*;
import javax.persistence.*;
import javax.persistence.validation.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name = "countries")
public class Country extends Model {
    public static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "country_ID")
    public Integer countryID;
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    public String name;
    @Size(min = 1, max = 200)
    @Column(name = "region")
    public String region;
    @Size(min = 1, max = 255)
    @Column(name = "citizenship")
    public String citizenship;
    @Column(name = "deleted")
    public boolean deleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryOfProvenance")
    public Collection<Student> studentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "citizenship")
    public Collection<Student> studentsCollection1;
    @OneToMany(mappedBy = "country")
    public Collection<University> universitiesCollection;

}

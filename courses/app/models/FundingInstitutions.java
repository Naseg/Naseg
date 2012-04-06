package models;

import java.util.*;
import javax.persistence.*;
import javax.persistence.validation.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name = "funding_institutions")
public class FundingInstitution extends Model {
    public static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "funding_institution_ID")
    public Integer fundinginstitutionID;
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "name")
    public String name;
    @NotNull
    @Column(name = "deleted")
    public boolean deleted;
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "type")
    public String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fundingInstitution")
    public Collection<Student> studentsCollection;

}

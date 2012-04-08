package models;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    public Set<Student> studentsSet;

    public static Finder<Long,FundingInstitution> find = new Finder(
      Long.class, FundingInstitution.class
    );

    public static List<FundingInstitution> all() {
      return find.all();
    }
  
    public static void create(FundingInstitution fundinginstitution) {
      fundinginstitution.save();
    }

    public static void delete(Long id) {
      find.ref(id).delete();
    }    
}

package models;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name = "users_roles")
public class UserRole extends Model {
    public static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "user_rol_ID")
    public Integer userrolID;
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "role")
    public String role;
    @NotNull
    @Column(name = "deleted")
    public boolean deleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRol")
    public Collection<UserCredentials> usersCredentialsCollection;


    public static Finder<Long,UserRole> find = new Finder(
      Long.class, UserRole.class
    );

    public static List<UserRole> all() {
      return find.all();
    }
  
    public static void create(UserRole userrole) {
      userrole.save();
    }

    public static void delete(Long id) {
      find.ref(id).delete();
    }    
}

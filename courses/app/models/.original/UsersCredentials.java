/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pollo
 */
@Entity
@Table(name = "users_credentials")
@NamedQueries({
    @NamedQuery(name = "UsersCredentials.findAll", query = "SELECT u FROM UsersCredentials u")})
public class UsersCredentials implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_credential_ID")
    private Integer usercredentialID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<Students> studentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<Supervisors> supervisorsCollection;
    @JoinColumn(name = "user_rol", referencedColumnName = "user_rol_ID")
    @ManyToOne(optional = false)
    private UsersRoles userRol;

    public UsersCredentials() {
    }

    public UsersCredentials(Integer usercredentialID) {
        this.usercredentialID = usercredentialID;
    }

    public UsersCredentials(Integer usercredentialID, String userName, String password) {
        this.usercredentialID = usercredentialID;
        this.userName = userName;
        this.password = password;
    }

    public Integer getUsercredentialID() {
        return usercredentialID;
    }

    public void setUsercredentialID(Integer usercredentialID) {
        this.usercredentialID = usercredentialID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Students> getStudentsCollection() {
        return studentsCollection;
    }

    public void setStudentsCollection(Collection<Students> studentsCollection) {
        this.studentsCollection = studentsCollection;
    }

    public Collection<Supervisors> getSupervisorsCollection() {
        return supervisorsCollection;
    }

    public void setSupervisorsCollection(Collection<Supervisors> supervisorsCollection) {
        this.supervisorsCollection = supervisorsCollection;
    }

    public UsersRoles getUserRol() {
        return userRol;
    }

    public void setUserRol(UsersRoles userRol) {
        this.userRol = userRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usercredentialID != null ? usercredentialID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersCredentials)) {
            return false;
        }
        UsersCredentials other = (UsersCredentials) object;
        if ((this.usercredentialID == null && other.usercredentialID != null) || (this.usercredentialID != null && !this.usercredentialID.equals(other.usercredentialID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.UsersCredentials[ usercredentialID=" + usercredentialID + " ]";
    }
    
}

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pollo
 */
@Entity
@Table(name = "users_roles")
@XmlRootElement
public class UsersRoles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_rol_ID")
    private Integer userrolID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "role")
    private String role;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted")
    private boolean deleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRol")
    private Collection<UsersCredentials> usersCredentialsCollection;

    public UsersRoles() {
    }

    public UsersRoles(Integer userrolID) {
        this.userrolID = userrolID;
    }

    public UsersRoles(Integer userrolID, String role, boolean deleted) {
        this.userrolID = userrolID;
        this.role = role;
        this.deleted = deleted;
    }

    public Integer getUserrolID() {
        return userrolID;
    }

    public void setUserrolID(Integer userrolID) {
        this.userrolID = userrolID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @XmlTransient
    public Collection<UsersCredentials> getUsersCredentialsCollection() {
        return usersCredentialsCollection;
    }

    public void setUsersCredentialsCollection(Collection<UsersCredentials> usersCredentialsCollection) {
        this.usersCredentialsCollection = usersCredentialsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userrolID != null ? userrolID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersRoles)) {
            return false;
        }
        UsersRoles other = (UsersRoles) object;
        if ((this.userrolID == null && other.userrolID != null) || (this.userrolID != null && !this.userrolID.equals(other.userrolID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UsersRoles[ userrolID=" + userrolID + " ]";
    }
    
}

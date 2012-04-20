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
@Table(name = "supervisors")
@NamedQueries({
    @NamedQuery(name = "Supervisors.findAll", query = "SELECT s FROM Supervisors s")})
public class Supervisors implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "supervisor_ID")
    private Integer supervisorID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_be_advisor")
    private boolean canBeAdvisor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean isActive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_internal")
    private boolean isInternal;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted")
    private boolean deleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fundsOwner")
    private Collection<Students> studentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tutor")
    private Collection<Students> studentsCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currentAdvisor")
    private Collection<Students> studentsCollection2;
    @OneToMany(mappedBy = "professor")
    private Collection<Courses> coursesCollection;
    @JoinColumn(name = "user", referencedColumnName = "user_credential_ID")
    @ManyToOne(optional = false)
    private UsersCredentials user;

    public Supervisors() {
    }

    public Supervisors(Integer supervisorID) {
        this.supervisorID = supervisorID;
    }

    public Supervisors(Integer supervisorID, String firstName, String lastName, boolean canBeAdvisor, boolean isActive, boolean isInternal, String email, boolean deleted) {
        this.supervisorID = supervisorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.canBeAdvisor = canBeAdvisor;
        this.isActive = isActive;
        this.isInternal = isInternal;
        this.email = email;
        this.deleted = deleted;
    }

    public Integer getSupervisorID() {
        return supervisorID;
    }

    public void setSupervisorID(Integer supervisorID) {
        this.supervisorID = supervisorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean getCanBeAdvisor() {
        return canBeAdvisor;
    }

    public void setCanBeAdvisor(boolean canBeAdvisor) {
        this.canBeAdvisor = canBeAdvisor;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean getIsInternal() {
        return isInternal;
    }

    public void setIsInternal(boolean isInternal) {
        this.isInternal = isInternal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Collection<Students> getStudentsCollection() {
        return studentsCollection;
    }

    public void setStudentsCollection(Collection<Students> studentsCollection) {
        this.studentsCollection = studentsCollection;
    }

    public Collection<Students> getStudentsCollection1() {
        return studentsCollection1;
    }

    public void setStudentsCollection1(Collection<Students> studentsCollection1) {
        this.studentsCollection1 = studentsCollection1;
    }

    public Collection<Students> getStudentsCollection2() {
        return studentsCollection2;
    }

    public void setStudentsCollection2(Collection<Students> studentsCollection2) {
        this.studentsCollection2 = studentsCollection2;
    }

    public Collection<Courses> getCoursesCollection() {
        return coursesCollection;
    }

    public void setCoursesCollection(Collection<Courses> coursesCollection) {
        this.coursesCollection = coursesCollection;
    }

    public UsersCredentials getUser() {
        return user;
    }

    public void setUser(UsersCredentials user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supervisorID != null ? supervisorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supervisors)) {
            return false;
        }
        Supervisors other = (Supervisors) object;
        if ((this.supervisorID == null && other.supervisorID != null) || (this.supervisorID != null && !this.supervisorID.equals(other.supervisorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Supervisors[ supervisorID=" + supervisorID + " ]";
    }
    
}

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
@Table(name = "universities")
@NamedQueries({
    @NamedQuery(name = "Universities.findAll", query = "SELECT u FROM Universities u")})
public class Universities implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "university_ID")
    private Integer universityID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name_university")
    private String nameUniversity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted")
    private boolean deleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universityOfProvenance")
    private Collection<Students> studentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "university")
    private Collection<Students> studentsCollection1;
    @JoinColumn(name = "country", referencedColumnName = "country_ID")
    @ManyToOne
    private Countries country;

    public Universities() {
    }

    public Universities(Integer universityID) {
        this.universityID = universityID;
    }

    public Universities(Integer universityID, String nameUniversity, String location, boolean deleted) {
        this.universityID = universityID;
        this.nameUniversity = nameUniversity;
        this.location = location;
        this.deleted = deleted;
    }

    public Integer getUniversityID() {
        return universityID;
    }

    public void setUniversityID(Integer universityID) {
        this.universityID = universityID;
    }

    public String getNameUniversity() {
        return nameUniversity;
    }

    public void setNameUniversity(String nameUniversity) {
        this.nameUniversity = nameUniversity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (universityID != null ? universityID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Universities)) {
            return false;
        }
        Universities other = (Universities) object;
        if ((this.universityID == null && other.universityID != null) || (this.universityID != null && !this.universityID.equals(other.universityID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Universities[ universityID=" + universityID + " ]";
    }
    
}

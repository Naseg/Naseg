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
@Table(name = "countries")
@XmlRootElement
public class Countries implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "country_ID")
    private Integer countryID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Size(min = 1, max = 200)
    @Column(name = "region")
    private String region;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "citizenship")
    private String citizenship;
    @Basic(optional = false)
    @Column(name = "deleted")
    private boolean deleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryOfProvenance")
    private Collection<Students> studentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "citizenship")
    private Collection<Students> studentsCollection1;
    @OneToMany(mappedBy = "country")
    private Collection<Universities> universitiesCollection;

    public Countries() {
    }

    public Countries(Integer countryID) {
        this.countryID = countryID;
    }

    public Countries(Integer countryID, String name, String region, String citizenship, boolean deleted) {
        this.countryID = countryID;
        this.name = name;
        this.region = region;
        this.citizenship = citizenship;
        this.deleted = deleted;
    }

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @XmlTransient
    public Collection<Students> getStudentsCollection() {
        return studentsCollection;
    }

    public void setStudentsCollection(Collection<Students> studentsCollection) {
        this.studentsCollection = studentsCollection;
    }

    @XmlTransient
    public Collection<Students> getStudentsCollection1() {
        return studentsCollection1;
    }

    public void setStudentsCollection1(Collection<Students> studentsCollection1) {
        this.studentsCollection1 = studentsCollection1;
    }

    @XmlTransient
    public Collection<Universities> getUniversitiesCollection() {
        return universitiesCollection;
    }

    public void setUniversitiesCollection(Collection<Universities> universitiesCollection) {
        this.universitiesCollection = universitiesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryID != null ? countryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Countries)) {
            return false;
        }
        Countries other = (Countries) object;
        if ((this.countryID == null && other.countryID != null) || (this.countryID != null && !this.countryID.equals(other.countryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Countries[ countryID=" + countryID + " ]";
    }
    
}

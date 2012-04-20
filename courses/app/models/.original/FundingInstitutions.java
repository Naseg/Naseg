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
@Table(name = "funding_institutions")
@NamedQueries({
    @NamedQuery(name = "FundingInstitutions.findAll", query = "SELECT f FROM FundingInstitutions f")})
public class FundingInstitutions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "funding_institution_ID")
    private Integer fundinginstitutionID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted")
    private boolean deleted;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "type")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fundingInstitution")
    private Collection<Students> studentsCollection;

    public FundingInstitutions() {
    }

    public FundingInstitutions(Integer fundinginstitutionID) {
        this.fundinginstitutionID = fundinginstitutionID;
    }

    public FundingInstitutions(Integer fundinginstitutionID, String name, boolean deleted, String type) {
        this.fundinginstitutionID = fundinginstitutionID;
        this.name = name;
        this.deleted = deleted;
        this.type = type;
    }

    public Integer getFundinginstitutionID() {
        return fundinginstitutionID;
    }

    public void setFundinginstitutionID(Integer fundinginstitutionID) {
        this.fundinginstitutionID = fundinginstitutionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<Students> getStudentsCollection() {
        return studentsCollection;
    }

    public void setStudentsCollection(Collection<Students> studentsCollection) {
        this.studentsCollection = studentsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fundinginstitutionID != null ? fundinginstitutionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FundingInstitutions)) {
            return false;
        }
        FundingInstitutions other = (FundingInstitutions) object;
        if ((this.fundinginstitutionID == null && other.fundinginstitutionID != null) || (this.fundinginstitutionID != null && !this.fundinginstitutionID.equals(other.fundinginstitutionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.FundingInstitutions[ fundinginstitutionID=" + fundinginstitutionID + " ]";
    }
    
}

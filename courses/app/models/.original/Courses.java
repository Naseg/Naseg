/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "courses")
@XmlRootElement
public class Courses implements Serializable {
    @Column(name = "actual_start_date")
    @Temporal(TemporalType.DATE)
    private Date actualStartDate;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "course_ID")
    private Integer courseID;
    @Lob
    @Size(max = 65535)
    @Column(name = "notes")
    private String notes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "institution")
    private String institution;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "place")
    private String place;
    @Column(name = "credits")
    private Integer credits;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "course_name")
    private String courseName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "academic_year")
    private int academicYear;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_in_manifesto")
    private boolean isInManifesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_by_UNITN")
    private boolean isbyUNITN;
    @Column(name = "is_paid")
    private Boolean isPaid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "budgeted_cost")
    private int budgetedCost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actual_cost")
    private int actualCost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "planned_course_period")
    private String plannedCoursePeriod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "are_all_marks_defined")
    private boolean areAllMarksDefined;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_payment_completed")
    private boolean isPaymentCompleted;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted")
    private boolean deleted;
    @JoinColumn(name = "professor", referencedColumnName = "supervisor_ID")
    @ManyToOne
    private Supervisors professor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private Collection<CoursesEnrollments> coursesEnrollmentsCollection;

    public Courses() {
    }

    public Courses(Integer courseID) {
        this.courseID = courseID;
    }

    public Courses(Integer courseID, String institution, String place, String courseName, int academicYear, boolean isInManifesto, boolean isbyUNITN, int budgetedCost, int actualCost, String plannedCoursePeriod, boolean areAllMarksDefined, String url, boolean isPaymentCompleted, boolean deleted) {
        this.courseID = courseID;
        this.institution = institution;
        this.place = place;
        this.courseName = courseName;
        this.academicYear = academicYear;
        this.isInManifesto = isInManifesto;
        this.isbyUNITN = isbyUNITN;
        this.budgetedCost = budgetedCost;
        this.actualCost = actualCost;
        this.plannedCoursePeriod = plannedCoursePeriod;
        this.areAllMarksDefined = areAllMarksDefined;
        this.url = url;
        this.isPaymentCompleted = isPaymentCompleted;
        this.deleted = deleted;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getActualStartDate() {
        return actualStartDate;
    }

    public void setActualStartDate(Date actualStartDate) {
        this.actualStartDate = actualStartDate;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public boolean getIsInManifesto() {
        return isInManifesto;
    }

    public void setIsInManifesto(boolean isInManifesto) {
        this.isInManifesto = isInManifesto;
    }

    public boolean getIsbyUNITN() {
        return isbyUNITN;
    }

    public void setIsbyUNITN(boolean isbyUNITN) {
        this.isbyUNITN = isbyUNITN;
    }

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    public int getBudgetedCost() {
        return budgetedCost;
    }

    public void setBudgetedCost(int budgetedCost) {
        this.budgetedCost = budgetedCost;
    }

    public int getActualCost() {
        return actualCost;
    }

    public void setActualCost(int actualCost) {
        this.actualCost = actualCost;
    }

    public String getPlannedCoursePeriod() {
        return plannedCoursePeriod;
    }

    public void setPlannedCoursePeriod(String plannedCoursePeriod) {
        this.plannedCoursePeriod = plannedCoursePeriod;
    }

    public boolean getAreAllMarksDefined() {
        return areAllMarksDefined;
    }

    public void setAreAllMarksDefined(boolean areAllMarksDefined) {
        this.areAllMarksDefined = areAllMarksDefined;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean getIsPaymentCompleted() {
        return isPaymentCompleted;
    }

    public void setIsPaymentCompleted(boolean isPaymentCompleted) {
        this.isPaymentCompleted = isPaymentCompleted;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Supervisors getProfessor() {
        return professor;
    }

    public void setProfessor(Supervisors professor) {
        this.professor = professor;
    }

    @XmlTransient
    public Collection<CoursesEnrollments> getCoursesEnrollmentsCollection() {
        return coursesEnrollmentsCollection;
    }

    public void setCoursesEnrollmentsCollection(Collection<CoursesEnrollments> coursesEnrollmentsCollection) {
        this.coursesEnrollmentsCollection = coursesEnrollmentsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseID != null ? courseID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Courses)) {
            return false;
        }
        Courses other = (Courses) object;
        if ((this.courseID == null && other.courseID != null) || (this.courseID != null && !this.courseID.equals(other.courseID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Courses[ courseID=" + courseID + " ]";
    }

    public Date getActualStartDate() {
        return actualStartDate;
    }

    public void setActualStartDate(Date actualStartDate) {
        this.actualStartDate = actualStartDate;
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pollo
 */
@Entity
@Table(name = "courses_enrollments")
@NamedQueries({
    @NamedQuery(name = "CoursesEnrollments.findAll", query = "SELECT c FROM CoursesEnrollments c")})
public class CoursesEnrollments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "enrollment_ID")
    private Integer enrollmentID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "qualification")
    private String qualification;
    @Column(name = "is_finished")
    private Boolean isFinished;
    @Column(name = "credits")
    private Integer credits;
    @Column(name = "enrolled_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enrolledAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "approved_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedAt;
    @JoinColumn(name = "student", referencedColumnName = "user_ID")
    @ManyToOne(optional = false)
    private Students student;
    @JoinColumn(name = "course", referencedColumnName = "course_ID")
    @ManyToOne(optional = false)
    private Courses course;

    public CoursesEnrollments() {
    }

    public CoursesEnrollments(Integer enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public CoursesEnrollments(Integer enrollmentID, String qualification) {
        this.enrollmentID = enrollmentID;
        this.qualification = qualification;
    }

    public Integer getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(Integer enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Boolean getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Boolean isFinished) {
        this.isFinished = isFinished;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Date getEnrolledAt() {
        return enrolledAt;
    }

    public void setEnrolledAt(Date enrolledAt) {
        this.enrolledAt = enrolledAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getApprovedAt() {
        return approvedAt;
    }

    public void setApprovedAt(Date approvedAt) {
        this.approvedAt = approvedAt;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enrollmentID != null ? enrollmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoursesEnrollments)) {
            return false;
        }
        CoursesEnrollments other = (CoursesEnrollments) object;
        if ((this.enrollmentID == null && other.enrollmentID != null) || (this.enrollmentID != null && !this.enrollmentID.equals(other.enrollmentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.CoursesEnrollments[ enrollmentID=" + enrollmentID + " ]";
    }
    
}

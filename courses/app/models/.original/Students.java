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

/**
 *
 * @author pollo
 */
@Entity
@Table(name = "students")
@NamedQueries({
    @NamedQuery(name = "Students.findAll", query = "SELECT s FROM Students s")})
public class Students implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_ID")
    private Integer userID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "full_name")
    private String fullName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "phd_cycle")
    private String phdCycle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_suspended")
    private boolean isSuspended;
    @Basic(optional = false)
    @NotNull
    @Column(name = "course_year")
    private int courseYear;
    @Basic(optional = false)
    @NotNull
    @Column(name = "admitted_conditionally")
    private boolean admittedConditionally;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "legal_residence")
    private String legalResidence;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "current_domicile")
    private String currentDomicile;
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "place_of_birth")
    private String placeOfBirth;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "office_phone")
    private String officePhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "office_working_place")
    private String officeWorkingPlace;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "locker_number")
    private String lockerNumber;
    @Column(name = "phd_scholarship")
    private Boolean phdScholarship;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "scholarship_type")
    private String scholarshipType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "yearly_fee_to_center")
    private int yearlyFeeToCenter;
    @Basic(optional = false)
    @NotNull
    @Column(name = "yearly_fee_to_school")
    private int yearlyFeeToSchool;
    @Basic(optional = false)
    @NotNull
    @Column(name = "has_pc_rights")
    private boolean hasPcRights;
    @Size(max = 500)
    @Column(name = "pre_doctoral_scholarship")
    private String preDoctoralScholarship;
    @Basic(optional = false)
    @NotNull
    @Column(name = "months_predoc_scholarship")
    private int monthsPredocScholarship;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "year_extension_scholarship")
    private String yearExtensionScholarship;
    @Basic(optional = false)
    @NotNull
    @Column(name = "months")
    private int months;
    @Basic(optional = false)
    @NotNull
    @Column(name = "personal_funds_available")
    private int personalFundsAvailable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_graduated")
    private boolean isGraduated;
    @Column(name = "graduation_date")
    @Temporal(TemporalType.DATE)
    private Date graduationDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "commitee_members")
    private String commiteeMembers;
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
    @Column(name = "Italian_Taxpayer_Code")
    private Integer italianTaxpayerCode;
    @Size(max = 255)
    @Column(name = "photo_profile")
    private String photoProfile;
    @Column(name = "is_plan_approved")
    private Short isPlanApproved;
    @JoinColumn(name = "user", referencedColumnName = "user_credential_ID")
    @ManyToOne(optional = false)
    private UsersCredentials user;
    @JoinColumn(name = "university_of_provenance", referencedColumnName = "university_ID")
    @ManyToOne(optional = false)
    private Universities universityOfProvenance;
    @JoinColumn(name = "university", referencedColumnName = "university_ID")
    @ManyToOne(optional = false)
    private Universities university;
    @JoinColumn(name = "funding_institution", referencedColumnName = "funding_institution_ID")
    @ManyToOne(optional = false)
    private FundingInstitutions fundingInstitution;
    @JoinColumn(name = "country_of_provenance", referencedColumnName = "country_ID")
    @ManyToOne(optional = false)
    private Countries countryOfProvenance;
    @JoinColumn(name = "citizenship", referencedColumnName = "country_ID")
    @ManyToOne(optional = false)
    private Countries citizenship;
    @JoinColumn(name = "funds_owner", referencedColumnName = "supervisor_ID")
    @ManyToOne(optional = false)
    private Supervisors fundsOwner;
    @JoinColumn(name = "tutor", referencedColumnName = "supervisor_ID")
    @ManyToOne(optional = false)
    private Supervisors tutor;
    @JoinColumn(name = "current_advisor", referencedColumnName = "supervisor_ID")
    @ManyToOne(optional = false)
    private Supervisors currentAdvisor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Collection<Trips> tripsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Collection<CoursesEnrollments> coursesEnrollmentsCollection;

    public Students() {
    }

    public Students(Integer userID) {
        this.userID = userID;
    }

    public Students(Integer userID, String firstName, String lastName, String fullName, String phdCycle, boolean isSuspended, int courseYear, boolean admittedConditionally, String legalResidence, String currentDomicile, String placeOfBirth, String officePhone, String mobilePhone, String officeWorkingPlace, String lockerNumber, String scholarshipType, int yearlyFeeToCenter, int yearlyFeeToSchool, boolean hasPcRights, int monthsPredocScholarship, String yearExtensionScholarship, int months, int personalFundsAvailable, boolean isGraduated, String commiteeMembers, String email, boolean deleted) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.phdCycle = phdCycle;
        this.isSuspended = isSuspended;
        this.courseYear = courseYear;
        this.admittedConditionally = admittedConditionally;
        this.legalResidence = legalResidence;
        this.currentDomicile = currentDomicile;
        this.placeOfBirth = placeOfBirth;
        this.officePhone = officePhone;
        this.mobilePhone = mobilePhone;
        this.officeWorkingPlace = officeWorkingPlace;
        this.lockerNumber = lockerNumber;
        this.scholarshipType = scholarshipType;
        this.yearlyFeeToCenter = yearlyFeeToCenter;
        this.yearlyFeeToSchool = yearlyFeeToSchool;
        this.hasPcRights = hasPcRights;
        this.monthsPredocScholarship = monthsPredocScholarship;
        this.yearExtensionScholarship = yearExtensionScholarship;
        this.months = months;
        this.personalFundsAvailable = personalFundsAvailable;
        this.isGraduated = isGraduated;
        this.commiteeMembers = commiteeMembers;
        this.email = email;
        this.deleted = deleted;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhdCycle() {
        return phdCycle;
    }

    public void setPhdCycle(String phdCycle) {
        this.phdCycle = phdCycle;
    }

    public boolean getIsSuspended() {
        return isSuspended;
    }

    public void setIsSuspended(boolean isSuspended) {
        this.isSuspended = isSuspended;
    }

    public int getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(int courseYear) {
        this.courseYear = courseYear;
    }

    public boolean getAdmittedConditionally() {
        return admittedConditionally;
    }

    public void setAdmittedConditionally(boolean admittedConditionally) {
        this.admittedConditionally = admittedConditionally;
    }

    public String getLegalResidence() {
        return legalResidence;
    }

    public void setLegalResidence(String legalResidence) {
        this.legalResidence = legalResidence;
    }

    public String getCurrentDomicile() {
        return currentDomicile;
    }

    public void setCurrentDomicile(String currentDomicile) {
        this.currentDomicile = currentDomicile;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getOfficeWorkingPlace() {
        return officeWorkingPlace;
    }

    public void setOfficeWorkingPlace(String officeWorkingPlace) {
        this.officeWorkingPlace = officeWorkingPlace;
    }

    public String getLockerNumber() {
        return lockerNumber;
    }

    public void setLockerNumber(String lockerNumber) {
        this.lockerNumber = lockerNumber;
    }

    public Boolean getPhdScholarship() {
        return phdScholarship;
    }

    public void setPhdScholarship(Boolean phdScholarship) {
        this.phdScholarship = phdScholarship;
    }

    public String getScholarshipType() {
        return scholarshipType;
    }

    public void setScholarshipType(String scholarshipType) {
        this.scholarshipType = scholarshipType;
    }

    public int getYearlyFeeToCenter() {
        return yearlyFeeToCenter;
    }

    public void setYearlyFeeToCenter(int yearlyFeeToCenter) {
        this.yearlyFeeToCenter = yearlyFeeToCenter;
    }

    public int getYearlyFeeToSchool() {
        return yearlyFeeToSchool;
    }

    public void setYearlyFeeToSchool(int yearlyFeeToSchool) {
        this.yearlyFeeToSchool = yearlyFeeToSchool;
    }

    public boolean getHasPcRights() {
        return hasPcRights;
    }

    public void setHasPcRights(boolean hasPcRights) {
        this.hasPcRights = hasPcRights;
    }

    public String getPreDoctoralScholarship() {
        return preDoctoralScholarship;
    }

    public void setPreDoctoralScholarship(String preDoctoralScholarship) {
        this.preDoctoralScholarship = preDoctoralScholarship;
    }

    public int getMonthsPredocScholarship() {
        return monthsPredocScholarship;
    }

    public void setMonthsPredocScholarship(int monthsPredocScholarship) {
        this.monthsPredocScholarship = monthsPredocScholarship;
    }

    public String getYearExtensionScholarship() {
        return yearExtensionScholarship;
    }

    public void setYearExtensionScholarship(String yearExtensionScholarship) {
        this.yearExtensionScholarship = yearExtensionScholarship;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public int getPersonalFundsAvailable() {
        return personalFundsAvailable;
    }

    public void setPersonalFundsAvailable(int personalFundsAvailable) {
        this.personalFundsAvailable = personalFundsAvailable;
    }

    public boolean getIsGraduated() {
        return isGraduated;
    }

    public void setIsGraduated(boolean isGraduated) {
        this.isGraduated = isGraduated;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getCommiteeMembers() {
        return commiteeMembers;
    }

    public void setCommiteeMembers(String commiteeMembers) {
        this.commiteeMembers = commiteeMembers;
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

    public Integer getItalianTaxpayerCode() {
        return italianTaxpayerCode;
    }

    public void setItalianTaxpayerCode(Integer italianTaxpayerCode) {
        this.italianTaxpayerCode = italianTaxpayerCode;
    }

    public String getPhotoProfile() {
        return photoProfile;
    }

    public void setPhotoProfile(String photoProfile) {
        this.photoProfile = photoProfile;
    }

    public Short getIsPlanApproved() {
        return isPlanApproved;
    }

    public void setIsPlanApproved(Short isPlanApproved) {
        this.isPlanApproved = isPlanApproved;
    }

    public UsersCredentials getUser() {
        return user;
    }

    public void setUser(UsersCredentials user) {
        this.user = user;
    }

    public Universities getUniversityOfProvenance() {
        return universityOfProvenance;
    }

    public void setUniversityOfProvenance(Universities universityOfProvenance) {
        this.universityOfProvenance = universityOfProvenance;
    }

    public Universities getUniversity() {
        return university;
    }

    public void setUniversity(Universities university) {
        this.university = university;
    }

    public FundingInstitutions getFundingInstitution() {
        return fundingInstitution;
    }

    public void setFundingInstitution(FundingInstitutions fundingInstitution) {
        this.fundingInstitution = fundingInstitution;
    }

    public Countries getCountryOfProvenance() {
        return countryOfProvenance;
    }

    public void setCountryOfProvenance(Countries countryOfProvenance) {
        this.countryOfProvenance = countryOfProvenance;
    }

    public Countries getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Countries citizenship) {
        this.citizenship = citizenship;
    }

    public Supervisors getFundsOwner() {
        return fundsOwner;
    }

    public void setFundsOwner(Supervisors fundsOwner) {
        this.fundsOwner = fundsOwner;
    }

    public Supervisors getTutor() {
        return tutor;
    }

    public void setTutor(Supervisors tutor) {
        this.tutor = tutor;
    }

    public Supervisors getCurrentAdvisor() {
        return currentAdvisor;
    }

    public void setCurrentAdvisor(Supervisors currentAdvisor) {
        this.currentAdvisor = currentAdvisor;
    }

    public Collection<Trips> getTripsCollection() {
        return tripsCollection;
    }

    public void setTripsCollection(Collection<Trips> tripsCollection) {
        this.tripsCollection = tripsCollection;
    }

    public Collection<CoursesEnrollments> getCoursesEnrollmentsCollection() {
        return coursesEnrollmentsCollection;
    }

    public void setCoursesEnrollmentsCollection(Collection<CoursesEnrollments> coursesEnrollmentsCollection) {
        this.coursesEnrollmentsCollection = coursesEnrollmentsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Students)) {
            return false;
        }
        Students other = (Students) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Students[ userID=" + userID + " ]";
    }
    
}

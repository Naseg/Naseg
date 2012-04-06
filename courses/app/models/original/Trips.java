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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pollo
 */
@Entity
@Table(name = "trips")
@XmlRootElement
public class Trips implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Planned_start_date")
    @Temporal(TemporalType.DATE)
    private Date plannedstartdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Planned_end_date")
    @Temporal(TemporalType.DATE)
    private Date plannedenddate;
    @Column(name = "actual_begin_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualBeginDateTime;
    @Column(name = "actual_end_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualEndDateTime;
    @Column(name = "departure_border_cross_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureBorderCrossDatetime;
    @Column(name = "arrival_border_cross_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalBorderCrossDatetime;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "date_reim_request_submitted")
    @Temporal(TemporalType.DATE)
    private Date dateReimRequestSubmitted;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "trip_ID")
    private Integer tripID;
    @Column(name = "academic_year_id")
    private Integer academicYearId;
    @Column(name = "Date_of_request")
    private Integer dateofrequest;
    @Size(max = 255)
    @Column(name = "Planned_Reason_for_Travel")
    private String plannedReasonforTravel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "status")
    private String status;
    @Size(max = 255)
    @Column(name = "Planned_destination")
    private String planneddestination;
    @Size(max = 255)
    @Column(name = "Planned_means_of_transport")
    private String plannedmeansoftransport;
    @Column(name = "is_stopover_requested")
    private Boolean isStopoverRequested;
    @Size(max = 255)
    @Column(name = "Reason_for_extraordinary_transport")
    private String reasonforextraordinarytransport;
    @Size(max = 255)
    @Column(name = "Reason_for_stopover")
    private String reasonforstopover;
    @Size(max = 20)
    @Column(name = "type_of_transportation")
    private String typeOfTransportation;
    @Column(name = "is_approved")
    private Boolean isApproved;
    @Column(name = "are_personal_funds_used")
    private Boolean arePersonalFundsUsed;
    @Column(name = "personal_funds_amount")
    private Integer personalFundsAmount;
    @Size(max = 100)
    @Column(name = "alternative_fund_1_name")
    private String alternativeFund1Name;
    @Column(name = "alternative_fund_1_manager")
    private Integer alternativeFund1Manager;
    @Column(name = "alternative_fund_1_amount")
    private Integer alternativeFund1Amount;
    @Size(max = 100)
    @Column(name = "alternative_fund_2_name")
    private String alternativeFund2Name;
    @Column(name = "alternative_fund_2_amount")
    private Integer alternativeFund2Amount;
    @Column(name = "alternative_fund_2_manager")
    private Integer alternativeFund2Manager;
    @Basic(optional = false)
    @NotNull
    @Column(name = "has_advisor_approved")
    private boolean hasAdvisorApproved;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "foreseen_meals_cost")
    private Float foreseenMealsCost;
    @Column(name = "foreseen_lodging_cost")
    private Float foreseenLodgingCost;
    @Column(name = "foreseen_transportation_cost")
    private Float foreseenTransportationCost;
    @Column(name = "expenses_sustained_before_trip")
    private Float expensesSustainedBeforeTrip;
    @Column(name = "is_advance_payment_requested")
    private Boolean isAdvancePaymentRequested;
    @Size(max = 255)
    @Column(name = "actual_destination")
    private String actualDestination;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "current_address")
    private String currentAddress;
    @Column(name = "advance_payment_received")
    private Float advancePaymentReceived;
    @Size(max = 100)
    @Column(name = "requested_payment_method")
    private String requestedPaymentMethod;
    @Lob
    @Size(max = 65535)
    @Column(name = "self_declaration_missing_recepits")
    private String selfDeclarationMissingRecepits;
    @Lob
    @Size(max = 65535)
    @Column(name = "other_declarations")
    private String otherDeclarations;
    @Lob
    @Size(max = 65535)
    @Column(name = "Travel_tickets")
    private String traveltickets;
    @Column(name = "personal_veichle_KM_travelled")
    private Integer personalveichleKMtravelled;
    @Size(max = 255)
    @Column(name = "personal_veichle_colleagues")
    private String personalVeichleColleagues;
    @Column(name = "highway_toll_fees")
    private Float highwayTollFees;
    @Column(name = "total_transport_expenses")
    private Float totalTransportExpenses;
    @Column(name = "total_lodging_expenses")
    private Float totalLodgingExpenses;
    @Column(name = "number_of_nights")
    private Integer numberOfNights;
    @Column(name = "num_lodging_receipts")
    private Integer numLodgingReceipts;
    @Column(name = "num_meals_invoices")
    private Integer numMealsInvoices;
    @Column(name = "num_days_of_meals")
    private Integer numDaysOfMeals;
    @Column(name = "total_meal_expenses")
    private Float totalMealExpenses;
    @Column(name = "registration_fee")
    private Float registrationFee;
    @Column(name = "other_costs_amount")
    private Float otherCostsAmount;
    @Column(name = "other_costs_description")
    private Integer otherCostsDescription;
    @Column(name = "total_expenses")
    private Float totalExpenses;
    @Column(name = "reimb_transport_expenses")
    private Float reimbTransportExpenses;
    @Column(name = "reimb_lodging_expenses")
    private Float reimbLodgingExpenses;
    @Column(name = "reimb_extra_costs")
    private Float reimbExtraCosts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted")
    private boolean deleted;
    @Basic(optional = false)
    @NotNull
    @Column(name = "has_coord_approved")
    private boolean hasCoordApproved;
    @Basic(optional = false)
    @NotNull
    @Column(name = "has_fund_1_mgr_approved")
    private boolean hasFund1MgrApproved;
    @Basic(optional = false)
    @NotNull
    @Column(name = "has_fund_2_mgr_approved")
    private boolean hasFund2MgrApproved;
    @JoinColumn(name = "student", referencedColumnName = "user_ID")
    @ManyToOne(optional = false)
    private Students student;

    public Trips() {
    }

    public Trips(Integer tripID) {
        this.tripID = tripID;
    }

    public Trips(Integer tripID, Date plannedstartdate, String status, Date plannedenddate, boolean hasAdvisorApproved, String currentAddress, boolean deleted, boolean hasCoordApproved, boolean hasFund1MgrApproved, boolean hasFund2MgrApproved) {
        this.tripID = tripID;
        this.plannedstartdate = plannedstartdate;
        this.status = status;
        this.plannedenddate = plannedenddate;
        this.hasAdvisorApproved = hasAdvisorApproved;
        this.currentAddress = currentAddress;
        this.deleted = deleted;
        this.hasCoordApproved = hasCoordApproved;
        this.hasFund1MgrApproved = hasFund1MgrApproved;
        this.hasFund2MgrApproved = hasFund2MgrApproved;
    }

    public Integer getTripID() {
        return tripID;
    }

    public void setTripID(Integer tripID) {
        this.tripID = tripID;
    }

    public Integer getAcademicYearId() {
        return academicYearId;
    }

    public void setAcademicYearId(Integer academicYearId) {
        this.academicYearId = academicYearId;
    }

    public Integer getDateofrequest() {
        return dateofrequest;
    }

    public void setDateofrequest(Integer dateofrequest) {
        this.dateofrequest = dateofrequest;
    }

    public Date getPlannedstartdate() {
        return plannedstartdate;
    }

    public void setPlannedstartdate(Date plannedstartdate) {
        this.plannedstartdate = plannedstartdate;
    }

    public String getPlannedReasonforTravel() {
        return plannedReasonforTravel;
    }

    public void setPlannedReasonforTravel(String plannedReasonforTravel) {
        this.plannedReasonforTravel = plannedReasonforTravel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPlannedenddate() {
        return plannedenddate;
    }

    public void setPlannedenddate(Date plannedenddate) {
        this.plannedenddate = plannedenddate;
    }

    public String getPlanneddestination() {
        return planneddestination;
    }

    public void setPlanneddestination(String planneddestination) {
        this.planneddestination = planneddestination;
    }

    public String getPlannedmeansoftransport() {
        return plannedmeansoftransport;
    }

    public void setPlannedmeansoftransport(String plannedmeansoftransport) {
        this.plannedmeansoftransport = plannedmeansoftransport;
    }

    public Boolean getIsStopoverRequested() {
        return isStopoverRequested;
    }

    public void setIsStopoverRequested(Boolean isStopoverRequested) {
        this.isStopoverRequested = isStopoverRequested;
    }

    public String getReasonforextraordinarytransport() {
        return reasonforextraordinarytransport;
    }

    public void setReasonforextraordinarytransport(String reasonforextraordinarytransport) {
        this.reasonforextraordinarytransport = reasonforextraordinarytransport;
    }

    public String getReasonforstopover() {
        return reasonforstopover;
    }

    public void setReasonforstopover(String reasonforstopover) {
        this.reasonforstopover = reasonforstopover;
    }

    public String getTypeOfTransportation() {
        return typeOfTransportation;
    }

    public void setTypeOfTransportation(String typeOfTransportation) {
        this.typeOfTransportation = typeOfTransportation;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public Boolean getArePersonalFundsUsed() {
        return arePersonalFundsUsed;
    }

    public void setArePersonalFundsUsed(Boolean arePersonalFundsUsed) {
        this.arePersonalFundsUsed = arePersonalFundsUsed;
    }

    public Integer getPersonalFundsAmount() {
        return personalFundsAmount;
    }

    public void setPersonalFundsAmount(Integer personalFundsAmount) {
        this.personalFundsAmount = personalFundsAmount;
    }

    public String getAlternativeFund1Name() {
        return alternativeFund1Name;
    }

    public void setAlternativeFund1Name(String alternativeFund1Name) {
        this.alternativeFund1Name = alternativeFund1Name;
    }

    public Integer getAlternativeFund1Manager() {
        return alternativeFund1Manager;
    }

    public void setAlternativeFund1Manager(Integer alternativeFund1Manager) {
        this.alternativeFund1Manager = alternativeFund1Manager;
    }

    public Integer getAlternativeFund1Amount() {
        return alternativeFund1Amount;
    }

    public void setAlternativeFund1Amount(Integer alternativeFund1Amount) {
        this.alternativeFund1Amount = alternativeFund1Amount;
    }

    public String getAlternativeFund2Name() {
        return alternativeFund2Name;
    }

    public void setAlternativeFund2Name(String alternativeFund2Name) {
        this.alternativeFund2Name = alternativeFund2Name;
    }

    public Integer getAlternativeFund2Amount() {
        return alternativeFund2Amount;
    }

    public void setAlternativeFund2Amount(Integer alternativeFund2Amount) {
        this.alternativeFund2Amount = alternativeFund2Amount;
    }

    public Integer getAlternativeFund2Manager() {
        return alternativeFund2Manager;
    }

    public void setAlternativeFund2Manager(Integer alternativeFund2Manager) {
        this.alternativeFund2Manager = alternativeFund2Manager;
    }

    public boolean getHasAdvisorApproved() {
        return hasAdvisorApproved;
    }

    public void setHasAdvisorApproved(boolean hasAdvisorApproved) {
        this.hasAdvisorApproved = hasAdvisorApproved;
    }

    public Float getForeseenMealsCost() {
        return foreseenMealsCost;
    }

    public void setForeseenMealsCost(Float foreseenMealsCost) {
        this.foreseenMealsCost = foreseenMealsCost;
    }

    public Float getForeseenLodgingCost() {
        return foreseenLodgingCost;
    }

    public void setForeseenLodgingCost(Float foreseenLodgingCost) {
        this.foreseenLodgingCost = foreseenLodgingCost;
    }

    public Float getForeseenTransportationCost() {
        return foreseenTransportationCost;
    }

    public void setForeseenTransportationCost(Float foreseenTransportationCost) {
        this.foreseenTransportationCost = foreseenTransportationCost;
    }

    public Float getExpensesSustainedBeforeTrip() {
        return expensesSustainedBeforeTrip;
    }

    public void setExpensesSustainedBeforeTrip(Float expensesSustainedBeforeTrip) {
        this.expensesSustainedBeforeTrip = expensesSustainedBeforeTrip;
    }

    public Boolean getIsAdvancePaymentRequested() {
        return isAdvancePaymentRequested;
    }

    public void setIsAdvancePaymentRequested(Boolean isAdvancePaymentRequested) {
        this.isAdvancePaymentRequested = isAdvancePaymentRequested;
    }

    public Date getActualBeginDateTime() {
        return actualBeginDateTime;
    }

    public void setActualBeginDateTime(Date actualBeginDateTime) {
        this.actualBeginDateTime = actualBeginDateTime;
    }

    public Date getActualEndDateTime() {
        return actualEndDateTime;
    }

    public void setActualEndDateTime(Date actualEndDateTime) {
        this.actualEndDateTime = actualEndDateTime;
    }

    public Date getDepartureBorderCrossDatetime() {
        return departureBorderCrossDatetime;
    }

    public void setDepartureBorderCrossDatetime(Date departureBorderCrossDatetime) {
        this.departureBorderCrossDatetime = departureBorderCrossDatetime;
    }

    public Date getArrivalBorderCrossDatetime() {
        return arrivalBorderCrossDatetime;
    }

    public void setArrivalBorderCrossDatetime(Date arrivalBorderCrossDatetime) {
        this.arrivalBorderCrossDatetime = arrivalBorderCrossDatetime;
    }

    public String getActualDestination() {
        return actualDestination;
    }

    public void setActualDestination(String actualDestination) {
        this.actualDestination = actualDestination;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public Float getAdvancePaymentReceived() {
        return advancePaymentReceived;
    }

    public void setAdvancePaymentReceived(Float advancePaymentReceived) {
        this.advancePaymentReceived = advancePaymentReceived;
    }

    public String getRequestedPaymentMethod() {
        return requestedPaymentMethod;
    }

    public void setRequestedPaymentMethod(String requestedPaymentMethod) {
        this.requestedPaymentMethod = requestedPaymentMethod;
    }

    public String getSelfDeclarationMissingRecepits() {
        return selfDeclarationMissingRecepits;
    }

    public void setSelfDeclarationMissingRecepits(String selfDeclarationMissingRecepits) {
        this.selfDeclarationMissingRecepits = selfDeclarationMissingRecepits;
    }

    public String getOtherDeclarations() {
        return otherDeclarations;
    }

    public void setOtherDeclarations(String otherDeclarations) {
        this.otherDeclarations = otherDeclarations;
    }

    public String getTraveltickets() {
        return traveltickets;
    }

    public void setTraveltickets(String traveltickets) {
        this.traveltickets = traveltickets;
    }

    public Integer getPersonalveichleKMtravelled() {
        return personalveichleKMtravelled;
    }

    public void setPersonalveichleKMtravelled(Integer personalveichleKMtravelled) {
        this.personalveichleKMtravelled = personalveichleKMtravelled;
    }

    public String getPersonalVeichleColleagues() {
        return personalVeichleColleagues;
    }

    public void setPersonalVeichleColleagues(String personalVeichleColleagues) {
        this.personalVeichleColleagues = personalVeichleColleagues;
    }

    public Float getHighwayTollFees() {
        return highwayTollFees;
    }

    public void setHighwayTollFees(Float highwayTollFees) {
        this.highwayTollFees = highwayTollFees;
    }

    public Float getTotalTransportExpenses() {
        return totalTransportExpenses;
    }

    public void setTotalTransportExpenses(Float totalTransportExpenses) {
        this.totalTransportExpenses = totalTransportExpenses;
    }

    public Float getTotalLodgingExpenses() {
        return totalLodgingExpenses;
    }

    public void setTotalLodgingExpenses(Float totalLodgingExpenses) {
        this.totalLodgingExpenses = totalLodgingExpenses;
    }

    public Integer getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(Integer numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public Integer getNumLodgingReceipts() {
        return numLodgingReceipts;
    }

    public void setNumLodgingReceipts(Integer numLodgingReceipts) {
        this.numLodgingReceipts = numLodgingReceipts;
    }

    public Integer getNumMealsInvoices() {
        return numMealsInvoices;
    }

    public void setNumMealsInvoices(Integer numMealsInvoices) {
        this.numMealsInvoices = numMealsInvoices;
    }

    public Integer getNumDaysOfMeals() {
        return numDaysOfMeals;
    }

    public void setNumDaysOfMeals(Integer numDaysOfMeals) {
        this.numDaysOfMeals = numDaysOfMeals;
    }

    public Float getTotalMealExpenses() {
        return totalMealExpenses;
    }

    public void setTotalMealExpenses(Float totalMealExpenses) {
        this.totalMealExpenses = totalMealExpenses;
    }

    public Float getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(Float registrationFee) {
        this.registrationFee = registrationFee;
    }

    public Float getOtherCostsAmount() {
        return otherCostsAmount;
    }

    public void setOtherCostsAmount(Float otherCostsAmount) {
        this.otherCostsAmount = otherCostsAmount;
    }

    public Integer getOtherCostsDescription() {
        return otherCostsDescription;
    }

    public void setOtherCostsDescription(Integer otherCostsDescription) {
        this.otherCostsDescription = otherCostsDescription;
    }

    public Float getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(Float totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Float getReimbTransportExpenses() {
        return reimbTransportExpenses;
    }

    public void setReimbTransportExpenses(Float reimbTransportExpenses) {
        this.reimbTransportExpenses = reimbTransportExpenses;
    }

    public Date getDateReimRequestSubmitted() {
        return dateReimRequestSubmitted;
    }

    public void setDateReimRequestSubmitted(Date dateReimRequestSubmitted) {
        this.dateReimRequestSubmitted = dateReimRequestSubmitted;
    }

    public Float getReimbLodgingExpenses() {
        return reimbLodgingExpenses;
    }

    public void setReimbLodgingExpenses(Float reimbLodgingExpenses) {
        this.reimbLodgingExpenses = reimbLodgingExpenses;
    }

    public Float getReimbExtraCosts() {
        return reimbExtraCosts;
    }

    public void setReimbExtraCosts(Float reimbExtraCosts) {
        this.reimbExtraCosts = reimbExtraCosts;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean getHasCoordApproved() {
        return hasCoordApproved;
    }

    public void setHasCoordApproved(boolean hasCoordApproved) {
        this.hasCoordApproved = hasCoordApproved;
    }

    public boolean getHasFund1MgrApproved() {
        return hasFund1MgrApproved;
    }

    public void setHasFund1MgrApproved(boolean hasFund1MgrApproved) {
        this.hasFund1MgrApproved = hasFund1MgrApproved;
    }

    public boolean getHasFund2MgrApproved() {
        return hasFund2MgrApproved;
    }

    public void setHasFund2MgrApproved(boolean hasFund2MgrApproved) {
        this.hasFund2MgrApproved = hasFund2MgrApproved;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tripID != null ? tripID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trips)) {
            return false;
        }
        Trips other = (Trips) object;
        if ((this.tripID == null && other.tripID != null) || (this.tripID != null && !this.tripID.equals(other.tripID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Trips[ tripID=" + tripID + " ]";
    }

    public Date getPlannedstartdate() {
        return plannedstartdate;
    }

    public void setPlannedstartdate(Date plannedstartdate) {
        this.plannedstartdate = plannedstartdate;
    }

    public Date getPlannedenddate() {
        return plannedenddate;
    }

    public void setPlannedenddate(Date plannedenddate) {
        this.plannedenddate = plannedenddate;
    }

    public Date getActualBeginDateTime() {
        return actualBeginDateTime;
    }

    public void setActualBeginDateTime(Date actualBeginDateTime) {
        this.actualBeginDateTime = actualBeginDateTime;
    }

    public Date getActualEndDateTime() {
        return actualEndDateTime;
    }

    public void setActualEndDateTime(Date actualEndDateTime) {
        this.actualEndDateTime = actualEndDateTime;
    }

    public Date getDepartureBorderCrossDatetime() {
        return departureBorderCrossDatetime;
    }

    public void setDepartureBorderCrossDatetime(Date departureBorderCrossDatetime) {
        this.departureBorderCrossDatetime = departureBorderCrossDatetime;
    }

    public Date getArrivalBorderCrossDatetime() {
        return arrivalBorderCrossDatetime;
    }

    public void setArrivalBorderCrossDatetime(Date arrivalBorderCrossDatetime) {
        this.arrivalBorderCrossDatetime = arrivalBorderCrossDatetime;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDateReimRequestSubmitted() {
        return dateReimRequestSubmitted;
    }

    public void setDateReimRequestSubmitted(Date dateReimRequestSubmitted) {
        this.dateReimRequestSubmitted = dateReimRequestSubmitted;
    }
    
}

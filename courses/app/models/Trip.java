package models;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name = "trips")
public class Trip extends Model {
    @NotNull
    @Column(name = "Planned_start_date")
    public Date plannedstartdate;
    @NotNull
    @Column(name = "Planned_end_date")
    public Date plannedenddate;
    @Column(name = "actual_begin_date_time")
    public Date actualBeginDateTime;
    @Column(name = "actual_end_date_time")
    public Date actualEndDateTime;
    @Column(name = "departure_border_cross_datetime")
    public Date departureBorderCrossDatetime;
    @Column(name = "arrival_border_cross_datetime")
    public Date arrivalBorderCrossDatetime;
    @Column(name = "created_at")
    public Date createdAt;
    @Column(name = "updated_at")
    public Date updatedAt;
    @Column(name = "date_reim_request_submitted")
    public Date dateReimRequestSubmitted;
    public static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "trip_ID")
    public Integer tripID;
    @Column(name = "academic_year_id")
    public Integer academicYearId;
    @Column(name = "Date_of_request")
    public Integer dateofrequest;
    @Size(max = 255)
    @Column(name = "Planned_Reason_for_Travel")
    public String plannedReasonforTravel;
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "status")
    public String status;
    @Size(max = 255)
    @Column(name = "Planned_destination")
    public String planneddestination;
    @Size(max = 255)
    @Column(name = "Planned_means_of_transport")
    public String plannedmeansoftransport;
    @Column(name = "is_stopover_requested")
    public Boolean isStopoverRequested;
    @Size(max = 255)
    @Column(name = "Reason_for_extraordinary_transport")
    public String reasonforextraordinarytransport;
    @Size(max = 255)
    @Column(name = "Reason_for_stopover")
    public String reasonforstopover;
    @Size(max = 20)
    @Column(name = "type_of_transportation")
    public String typeOfTransportation;
    @Column(name = "is_approved")
    public Boolean isApproved;
    @Column(name = "are_personal_funds_used")
    public Boolean arePersonalFundsUsed;
    @Column(name = "personal_funds_amount")
    public Integer personalFundsAmount;
    @Size(max = 100)
    @Column(name = "alternative_fund_1_name")
    public String alternativeFund1Name;
    @Column(name = "alternative_fund_1_manager")
    public Integer alternativeFund1Manager;
    @Column(name = "alternative_fund_1_amount")
    public Integer alternativeFund1Amount;
    @Size(max = 100)
    @Column(name = "alternative_fund_2_name")
    public String alternativeFund2Name;
    @Column(name = "alternative_fund_2_amount")
    public Integer alternativeFund2Amount;
    @Column(name = "alternative_fund_2_manager")
    public Integer alternativeFund2Manager;
    @NotNull
    @Column(name = "has_advisor_approved")
    public boolean hasAdvisorApproved;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "foreseen_meals_cost")
    public Float foreseenMealsCost;
    @Column(name = "foreseen_lodging_cost")
    public Float foreseenLodgingCost;
    @Column(name = "foreseen_transportation_cost")
    public Float foreseenTransportationCost;
    @Column(name = "expenses_sustained_before_trip")
    public Float expensesSustainedBeforeTrip;
    @Column(name = "is_advance_payment_requested")
    public Boolean isAdvancePaymentRequested;
    @Size(max = 255)
    @Column(name = "actual_destination")
    public String actualDestination;
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "current_address")
    public String currentAddress;
    @Column(name = "advance_payment_received")
    public Float advancePaymentReceived;
    @Size(max = 100)
    @Column(name = "requested_payment_method")
    public String requestedPaymentMethod;
    @Lob
    @Size(max = 65535)
    @Column(name = "self_declaration_missing_recepits")
    public String selfDeclarationMissingRecepits;
    @Lob
    @Size(max = 65535)
    @Column(name = "other_declarations")
    public String otherDeclarations;
    @Lob
    @Size(max = 65535)
    @Column(name = "Travel_tickets")
    public String traveltickets;
    @Column(name = "personal_veichle_KM_travelled")
    public Integer personalveichleKMtravelled;
    @Size(max = 255)
    @Column(name = "personal_veichle_colleagues")
    public String personalVeichleColleagues;
    @Column(name = "highway_toll_fees")
    public Float highwayTollFees;
    @Column(name = "total_transport_expenses")
    public Float totalTransportExpenses;
    @Column(name = "total_lodging_expenses")
    public Float totalLodgingExpenses;
    @Column(name = "number_of_nights")
    public Integer numberOfNights;
    @Column(name = "num_lodging_receipts")
    public Integer numLodgingReceipts;
    @Column(name = "num_meals_invoices")
    public Integer numMealsInvoices;
    @Column(name = "num_days_of_meals")
    public Integer numDaysOfMeals;
    @Column(name = "total_meal_expenses")
    public Float totalMealExpenses;
    @Column(name = "registration_fee")
    public Float registrationFee;
    @Column(name = "other_costs_amount")
    public Float otherCostsAmount;
    @Column(name = "other_costs_description")
    public Integer otherCostsDescription;
    @Column(name = "total_expenses")
    public Float totalExpenses;
    @Column(name = "reimb_transport_expenses")
    public Float reimbTransportExpenses;
    @Column(name = "reimb_lodging_expenses")
    public Float reimbLodgingExpenses;
    @Column(name = "reimb_extra_costs")
    public Float reimbExtraCosts;
    @NotNull
    @Column(name = "deleted")
    public boolean deleted;
    @NotNull
    @Column(name = "has_coord_approved")
    public boolean hasCoordApproved;
    @NotNull
    @Column(name = "has_fund_1_mgr_approved")
    public boolean hasFund1MgrApproved;
    @NotNull
    @Column(name = "has_fund_2_mgr_approved")
    public boolean hasFund2MgrApproved;
    @JoinColumn(name = "student", referencedColumnName = "user_ID")
    @ManyToOne(optional = false)
    public Student student;


    public static Finder<Long,Trip> find = new Finder(
      Long.class, Trip.class
    );

    public static List<Trip> all() {
      return find.all();
    }
  
    public static void create(Trip trip) {
      trip.save();
    }

    public static void delete(Long id) {
      find.ref(id).delete();
    }    
}

package models;

import java.util.*;
import javax.persistence.*;
import javax.persistence.validation.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name = "calendar_timer")
public class CalendarTimer extends Model {
    public static final long serialVersionUID = 1L;
    @NotNull
    @Column(name = "autoTimer")
    public boolean autoTimer;
    @Size(max = 255)
    @Column(name = "scheduleExprDayOfMonth")
    public String scheduleExprDayOfMonth;
    @Size(max = 255)
    @Column(name = "scheduleExprDayOfWeek")
    public String scheduleExprDayOfWeek;
    @Column(name = "scheduleExprEndDate")
    public Date scheduleExprEndDate;
    @Size(max = 255)
    @Column(name = "scheduleExprHour")
    public String scheduleExprHour;
    @Size(max = 255)
    @Column(name = "scheduleExprMinute")
    public String scheduleExprMinute;
    @Size(max = 255)
    @Column(name = "scheduleExprMonth")
    public String scheduleExprMonth;
    @Size(max = 255)
    @Column(name = "scheduleExprSecond")
    public String scheduleExprSecond;
    @Column(name = "scheduleExprStartDate")
    public Date scheduleExprStartDate;
    @Size(max = 255)
    @Column(name = "scheduleExprTimezone")
    public String scheduleExprTimezone;
    @Size(max = 255)
    @Column(name = "scheduleExprYear")
    public String scheduleExprYear;
    @Id
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id")
    public String id;
    @Column(name = "timeoutMethod_id")
    public BigInteger timeoutMethodid;

}

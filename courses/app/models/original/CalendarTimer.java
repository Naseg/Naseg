/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "calendar_timer")
@XmlRootElement
public class CalendarTimer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "autoTimer")
    private boolean autoTimer;
    @Size(max = 255)
    @Column(name = "scheduleExprDayOfMonth")
    private String scheduleExprDayOfMonth;
    @Size(max = 255)
    @Column(name = "scheduleExprDayOfWeek")
    private String scheduleExprDayOfWeek;
    @Column(name = "scheduleExprEndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduleExprEndDate;
    @Size(max = 255)
    @Column(name = "scheduleExprHour")
    private String scheduleExprHour;
    @Size(max = 255)
    @Column(name = "scheduleExprMinute")
    private String scheduleExprMinute;
    @Size(max = 255)
    @Column(name = "scheduleExprMonth")
    private String scheduleExprMonth;
    @Size(max = 255)
    @Column(name = "scheduleExprSecond")
    private String scheduleExprSecond;
    @Column(name = "scheduleExprStartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduleExprStartDate;
    @Size(max = 255)
    @Column(name = "scheduleExprTimezone")
    private String scheduleExprTimezone;
    @Size(max = 255)
    @Column(name = "scheduleExprYear")
    private String scheduleExprYear;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id")
    private String id;
    @Column(name = "timeoutMethod_id")
    private BigInteger timeoutMethodid;

    public CalendarTimer() {
    }

    public CalendarTimer(String id) {
        this.id = id;
    }

    public CalendarTimer(String id, boolean autoTimer) {
        this.id = id;
        this.autoTimer = autoTimer;
    }

    public boolean getAutoTimer() {
        return autoTimer;
    }

    public void setAutoTimer(boolean autoTimer) {
        this.autoTimer = autoTimer;
    }

    public String getScheduleExprDayOfMonth() {
        return scheduleExprDayOfMonth;
    }

    public void setScheduleExprDayOfMonth(String scheduleExprDayOfMonth) {
        this.scheduleExprDayOfMonth = scheduleExprDayOfMonth;
    }

    public String getScheduleExprDayOfWeek() {
        return scheduleExprDayOfWeek;
    }

    public void setScheduleExprDayOfWeek(String scheduleExprDayOfWeek) {
        this.scheduleExprDayOfWeek = scheduleExprDayOfWeek;
    }

    public Date getScheduleExprEndDate() {
        return scheduleExprEndDate;
    }

    public void setScheduleExprEndDate(Date scheduleExprEndDate) {
        this.scheduleExprEndDate = scheduleExprEndDate;
    }

    public String getScheduleExprHour() {
        return scheduleExprHour;
    }

    public void setScheduleExprHour(String scheduleExprHour) {
        this.scheduleExprHour = scheduleExprHour;
    }

    public String getScheduleExprMinute() {
        return scheduleExprMinute;
    }

    public void setScheduleExprMinute(String scheduleExprMinute) {
        this.scheduleExprMinute = scheduleExprMinute;
    }

    public String getScheduleExprMonth() {
        return scheduleExprMonth;
    }

    public void setScheduleExprMonth(String scheduleExprMonth) {
        this.scheduleExprMonth = scheduleExprMonth;
    }

    public String getScheduleExprSecond() {
        return scheduleExprSecond;
    }

    public void setScheduleExprSecond(String scheduleExprSecond) {
        this.scheduleExprSecond = scheduleExprSecond;
    }

    public Date getScheduleExprStartDate() {
        return scheduleExprStartDate;
    }

    public void setScheduleExprStartDate(Date scheduleExprStartDate) {
        this.scheduleExprStartDate = scheduleExprStartDate;
    }

    public String getScheduleExprTimezone() {
        return scheduleExprTimezone;
    }

    public void setScheduleExprTimezone(String scheduleExprTimezone) {
        this.scheduleExprTimezone = scheduleExprTimezone;
    }

    public String getScheduleExprYear() {
        return scheduleExprYear;
    }

    public void setScheduleExprYear(String scheduleExprYear) {
        this.scheduleExprYear = scheduleExprYear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigInteger getTimeoutMethodid() {
        return timeoutMethodid;
    }

    public void setTimeoutMethodid(BigInteger timeoutMethodid) {
        this.timeoutMethodid = timeoutMethodid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalendarTimer)) {
            return false;
        }
        CalendarTimer other = (CalendarTimer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CalendarTimer[ id=" + id + " ]";
    }
    
}

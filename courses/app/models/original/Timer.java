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
@Table(name = "timer")
@XmlRootElement
public class Timer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id")
    private String id;
    @Lob
    @Column(name = "info")
    private byte[] info;
    @Column(name = "initialDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date initialDate;
    @Column(name = "nextDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nextDate;
    @Column(name = "previousRun")
    @Temporal(TemporalType.TIMESTAMP)
    private Date previousRun;
    @Basic(optional = false)
    @NotNull
    @Column(name = "repeatInterval")
    private long repeatInterval;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "timedObjectId")
    private String timedObjectId;
    @Column(name = "timerState")
    private Integer timerState;

    public Timer() {
    }

    public Timer(String id) {
        this.id = id;
    }

    public Timer(String id, long repeatInterval, String timedObjectId) {
        this.id = id;
        this.repeatInterval = repeatInterval;
        this.timedObjectId = timedObjectId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getInfo() {
        return info;
    }

    public void setInfo(byte[] info) {
        this.info = info;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getNextDate() {
        return nextDate;
    }

    public void setNextDate(Date nextDate) {
        this.nextDate = nextDate;
    }

    public Date getPreviousRun() {
        return previousRun;
    }

    public void setPreviousRun(Date previousRun) {
        this.previousRun = previousRun;
    }

    public long getRepeatInterval() {
        return repeatInterval;
    }

    public void setRepeatInterval(long repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    public String getTimedObjectId() {
        return timedObjectId;
    }

    public void setTimedObjectId(String timedObjectId) {
        this.timedObjectId = timedObjectId;
    }

    public Integer getTimerState() {
        return timerState;
    }

    public void setTimerState(Integer timerState) {
        this.timerState = timerState;
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
        if (!(object instanceof Timer)) {
            return false;
        }
        Timer other = (Timer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Timer[ id=" + id + " ]";
    }
    
}

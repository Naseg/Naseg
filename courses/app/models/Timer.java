package models;

import java.util.*;
import javax.persistence.*;
import javax.persistence.validation.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name = "timer")
public class Timer extends Model {
    public static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id")
    public String id;
    @Lob
    @Column(name = "info")
    public byte[] info;
    @Column(name = "initialDate")
    public Date initialDate;
    @Column(name = "nextDate")
    public Date nextDate;
    @Column(name = "previousRun")
    public Date previousRun;
    @NotNull
    @Column(name = "repeatInterval")
    public long repeatInterval;
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "timedObjectId")
    public String timedObjectId;
    @Column(name = "timerState")
    public Integer timerState;

    public byte[] getInfo() {
        return info;
    }

    public void setInfo(byte[] info) {
        this.info = info;
    }

}

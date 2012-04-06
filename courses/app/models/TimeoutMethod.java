package models;

import java.util.*;
import javax.persistence.*;
import javax.persistence.validation.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name = "timeout_method")
public class TimeoutMethod extends Model {
    public static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "id")
    public Long id;
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "declaringClass")
    public String declaringClass;
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "methodName")
    public String methodName;

}

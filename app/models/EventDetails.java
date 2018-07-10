package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.util.Date;
import java.util.List;

/**
 * Created by dulanjana on 7/2/18.
 */
@Entity
public class EventDetails extends Model {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long eventDetailsId;

    @NotNull
    private Date registerTime;

    @NotNull
    private String time;

    @NotNull
    private String qrId;

    @NotNull
    @ManyToOne
    private  Event event;

    @NotNull
    @ManyToOne
    private User user;









    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getEventDetailsId() {
        return eventDetailsId;
    }

    public void setEventDetailsId(long eventDetailsId) {
        this.eventDetailsId = eventDetailsId;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getQrId() {
        return qrId;
    }

    public void setQrId(String qrId) {
        this.qrId = qrId;
    }


}

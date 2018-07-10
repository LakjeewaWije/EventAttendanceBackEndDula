package models;



import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by dulanjana on 7/2/18.
 */
@Entity
public class Event extends Model {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long eventId;

    @NotNull
    private String eventName;

    @NotNull
    private String eventDesc;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date eventDateTime;

    @OneToMany
    private List<EventDetails> eventDetailsId;


    public Date getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(Date eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public List<EventDetails> getEventDetailsId() {
        return eventDetailsId;
    }

    public void setEventDetailsId(List<EventDetails> eventDetailsId) {
        this.eventDetailsId = eventDetailsId;
    }
}

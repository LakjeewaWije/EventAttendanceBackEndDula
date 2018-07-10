package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by dulanjana on 7/2/18.
 */
@Entity
public class User extends Model{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long userId;

    @NotNull
    private String fName;

    @NotNull
    private String lName;

    @NotNull
    private String eMail;

    @NotNull
    private String password;


    @OneToMany
    private List<EventDetails> eventDetails;



    private String authToken;



















    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<EventDetails> getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(List<EventDetails> eventDetails) {
        this.eventDetails = eventDetails;
    }
}

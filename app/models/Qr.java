package models;

import com.avaje.ebean.Model;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by dulanjana on 7/2/18.
 */
@Entity
public class Qr extends Model {

    @Id
    private String uuid;

    private  String browserTok;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }



    public String getBrowserToken() {
        return browserTok;
    }

    public void setBrowserToken(String browserToken) {
        this.browserTok = browserToken;
    }
}

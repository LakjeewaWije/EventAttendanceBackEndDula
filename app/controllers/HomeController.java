package controllers;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Transaction;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import models.*;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

/**
 * Manage a database of computers
 */
public class HomeController  extends Controller {

    /**
     * showing a default message
     * @return returns a http code with status code 200
     */
    public Result index() {
        return ok("<html>\n" +
                "<head>\n" +
                "<title>Phonebook API</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h1>Phonebook API Overview</h1>\n" +
                "<p>The Developerʼs API Documentation web site is where you will ﬁnd all updates, usage guidelines, " +
                "sample code and setup instructions for this service. All questions regarding this service will be handled" +
                " by Dulanjana.</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>").as("text/html");


    }
}
            

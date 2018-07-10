package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Event;
import models.EventDetails;
import models.Qr;
import play.Logger;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import services.EventService;
import util.JsonServiceUtil;
import util.ResponseWrapper;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

/**
 * Created by dulanjana on 7/3/18.
 */
public class EventController extends Controller {
    @Inject
    private ObjectMapper objectMapper;


    @Inject
    private EventService eventService;





    @BodyParser.Of(BodyParser.Json.class)
    public Result addEvent() {

        JsonNode jsonNode = request().body().asJson();

        Event eventToAdd = null;



        try {
            eventToAdd = objectMapper.treeToValue(jsonNode, Event.class);


            Event addedevent = eventService.addEvent(eventToAdd);


            return ok(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("event added", addedevent)));


        } catch (JsonProcessingException e) {
            Logger.error(e.getMessage());
            return badRequest(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("Error", null)));
        }
    }


    /**
     * Viewing Events for the console user
     * @return
     */

    public Result viewEventsConsole(){

        List<Event> alleventsCon = eventService.showEvents();
        return ok(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("Event List", alleventsCon)));

    }

    /**
     * Viweing Events for the mobile user by passing mobile user's id
     * @return
     */

}

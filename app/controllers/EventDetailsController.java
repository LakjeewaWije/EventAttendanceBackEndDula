package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.QrDao;
import models.EventDetails;
import play.Logger;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import services.EventDetailsService;
import services.QrService;
import util.JsonServiceUtil;
import util.ResponseWrapper;

import javax.inject.Inject;

/**
 * Created by dulanjana on 7/9/18.
 */
public class EventDetailsController extends Controller{

    @Inject
    private ObjectMapper objectMapper;


    @Inject
    private EventDetailsService eventDetailsService;

   // @Inject
    //private QrService qrService;




    /**
     * After Fetching the Data which comes from the frontend we will sucessfully mark the attendance
     * @return marking attendance , deleting the previous used QR
     */
    @BodyParser.Of(BodyParser.Json.class)
    public Result addEventDetail() {

        JsonNode jsonNode = request().body().asJson();

        EventDetails eventDetailToAdd = null;



        try {
            eventDetailToAdd = objectMapper.treeToValue(jsonNode, EventDetails.class);


            EventDetails addedEventDetail = eventDetailsService.addEventDetail(eventDetailToAdd);

            String qrid = addedEventDetail.getQrId();

//            qrService.deleteQr(qrid);


            return ok(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("eventDetails added", addedEventDetail)));


        } catch (JsonProcessingException e) {
            Logger.error(e.getMessage());
            return badRequest(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("Error", null)));
        }
    }




}

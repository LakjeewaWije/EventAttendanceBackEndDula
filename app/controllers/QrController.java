package controllers;

import com.avaje.ebeaninternal.server.lib.util.Str;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Qr;

import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import services.QrService;
import util.JsonServiceUtil;
import util.ResponseWrapper;
import javax.inject.Inject;
import java.util.UUID;


/**
 * Created by dulanjana on 7/9/18.
 */

public class QrController extends Controller{



    @Inject
    private ObjectMapper objectMapper;


    @Inject
    private QrService qrService;


    /**
     * Getting the BrowserToken from the front end and creating a UUID and setting up a QR Object
     * @return  object with both Token and the UUID
     */

    @BodyParser.Of(BodyParser.Json.class)
    public Result addQr(){
        JsonNode jsonNode = request().body().asJson();

        Qr qrtoadd=null;


        try {
            qrtoadd = objectMapper.treeToValue(jsonNode,Qr.class);

            UUID uuid = generateUUID();


            String uuidstr = uuid.toString();

            qrtoadd.setUuid(uuidstr);

            Qr addedQr = qrService.addQr(qrtoadd);

            return ok(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("Qr added", addedQr)));

        } catch (JsonProcessingException e) {
            return badRequest(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("Error", null)));
        }
    }

    /**
     * will Create a new UUId , and checking it with db whether if it still exists till the unique id generates
     * @return
     */
    public UUID generateUUID(){
        UUID uuid = UUID.randomUUID();

        if(uuid!=null){
            return uuid;
        }
        else{
            return generateUUID();
        }
    }

}






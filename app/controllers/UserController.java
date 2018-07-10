package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.LoginCredentials;
import dto.LoginResponse;
import models.User;
import play.Logger;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import services.UserService;
import util.JsonServiceUtil;
import util.ResponseWrapper;

import javax.inject.Inject;

/**
 * Created by dulanjana on 7/3/18.
 */
public class UserController extends Controller {

    @Inject
    private ObjectMapper objectMapper;


    @Inject
    private UserService userService;



    @BodyParser.Of(BodyParser.Json.class)
    public Result addUser() {

        JsonNode jsonNode = request().body().asJson();

        User userToAdd = null;

        try {
            userToAdd = objectMapper.treeToValue(jsonNode, User.class);

            User addedUser = userService.addUser(userToAdd);

            return ok(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("User added", addedUser)));

        } catch (JsonProcessingException e) {
            Logger.error(e.getMessage());
            return badRequest(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("Not JSon", null)));
        }


    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result login(){
        JsonNode jsonNode = request().body().asJson();

        try {
            LoginCredentials loginCridentials = objectMapper.treeToValue(jsonNode, LoginCredentials.class);

            User loggedInUser = userService.login(loginCridentials);

            LoginResponse logingresponse = new LoginResponse(loggedInUser,loggedInUser.getAuthToken());


            if (loggedInUser == null){
                return badRequest(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("No user for the provided email/password", null)));
            }
            return ok(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("User loggedIn", logingresponse)));
        } catch (JsonProcessingException e) {
            Logger.error(e.getMessage());

            return badRequest(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("Can not get data", null)));
        }
    }

    public Result logoutUser(long id) {

        User loggedOutUser = userService.logout(id);

        if (loggedOutUser == null) {
            return badRequest(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("No user for the id", null)));
        }
        return ok(JsonServiceUtil.toJsonNode(new ResponseWrapper<>("User logged out", loggedOutUser)));
    }


}

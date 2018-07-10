package dto;

import models.User;

/**
 * Created by dulanjana on 7/6/18.
 */
public class LoginResponse {

    private User user;

    private String auth;


    public LoginResponse(User user, String auth) {
        this.user = user;
        this.auth = auth;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }
}

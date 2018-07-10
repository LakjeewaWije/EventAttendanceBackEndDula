package services;

import dto.LoginCredentials;
import models.User;

/**
 * Created by dulanjana on 7/2/18.
 */
public interface UserService {


    User addUser(User userToAdd);

    User login(LoginCredentials logincredentials);

    User logout(long id);




}

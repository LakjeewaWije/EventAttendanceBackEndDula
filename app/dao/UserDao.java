package dao;

import models.User;

/**
 * Created by dulanjana on 7/2/18.
 */
public interface UserDao {
    User addUser(User toadduser);

    User findUserByEmail(String email);

    User updateUser(User updatedUser);

    User logoutUser(User logoutuser);

    User searchUser(long usertofind);

    User findUserByToken(String authToken);

    User findUserById(long id);

}

package dao.Impl;

import com.avaje.ebean.Model;
import dao.UserDao;
import models.User;

/**
 * Created by dulanjana on 7/2/18.
 */
public class UserDaoImpl implements UserDao{

    public static final Model.Finder<Long, User> find = new Model.Finder<>(User.class);

    @Override
    public User addUser(User toadduser) {
        toadduser.save();
        return toadduser;
    }

    @Override
    public User findUserByEmail(String email) {
        return find.where().eq("eMail",email).findUnique();
    }

    @Override
    public User updateUser(User updatedUser) {
        updatedUser.update();
        return updatedUser;
    }

    @Override
    public User logoutUser(User logoutuser) {
        logoutuser.update();
        return  logoutuser;
    }

    @Override
    public User searchUser(long usertofind) {
        return find.byId(usertofind);
    }

    @Override
    public User findUserByToken(String authToken) {
      return find.where().eq("authToken", authToken).findUnique();
    }

    @Override
    public User findUserById(long id){
        return find.where().eq("userId",id).findUnique();
    }

}

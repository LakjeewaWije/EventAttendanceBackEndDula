package services.Impl;

import dao.UserDao;
import dto.LoginCredentials;
import models.User;
import org.apache.commons.codec.binary.Base64;
import services.UserService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

import static play.mvc.Http.Context.Implicit.ctx;

/**
 * Created by dulanjana on 7/2/18.
 */
public class UserServiceImpl implements UserService {

    @Inject
    @Named("userDao")
    private UserDao userDao;

    @Override
    public User addUser(User userToAdd) {

        return userDao.addUser(userToAdd);
    }

    @Override
    public User login(LoginCredentials logincredentials) {

        User userInDb = userDao.findUserByEmail(logincredentials.getEmail());

        if(userInDb==null){
            return null;
        }
        if(!userInDb.getPassword().equals(logincredentials.getPassword())){
            return null;
        }
        userInDb.setAuthToken(String.valueOf(Base64.encodeBase64((new Date().getTime()+userInDb.geteMail()+userInDb.getPassword()+userInDb.getfName()).getBytes())));
        return userDao.updateUser(userInDb);
    }

    /**
     * after loging in he will get a unique token.. after logging out we have to clear that token
     * @param
     * @return
     */

    @Override
    public User logout(long id) {



        User loggedInUser = userDao.searchUser(id);

        loggedInUser.setAuthToken(null);

        return userDao.logoutUser(loggedInUser);

        }
    }




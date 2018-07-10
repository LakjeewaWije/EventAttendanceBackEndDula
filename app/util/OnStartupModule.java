package util;


import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import dao.EventDao;
import dao.EventDetailsDao;
import dao.Impl.EventDaoImpl;

import dao.Impl.EventDetailsDaoImpl;

import dao.Impl.QrDaoImpl;
import dao.Impl.UserDaoImpl;
import dao.QrDao;
import dao.UserDao;
import services.EventDetailsService;
import services.EventService;
import services.Impl.EventDetailsServiceImpl;
import services.Impl.EventServiceImpl;

import services.Impl.QrServiceImpl;
import services.Impl.UserServiceImpl;
import services.QrService;


import services.Impl.UserServiceImpl;


import services.UserService;

public class OnStartupModule extends AbstractModule {

    @Override
    protected void configure() {
        //Bind dao
        bind(UserDao.class).annotatedWith(Names.named("userDao")).to(UserDaoImpl.class);
        bind(EventDao.class).annotatedWith(Names.named("eventDao")).to(EventDaoImpl.class);
        bind(QrDao.class).annotatedWith(Names.named("qrDao")).to(QrDaoImpl.class);

        bind(EventDetailsDao.class).annotatedWith(Names.named("eventDetailsDao")).to(EventDetailsDaoImpl.class);



        //bind Service
        bind(UserService.class).to(UserServiceImpl.class);
        bind(EventService.class).to(EventServiceImpl.class);

        bind(QrService.class).to(QrServiceImpl.class);
        bind(EventDetailsService.class).to(EventDetailsServiceImpl.class);







    }
}

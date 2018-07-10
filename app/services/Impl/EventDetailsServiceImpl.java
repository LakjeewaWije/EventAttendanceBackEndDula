package services.Impl;

import dao.EventDetailsDao;
import dao.UserDao;
import models.EventDetails;
import services.EventDetailsService;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by dulanjana on 7/9/18.
 */
public class EventDetailsServiceImpl implements EventDetailsService {

    @Inject
    @Named("eventDetailsDao")
    private EventDetailsDao eventDetailsDao;


    /**
     * passing The Json to the evenDetailsDao
     * @param eventDetail
     * @return
     */
    @Override
    public EventDetails addEventDetail(EventDetails eventDetail) {

        return eventDetailsDao.addEventDetail(eventDetail);
    }
}

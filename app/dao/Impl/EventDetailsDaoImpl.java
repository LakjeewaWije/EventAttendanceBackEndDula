package dao.Impl;


import dao.EventDetailsDao;
import models.EventDetails;



/**
 * Created by dulanjana on 7/9/18.
 */
public class EventDetailsDaoImpl implements EventDetailsDao {


    @Override
    public EventDetails addEventDetail(EventDetails eventDetail) {
        eventDetail.save();
        return eventDetail;
    }
}

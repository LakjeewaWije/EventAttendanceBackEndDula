package dao.Impl;

import com.avaje.ebean.Ebean;
import dao.EventDao;

import models.Event;


import java.util.List;

/**
 * Created by dulanjana on 7/2/18.
 */
public class EventDaoImpl implements EventDao {

    @Override
    public Event addEvent(Event toaddevent) {
        toaddevent.save();
        return toaddevent;
    }

    @Override
    public List<Event> viewEvents() {
        List<Event> listCon = Ebean.find(Event.class).select("eventName").findList();
        return listCon;
    }



}

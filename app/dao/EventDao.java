package dao;

import models.Event;

import java.util.List;

/**
 * Created by dulanjana on 7/2/18.
 */
public interface EventDao {
    Event addEvent(Event toaddevent);

    List<Event> viewEvents();


}

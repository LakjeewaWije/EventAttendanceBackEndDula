package services;

import models.Event;
import models.Qr;

import java.util.List;

/**
 * Created by dulanjana on 7/2/18.
 */
public interface EventService {
    Event addEvent(Event eventToAdd);

    List<Event> showEvents();

}

package services.Impl;

import com.google.inject.Inject;
import dao.EventDao;
import models.Event;
import models.Qr;
import services.EventService;

import javax.inject.Named;
import java.util.List;

/**
 * Created by dulanjana on 7/2/18.
 */
public class EventServiceImpl implements EventService {

    @Inject
    @Named("eventDao")
    private EventDao eventDao;

    @Override
    public Event addEvent(Event eventToAdd) {

        return eventDao.addEvent(eventToAdd);

    }

    @Override
    public List<Event> showEvents() {

        return eventDao.viewEvents();
    }

}

package com.poly.service;

import com.poly.dao.EventDAO;
import com.poly.entity.Event;

import java.util.List;

public class EventService {
    private EventDAO eventDAO = new EventDAO();

    public EventService() {
        this.eventDAO = new EventDAO();
    }

    public List<Event> getAllEvents() {
        return eventDAO.selectAllEvent();
    }

}

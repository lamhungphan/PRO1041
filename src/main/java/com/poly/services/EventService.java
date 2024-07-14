package com.poly.services;

import com.poly.entity.Event;
import java.util.List;

public interface EventService {

    Event save(Event entity,String name);

    Event update(Event entity);

    Event delete(String id);

    Event findById(String id);

    Event findByName(String name);

    List<Event> findAll();
}

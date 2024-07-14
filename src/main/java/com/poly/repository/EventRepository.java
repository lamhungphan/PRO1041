package com.poly.repository;

import com.poly.entity.Event;
import java.util.List;

public interface EventRepository{

    Event create(Event entity);

    Event update(Event entity);

    Event remove(String id);

    Event findById(String id);

    List<Event> findAll();
}

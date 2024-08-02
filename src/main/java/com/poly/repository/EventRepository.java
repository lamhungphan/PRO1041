package com.poly.repository;

import com.poly.entity.Event;
import java.util.List;

public interface EventRepository {

    Event create(Event entity);

    Event update(Event entity);

    Event remove(Integer id);

    Event findById(Integer id);

    List<Event> findAll();

    List<Object[]> countMembersByEvent();
}

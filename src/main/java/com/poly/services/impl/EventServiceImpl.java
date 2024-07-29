/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.services.impl;

import com.poly.entity.Event;
import com.poly.repository.EventRepository;
import com.poly.services.EventService;
import com.poly.services.UserService;
import java.util.List;

/**
 *
 * @author Computer
 */
public class EventServiceImpl implements EventService {

    private EventRepository repo;
    private UserService userService;

    public EventServiceImpl(EventRepository repo, UserService userService) {
        this.repo = repo;
        this.userService = userService;
    }

    @Override
    public Event save(Event entity, String name) {
        entity.setUser(userService.findByUsername(name));
        return repo.create(entity);
    }

    @Override
    public Event update(Event entity) {
        return repo.update(entity);
    }

    @Override
    public Event delete(Integer id) {
        return repo.remove(id);
    }

    @Override
    public Event findById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Event findByName(String name) {
        List<Event> list = repo.findAll();
        for (Event event : list) {
            if (event.getTitle().equalsIgnoreCase(name)) {
                return event;
            }
        }
        return null;
    }

    @Override
    public List<Event> findAll() {
        return repo.findAll();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.services;

import com.poly.entity.Event;
import java.util.List;

/**
 *
 * @author Computer
 */
public interface EventService {

    public Event save(Event entity,String name);

    public Event update(Event entity);

    public Event delete(String id);

    public Event findById(String id);

    public Event findByName(String name);

    public List<Event> findAll();
}

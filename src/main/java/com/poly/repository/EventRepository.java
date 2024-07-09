/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.repository;

import com.poly.entity.Event;
import java.util.List;

/**
 *
 * @author Computer
 */
public interface EventRepository {

    public Event create(Event entity);

    public Event update(Event entity);

    public Event remove(String id);

    public Event findById(String id);

    public List<Event> findAll();
}

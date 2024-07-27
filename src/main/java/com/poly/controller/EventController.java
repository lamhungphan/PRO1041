/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.controller;

import com.poly.entity.Event;
import com.poly.injection.EventInjector;
import com.poly.services.EventService;
import com.poly.utils.MsgBox;
import java.util.List;

/**
 *
 * @author Computer
 */
public class EventController {
    
     EventService eventService = EventInjector.getInstance().getEventService();


    public void createEvent(Event event,String nameUserManager) {
        Event createdEvent = eventService.save(event,nameUserManager);
        if (createdEvent != null) {
            MsgBox.alert(null, "Tạo sự kiện thành công!");
        } else {
            MsgBox.alert(null, "Không thể tạo sự kiện.");
        }
    }

    public Event readEvent(Integer id) {
        return eventService.findById(id);
    }

    public void updateEvent(Event event) {
        Event updatedEvent = eventService.update(event);
        if (updatedEvent != null) {
            MsgBox.alert(null, "Cập nhật sự kiện thành công!");
        } else {
            MsgBox.alert(null, "Không thể cập nhật sự kiện.");
        }
    }

    public void deleteEvent(Integer id) {
        Event deletedEvent = eventService.delete(id);
        if (deletedEvent != null) {
            MsgBox.alert(null, "Xóa sự kiện thành công!");
        } else {
            MsgBox.alert(null, "Không thể xóa sự kiện.");
        }
    }

    public List<Event> getAllEvents() {
        return eventService.findAll();
    }
}

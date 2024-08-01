/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.poly.controller;

import com.poly.entity.Event;
import com.poly.entity.User;
import com.poly.injection.EventInjector;
import com.poly.injection.UserInjector;
import com.poly.services.EventService;
import com.poly.services.UserService;
import com.poly.utils.ComponentManagement;
import com.poly.utils.InputFields;
import com.poly.utils.MsgBox;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Computer
 */
public class EventController {



    EventService eventService = EventInjector.getInstance().getEventService();
    UserService userService = UserInjector.getInstance().getUserService();

    public Event createEvent(Event event, String usernameManager) {
        Event createdEvent = eventService.save(event, usernameManager);
        if (createdEvent != null) {
            MsgBox.alert(null, "Tạo sự kiện thành công!");
            return createdEvent;
        } else {
            MsgBox.alert(null, "Không thể tạo sự kiện.");
            return null;
        }
    }

    public Event readEvent(Integer id) {
        return eventService.findById(id);
    }

    public Event updateEvent(Event event) {
        Event updatedEvent = eventService.update(event);
        if (updatedEvent != null) {
            MsgBox.alert(null, "Cập nhật sự kiện thành công!");
            return updatedEvent;
        } else {
            MsgBox.alert(null, "Không thể cập nhật sự kiện.");
            return null;
        }
    }

    public Event deleteEvent(Integer id) {
        Event deletedEvent = eventService.delete(id);
        if (deletedEvent != null) {
            MsgBox.alert(null, "Xóa sự kiện thành công!");
            return deletedEvent;
        } else {
            MsgBox.alert(null, "Không thể xóa sự kiện.");
            return null;
        }
    }

    public List<Event> getAllEvents() {
        return eventService.findAll();
    }


}

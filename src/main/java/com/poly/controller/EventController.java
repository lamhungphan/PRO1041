/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.controller;

import com.poly.entity.Event;
import com.poly.injection.EventInjector;
import com.poly.injection.UserInjector;
import com.poly.services.EventService;
import com.poly.services.UserService;
import com.poly.utils.IOExcells;
import com.poly.utils.SheetsQuickstart;
import com.poly.view.Main;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Computer
 */
public class EventController {

    EventService eventService = EventInjector.getInstance().getEventService();
    UserService userService = UserInjector.getInstance().getUserService();

    public Event createEvent(Event event, String usernameManager) {
        Event createdEvent = eventService.save(event, usernameManager);
        return createdEvent;
    }

    public Event readEvent(Integer id) {
        return eventService.findById(id);
    }

    public Event updateEvent(Event event) {
        Event updatedEvent = eventService.update(event);
        return updatedEvent;
    }

    public Event deleteEvent(Integer id) {
        Event deletedEvent = eventService.delete(id);
        return deletedEvent;
    }

    public List<Event> getAllEvents() {
        return eventService.findAll();
    }

    public List<List<Object>> getAllResponseRegisterForm() {
        List<List<Object>> dataList = null;
        try {
            dataList = SheetsQuickstart.assignDataToList();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (GeneralSecurityException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataList;
    }
    
    public void exportGGSheetResponseRegisterForm(){
        List<List<Object>> dataList = getAllResponseRegisterForm();
        IOExcells.exportToExcelGGSheet(dataList);
    }

    public void exportExcellAllEvent(List<Event> dataList){
        IOExcells.exportToExcelEvent(dataList);
    }
}

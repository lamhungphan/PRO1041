/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.injection;

import com.poly.repository.EventRepository;
import com.poly.repository.impl.EventRepoImpl;
import com.poly.services.EventService;
import com.poly.services.UserService;
import com.poly.services.impl.EventServiceImpl;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author Computer
 */
public class EventInjector {

    private static EntityManagerFactory entityManagerFactory;

    static {
        // Khởi tạo EntityManagerFactory một lần duy nhất
        entityManagerFactory = Persistence.createEntityManagerFactory("pro1041");
    }

    public static EventService getEventService() {
        EventRepoImpl eventRepo = new EventRepoImpl(entityManagerFactory);
        return new EventServiceImpl(eventRepo);
    }

    private static EventInjector instance;

    private UserInjector userInjector;
    private final EventRepository eventRepository;
    private final EventService eventService;
    private final UserService userService;

    private EventInjector() {
        this.userInjector = UserInjector.getInstance();
        this.eventRepository = new EventRepoImpl();
        this.userService = userInjector.getUserService();
        this.eventService = new EventServiceImpl(eventRepository, userService);
    }

    public static EventInjector getInstance() {
        if (instance == null) {
            instance = new EventInjector();
        }
        return instance;
    }

    public EventRepository getEventRepository() {
        return eventRepository;
    }

//    public EventService getEventService() {
//        return eventService;
//    }

}

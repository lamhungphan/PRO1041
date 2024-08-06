package com.poly.services.impl;

import com.poly.entity.Notification;
import com.poly.repository.EventRepository;
import com.poly.repository.NotificationRepository;
import com.poly.repository.UserRepository;
import com.poly.services.EventService;
import com.poly.services.NotificationService;
import com.poly.services.UserService;

import java.util.List;

public class NotificationServiceImpl implements NotificationService {
    private NotificationRepository repo;
    private EventRepository repoEvent;
    private UserRepository repoUser;

    private EventService serviceEvent;
    private UserService serviceUser;

    @Override
    public Notification save(Notification entity, Integer userID, Integer eventID) {
        entity.setUserId(serviceUser.findById(userID));
        entity.setEventId(serviceEvent.findById(eventID));
        return repo.create(entity);
    }

    @Override
    public List<Notification> findAll() {
        return repo.findAll();
    }
}

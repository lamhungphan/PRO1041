package com.poly.services;

import com.poly.entity.Notification;

import java.util.List;

public interface NotificationService {

    Notification save(Notification entity, Integer userID, Integer eventID);

    List<Notification> findAll();
}

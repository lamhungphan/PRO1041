package com.poly.services;

import com.poly.entity.Notification;

import java.util.List;

public interface NotificationService {
    Notification save(Notification entity);

    List<Notification> findAll();
}

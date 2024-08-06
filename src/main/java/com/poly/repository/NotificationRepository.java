package com.poly.repository;

import com.poly.entity.Notification;

import java.util.List;

public interface NotificationRepository {

    Notification create(Notification entity);

    List<Notification> findAll();
}

package com.poly.services.impl;

import com.poly.entity.Notification;
import com.poly.repository.NotificationRepository;
import com.poly.services.NotificationService;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private NotificationRepository repo;

    @Override
    public Notification save(Notification entity) {
        return repo.create(entity);
    }

    @Override
    public List<Notification> findAll() {
        return repo.findAll();
    }
}

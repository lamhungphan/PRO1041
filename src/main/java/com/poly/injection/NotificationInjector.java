/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.injection;

import com.poly.repository.NotificationRepository;
import com.poly.repository.impl.NotificationRepoImpl;

/**
 *
 * @author seastone01202
 */
public class NotificationInjector {
    private static NotificationInjector instance;
    
    private final NotificationRepository notificationRepository;

    private NotificationInjector() {
        this.notificationRepository = new NotificationRepoImpl();
    }

    public static NotificationInjector getInstance() {
        if (instance == null) {
            instance = new NotificationInjector();
        }
        return instance;
    }

    public NotificationRepository getNotificationRepository() {
        return notificationRepository;
    }
    
}

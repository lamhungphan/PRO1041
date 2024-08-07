/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.controller;

import com.poly.entity.Notification;
import com.poly.injection.NotificationInjector;
import com.poly.services.NotificationService;
import java.util.List;

/**
 *
 * @author seastone01202
 */
public class NotificationController {
    
    private NotificationService service = NotificationInjector.getInstance().getNotificationService();
    
    public List<Notification> getAllNoti() {
        return service.findAll();
    }
    
}

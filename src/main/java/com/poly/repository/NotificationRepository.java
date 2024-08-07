/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.repository;

import com.poly.entity.Notification;
import java.util.List;

/**
 *
 * @author seastone01202
 */
public interface NotificationRepository {
    
    Notification create (Notification entity);
    
    List<Notification> findAll();
    
}

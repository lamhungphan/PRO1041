package com.poly.utils;

import com.poly.entity.Event;
import com.poly.entity.Notification;
import com.poly.entity.User;
import com.poly.repository.NotificationRepository;
import com.poly.repository.impl.NotificationRepoImpl;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

public class EntityListener {

    private NotificationRepository notificationRepository;

    public EntityListener() {
        this.notificationRepository = new NotificationRepoImpl();
    }

    @PrePersist
    public void prePersist(Object entity) {
        createNotification(entity, NotificationTitle.THEM);
    }

    @PreUpdate
    public void preUpdate(Object entity) {
        createNotification(entity, NotificationTitle.SUA);
    }

    @PreRemove
    public void preRemove(Object entity) {
        createNotification(entity, NotificationTitle.XOA);
    }

    private void createNotification(Object entity, NotificationTitle title) {
        Notification notification = new Notification();
        notification.setTitle(title);
        notification.setCreatedDate(new java.sql.Date(System.currentTimeMillis()));
        notification.setIsActived(true);

        if (entity instanceof Event) {
            notification.setContent(NotificationContent.EVENT);
            notification.setEventId((Event) entity);
        } else if (entity instanceof User) {
            notification.setContent(NotificationContent.MEMBER);
            notification.setUserId((User) entity);
        }

        notificationRepository.create(notification);
    }
}

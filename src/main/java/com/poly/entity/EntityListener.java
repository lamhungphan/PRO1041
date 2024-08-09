package com.poly.entity;

import com.poly.injection.NotificationInjector;
import com.poly.repository.NotificationRepository;
import com.poly.utils.NotificationContent;
import com.poly.utils.NotificationTitle;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

public class EntityListener {

    private static NotificationRepository repo;

    static {
        repo = NotificationInjector.getInstance().getNotificationRepository();
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
            Event event = (Event) entity;
            notification.setContent(NotificationContent.EVENT);
            notification.setEventTitle(event.getTitle());
            if (event.getUser() != null) {
                notification.setUserFullname(event.getUser().getFullname());
            }
        } else if (entity instanceof User) {
            User user = (User) entity;
            notification.setContent(NotificationContent.MEMBER);
            notification.setUserFullname(user.getFullname());
        }
        repo.create(notification);
    }


}

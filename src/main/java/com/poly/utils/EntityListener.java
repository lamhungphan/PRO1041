package com.poly.utils;

import com.poly.entity.Event;
import com.poly.entity.Notification;
import com.poly.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import org.hibernate.Session;

public class EntityListener {

    @PersistenceContext
    private EntityManager entityManager;

    @PrePersist
    @PreUpdate
    @PreRemove
    public void onEntityChange(Object entity) {
        EntityManager em = entityManager; // Sử dụng EntityManager được tiêm

        if (em == null) {
            // Nếu EntityManager chưa được tiêm, hãy lấy nó từ Hibernate SessionFactory
            em = HibernateUtils.getEntityManage();
        }

        try {
            Session session = em.unwrap(Session.class);
            if (!session.getTransaction().isActive()) {
                session.beginTransaction();
            }

            createNotification(entity, session);

            if (session.getTransaction().isActive()) {
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            Session session = em.unwrap(Session.class);
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            // Chỉ đóng EntityManager nếu nó được tạo mới từ SessionFactory
            if (entityManager == null && em.isOpen()) {
                em.close();
            }
        }
    }

    private void createNotification(Object entity, Session session) {
        Notification notification = new Notification();
        notification.setCreatedDate(new java.sql.Date(System.currentTimeMillis()));
        notification.setIsActived(true);
        if (entity instanceof Event) {
            Event event = (Event) entity;
            notification.setTitle(event.getId() == null ? NotificationTitle.THEM : NotificationTitle.SUA);
            notification.setContent(NotificationContent.EVENT);
            notification.setEventId(event);
        } else if (entity instanceof User) {
            User user = (User) entity;
            notification.setTitle(user.getId() == null ? NotificationTitle.THEM : NotificationTitle.SUA);
            notification.setContent(NotificationContent.MEMBER);
            notification.setUserId(user);
        }

        session.persist(notification);
    }
}

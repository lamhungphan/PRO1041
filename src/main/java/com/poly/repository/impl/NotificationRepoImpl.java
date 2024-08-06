package com.poly.repository.impl;

import com.poly.entity.Notification;
import com.poly.repository.NotificationRepository;
import com.poly.utils.HibernateUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class NotificationRepoImpl implements NotificationRepository {
    private EntityManager em = HibernateUtils.getEntityManage();
    
    @Override
    protected void finalize() throws Throwable {
        em.close();
        super.finalize();
    }

    @Override
    public Notification create(Notification entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Notification> findAll() {
        String jpql = "Select n from Notifications n";
        TypedQuery<Notification> query = em.createQuery(jpql, Notification.class);
        return query.getResultList();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.repository.impl;

import com.poly.entity.Notification;
import com.poly.repository.NotificationRepository;
import com.poly.utils.HibernateUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

/**
 *
 * @author seastone01202
 */
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
        String jpql = "Select e from Notifications e";
        TypedQuery<Notification> query = em.createQuery(jpql, Notification.class);
        return query.getResultList();
    }

}

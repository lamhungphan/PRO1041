package com.poly.repository.impl;

import com.poly.entity.Event;
import com.poly.repository.EventRepository;
import com.poly.utils.HibernateUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;

public class EventRepoImpl implements EventRepository {

    private EntityManager em = HibernateUtils.getEntityManage();

    @Override
    protected void finalize() throws Throwable {
        em.close();
        super.finalize();
    }

    @Override
    public Event create(Event entity) {
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
    public Event update(Event entity) {
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Event remove(Integer id) {
        try {
            Event entity = this.findById(id);
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Event findById(Integer id) {
        Event entity = em.find(Event.class, id);
        return entity;
    }

    @Override
    public List<Event> findAll() {
        String jpql = "Select e from Event e";
        TypedQuery<Event> query = em.createQuery(jpql, Event.class);
        return query.getResultList();
    }

    @Override
    public List<Object[]> countMembersByEvent() {
        try {
            String hql = "SELECT COUNT(e.id) FROM events e LEFT JOIN users u ON e.id = u.id GROUP BY id;";
            Query query = em.createQuery(hql);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}

package com.poly.repository.impl;

import com.poly.entity.Event;
import com.poly.repository.EventRepository;
import com.poly.utils.HibernateUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EventRepoImpl implements EventRepository {

    private EntityManager em = HibernateUtils.getEntityManage();
    private EntityManagerFactory entityManagerFactory;

    public EventRepoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public EventRepoImpl() {
    }

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
        EntityManager entityManager = entityManagerFactory.createEntityManager();
       String hql = "SELECT e.title, COUNT(u.id) FROM Event e JOIN User u ON u.id = e.userId GROUP BY e.title";
        TypedQuery<Object[]> query = entityManager.createQuery(hql, Object[].class);
        return query.getResultList();
    }
}

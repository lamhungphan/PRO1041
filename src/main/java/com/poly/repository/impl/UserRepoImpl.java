package com.poly.repository.impl;

import com.poly.entity.User;
import com.poly.repository.UserRepository;
import com.poly.utils.HibernateUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class UserRepoImpl implements UserRepository {

    private EntityManager em = HibernateUtils.getEntityManage();

    /**
     *
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        em.close();
        super.finalize();
    }

    @Override
    public User create(User entity) {
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
    public User update(User entity) {
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    @Override
    public User remove(Integer id) {
        try {
            User entity = this.findById(id);
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
    public User findById(Integer id) {
        User entity = em.find(User.class, id);
        if (entity == null) {
            return null;
        }
        return entity;
    }

    @Override
    public List<User> findAll() {
        String jpql = "Select u from User u";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        return query.getResultList();
    }
       
    @Override
    public User findByEmail(String email) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
        query.setParameter("email", email);
        return query.getResultList().stream().findFirst().orElse(null);
    }
    
}

package com.poly.repository.impl;

import com.poly.entity.PasswordResetToken;
import com.poly.repository.PasswordResetTokenRepository;
import com.poly.utils.HibernateUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class PasswordResetTokenRepoImpl implements PasswordResetTokenRepository {
    private EntityManager em = HibernateUtils.getEntityManage();

    @Override
    public PasswordResetToken save(PasswordResetToken entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public PasswordResetToken findByToken(String token) {
        TypedQuery<PasswordResetToken> query = em.createQuery("SELECT p FROM PasswordResetToken p WHERE p.token = :token", PasswordResetToken.class);
        query.setParameter("token", token);
        return query.getResultList().stream().findFirst().orElse(null);
    }

}

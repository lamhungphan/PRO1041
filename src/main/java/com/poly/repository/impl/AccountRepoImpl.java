package com.poly.repository.impl;

import com.poly.entity.Account;
import com.poly.repository.AccountRepository;
import com.poly.utils.HibernateUtils;
import jakarta.persistence.EntityManager;

public class AccountRepoImpl implements AccountRepository {

    private EntityManager em = HibernateUtils.getEntityManage();

    @Override
    public Account getAccount(Integer id) {
        Account entity = em.find(Account.class, id);
        return entity;
    }

    @Override
    public Account update(Account entity) {
        System.out.println("REPO: "+entity.getPassword());
        try{
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            System.out.println(em);
            return entity;
        } catch (Exception e){
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }
}

package com.poly.repository.impl;

import com.poly.entity.Role;
import com.poly.repository.RoleRepository;
import com.poly.utils.HibernateUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class RoleRepoImpl implements RoleRepository {

    private EntityManager em = HibernateUtils.getEntityManage();

    @Override
    protected void finalize() throws Throwable {
        em.close();
        super.finalize();
    }

    @Override
    public Role create(Role entity) {
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
    public Role update(Role entity) {
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
    public Role remove(String id) {
        try {
            Role entity = this.findById(id);
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
    public Role findById(String id) {
        Role entity = em.find(Role.class, id);
        return entity;

    }

    @Override
    public List<Role> findAll() {
        String jpql = "SELECT o FROM Role o";
        TypedQuery<Role> query = em.createQuery(jpql, Role.class);
        return query.getResultList();
    }
    
      // Thêm phương thức tìm vai trò của người dùng dựa trên userId
    public Role findRoleByUserId(Integer userId) {
        String jpql = "SELECT r FROM Role r JOIN User u ON r.id = u.roleId WHERE u.id = :userId";
        TypedQuery<Role> query = em.createQuery(jpql, Role.class);
        query.setParameter("userId", userId);
        return query.getSingleResult();
    }
}

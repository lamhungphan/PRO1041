package com.poly;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pro1041");
        EntityManager em = emf.createEntityManager();
        // Đóng EntityManager và EntityManagerFactory
        em.close();
        emf.close();
    }
}

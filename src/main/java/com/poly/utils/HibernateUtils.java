/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author Computer
 */
public class HibernateUtils {

    public static EntityManagerFactory factory;

    public static EntityManager getEntityManage() {
        if (factory == null || factory.isOpen()) {
            factory = Persistence.createEntityManagerFactory("pro1041");
        }
        return factory.createEntityManager();
    }

    public static void shutdown() {
        if (factory.isOpen() && factory != null) {
            factory.close();
        }
        factory = null;
    }

}

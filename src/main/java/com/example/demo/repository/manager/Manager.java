package com.example.demo.repository.manager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.function.Function;

public class Manager {
    private final static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");

    private Manager(){}

    public static <R> R doTransaction (Function<EntityManager,R> function){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            R theReturn = function.apply(entityManager);
            entityManager.getTransaction().commit();

            return theReturn;
        }catch (Exception exception){
            entityManager.getTransaction().rollback();
            throw exception;
        } finally {
            entityManager.close();
        }
    }
}

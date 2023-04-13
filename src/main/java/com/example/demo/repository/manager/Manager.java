package com.example.demo.repository.manager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

import java.util.function.Function;

public class Manager {
    private Manager(){}

    public static <R> R doTransaction (Function<EntityManager,R> function){
        EntityManager entityManager = MyThreadLocal.local.get();
        try {
            entityManager.getTransaction().begin();
            R theReturn = function.apply(entityManager);
            entityManager.getTransaction().commit();

            return theReturn;
        }catch (PersistenceException exception){
            entityManager.getTransaction().rollback();
            throw exception;
        }
    }
}

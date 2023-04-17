package com.example.demo.repository.manager;

import jakarta.persistence.EntityManager;

public enum MyThreadLocal {
    MY_THREAD_LOCAL;
    ThreadLocal<EntityManager> local = new ThreadLocal<>();
    public EntityManager getLocal(){
        return local.get();
    }
    public void setLocal(EntityManager entityManager){
        local.set(entityManager);
    }
}
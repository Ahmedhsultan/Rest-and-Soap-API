package com.example.demo.repository.manager;

import jakarta.persistence.EntityManager;

public class MyThreadLocal {
    public static final ThreadLocal<EntityManager> local = new ThreadLocal<>();
}
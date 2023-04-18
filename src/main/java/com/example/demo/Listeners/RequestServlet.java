package com.example.demo.Listeners;

import com.example.demo.repository.manager.MyThreadLocal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class RequestServlet implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        EntityManagerFactory entityManagerFactory = (EntityManagerFactory)sre.getServletContext().getAttribute("EntityManagerFactory");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        MyThreadLocal.local.set(entityManager);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        EntityManager entityManager = MyThreadLocal.local.get();
        entityManager.close();
    }
}

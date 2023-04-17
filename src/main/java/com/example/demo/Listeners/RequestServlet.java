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
        MyThreadLocal.MY_THREAD_LOCAL.setLocal(entityManager);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        EntityManager entityManager = MyThreadLocal.MY_THREAD_LOCAL.getLocal();
        entityManager.close();
    }
}

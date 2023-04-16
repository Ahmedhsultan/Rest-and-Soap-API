package com.example.demo.Listeners;

import com.example.demo.repository.repos.UnitOfWork;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //Create UniteOfWork
        UnitOfWork.create();

        //Create EntityManagerFactory from persisteance unit
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        sce.getServletContext().setAttribute("EntityManagerFactory",entityManagerFactory);
    }
}

package com.example.demo.servicies;

import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletRequest;
public class ActorService {

    protected HttpServletRequest request;
    protected EntityManager entityManager;
    public ActorService(HttpServletRequest request){
        this.request = request;
        this.entityManager = (EntityManager) request.getAttribute("EntityManager");
    }


}

package com.example.demo.servicies;

import com.example.demo.repository.entities.Actor;
import com.example.demo.repository.repos.ActorRepo;
import com.example.demo.webserviceies.soap.exception.SoapException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.HibernateException;

import java.time.Instant;

public class ActorService {

    private HttpServletRequest request;
    private EntityManager entityManager;
    private ActorRepo actorRepo;

    public ActorService(HttpServletRequest request){
        this.request = request;
        this.entityManager = (EntityManager) request.getAttribute("EntityManager");

        this.actorRepo = new ActorRepo(entityManager);
    }

    public Actor create(String firstName, String lastName) throws SoapException{
        Actor actor = new Actor();
        actor.setFirstName(firstName);
        actor.setLastName(lastName);
        actor.setLastUpdate(Instant.now());

        try {
            actorRepo.save(actor);
        }catch (PersistenceException persistenceException){
            throw new SoapException("Cant save this actor");
        }

        return actor;
    }
}

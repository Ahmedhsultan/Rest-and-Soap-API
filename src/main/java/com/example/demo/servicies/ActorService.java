package com.example.demo.servicies;

import com.example.demo.repository.entities.Actor;
import com.example.demo.repository.repos.ActorRepo;
import com.example.demo.webserviceies.soap.exception.SoapException;
import jakarta.persistence.PersistenceException;
import java.time.Instant;

public class ActorService {
    private ActorRepo actorRepo;

    public ActorService(){
        //Create objects from repositories
        this.actorRepo = new ActorRepo();
    }

    public Actor create(String firstName, String lastName) throws SoapException{
        //Create object of actor
        Actor actor = new Actor();
        actor.setFirstName(firstName);
        actor.setLastName(lastName);
        actor.setLastUpdate(Instant.now());

        //Save this actor
        try {
            actorRepo.save(actor);
        }catch (PersistenceException persistenceException){
            throw new SoapException("Can't save this actor!!");
        }

        return actor;
    }
}

package com.example.demo.servicies;

import com.example.demo.repository.entities.Actor;
import com.example.demo.repository.repos.ActorRepo;
import com.example.demo.webserviceies.rest.DTOs.ActorDTO;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;

import java.time.Instant;

public class ActorService {
    private ActorRepo actorRepo;
    private ModelMapper modelMapper;

    public ActorService(){
        //Create objects from repositories
        this.modelMapper = new ModelMapper();
        this.actorRepo = new ActorRepo();
    }

    public Actor create(ActorDTO actorDTO) throws PersistenceException{
        //Create object of actor
        Actor actor = modelMapper.map(actorDTO, Actor.class);
        actor.setLastUpdate(Instant.now());

        //Save this actor
        try {
            actorRepo.save(actor);
        }catch (PersistenceException persistenceException){
            throw new PersistenceException("Can't save this actor!!");
        }

        return actor;
    }
}

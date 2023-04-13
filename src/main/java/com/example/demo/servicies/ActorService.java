package com.example.demo.servicies;

import com.example.demo.repository.entities.Actor;
import com.example.demo.repository.repos.ActorRepo;
import com.example.demo.webserviceies.rest.DTOs.requests.ActorDTOReq;
import com.example.demo.webserviceies.rest.DTOs.resources.ActorDTOResp;
import com.example.demo.webserviceies.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

public class ActorService extends BaseService<Actor, ActorDTOResp, ActorRepo>{
    private ActorRepo actorRepo;
    private ModelMapper modelMapper;

    public ActorService(){
        super(new ActorRepo(), ActorDTOResp.class);
        //Create objects from repositories
        this.modelMapper = new ModelMapper();
        this.actorRepo = new ActorRepo();
    }

    public Actor create(ActorDTOReq actorDTOReq) throws PersistenceException{
        //Create object of actor
        Actor actor = modelMapper.map(actorDTOReq, Actor.class);
        actor.setLastUpdate(Instant.now());

        //Save this actor
        try {
            actorRepo.save(actor);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this actor!!");
        }

        return actor;
    }
}

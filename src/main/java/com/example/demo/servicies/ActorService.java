package com.example.demo.servicies;

import com.example.demo.repository.entities.Actor;
import com.example.demo.repository.repos.ActorRepo;
import com.example.demo.repository.UnitOfWork;
import com.example.demo.webservices.rest.DTOs.requests.ActorDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.ActorDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

public class ActorService extends BaseService<Actor, ActorDTOResp, ActorRepo, ActorDTOReq>{
    private ModelMapper modelMapper;

    public ActorService(){
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Actor post(ActorDTOReq actorDTOReq) throws PersistenceException{
        //Create object of actor
        Actor actor = modelMapper.map(actorDTOReq, Actor.class);
        actor.setLastUpdate(Instant.now());

        //Save this actor
        try {
            UnitOfWork.actorRepo.save(actor);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this actor!!");
        }

        return actor;
    }
}

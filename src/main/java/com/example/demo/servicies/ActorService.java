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
}

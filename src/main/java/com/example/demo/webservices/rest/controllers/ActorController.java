package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.ActorService;
import com.example.demo.webservices.rest.DTOs.requests.ActorDTOReq;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("actor")
public class ActorController extends BaseController<ActorService>{
    public ActorController(){
        super(new ActorService());
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(ActorDTOReq actorDTOReq) {
        ActorService actorService = new ActorService();
        actorService.create(actorDTOReq);

        return Response.ok().build();
    }
}

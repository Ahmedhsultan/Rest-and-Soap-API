package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.ActorService;
import com.example.demo.webserviceies.rest.DTOs.ActorDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("actor")
public class ActorController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getActor(ActorDTO actorDTO) {
        ActorService actorService = new ActorService();
        actorService.create(actorDTO);

        return Response.ok().build();
    }
}

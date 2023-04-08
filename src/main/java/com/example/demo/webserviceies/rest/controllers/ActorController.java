package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.repository.entities.Actor;
import com.example.demo.servicies.ActorService;
import com.example.demo.webserviceies.rest.DTOs.ActorDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("actor")
public class ActorController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(ActorDTO actorDTO) {
        ActorService actorService = new ActorService();
        actorService.create(actorDTO);

        return Response.ok().build();
    }
    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    public Response get(@QueryParam("column") String columnName,
                             @QueryParam("value") String value) {
        ActorService actorService = new ActorService();
        Actor actor = actorService.get(columnName, value);

        return Response.ok(actor).build();
    }
    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    public Response delete(@QueryParam("column") String columnName,
                        @QueryParam("value") String value) {
        ActorService actorService = new ActorService();
        Boolean status = actorService.delete(columnName, value);

        if (status)
            return Response.ok().build();
        else
            return Response.status(Response.Status.EXPECTATION_FAILED).build();
    }
}

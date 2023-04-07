package com.example.demo.webserviceies.rest.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("actor")
public class ActorController {
    @GET
    public Response getActor() {
        return Response.ok().build();
    }
}

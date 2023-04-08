package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.FilmActorService;
import com.example.demo.webserviceies.rest.DTOs.FilmActorDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("filmactor")
public class FilmActorController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(FilmActorDTO filmActorDTO){
        FilmActorService filmActorService = new FilmActorService();
        filmActorService.create(filmActorDTO);

        return Response.ok().build();
    }
}

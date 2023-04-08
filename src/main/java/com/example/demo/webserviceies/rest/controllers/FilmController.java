package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.FilmService;
import com.example.demo.webserviceies.rest.DTOs.FilmDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("film")
public class FilmController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(FilmDTO filmDTO){
        FilmService filmService = new FilmService();
        filmService.create(filmDTO);

        return Response.ok().build();
    }
}

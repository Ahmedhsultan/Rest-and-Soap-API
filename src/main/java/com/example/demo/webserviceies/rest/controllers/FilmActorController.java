package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.CountryService;
import com.example.demo.servicies.FilmActorService;
import com.example.demo.webserviceies.rest.DTOs.requests.FilmActorDTOReq;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("filmactor")
public class FilmActorController extends BaseController<FilmActorService>{
    public FilmActorController(){
        super(new FilmActorService());
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(FilmActorDTOReq filmActorDTOReq){
        FilmActorService filmActorService = new FilmActorService();
        filmActorService.create(filmActorDTOReq);

        return Response.ok().build();
    }
}

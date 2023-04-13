package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.FilmService;
import com.example.demo.webserviceies.rest.DTOs.requests.FilmDTOReq;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("film")
public class FilmController extends BaseController<FilmService>{
    public FilmController(){
        super(new FilmService());
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(FilmDTOReq filmDTOReq){
        FilmService filmService = new FilmService();
        filmService.create(filmDTOReq);

        return Response.ok().build();
    }
}

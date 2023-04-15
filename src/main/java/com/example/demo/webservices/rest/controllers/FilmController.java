package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.FilmService;
import com.example.demo.webservices.rest.DTOs.requests.FilmDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.ActorDTOResp;
import com.example.demo.webservices.rest.DTOs.resources.FilmDTOResp;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("film")
public class FilmController extends BaseController<FilmDTOResp, FilmService>{
    public FilmController() throws InstantiationException, IllegalAccessException {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(FilmDTOReq filmDTOReq){
        FilmService filmService = new FilmService();
        filmService.create(filmDTOReq);

        return Response.ok().build();
    }
}

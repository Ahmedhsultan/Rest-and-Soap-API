package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.FilmActorService;
import com.example.demo.webservices.rest.DTOs.requests.FilmActorDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.FilmActorDTOResp;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("filmactor")
public class FilmActorController extends BaseController<FilmActorDTOResp, FilmActorService>{
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

    @Override
    public Response get(String columnName, String value) {
        FilmActorService filmActorService = new FilmActorService();

        List<FilmActorDTOResp> actorDTOResp = new ArrayList<>();
        if (columnName.toLowerCase().equals("filmid"))
            actorDTOResp = filmActorService.getByFilm(Integer.parseInt(value));
        else if (columnName.toLowerCase().equals("actorid")) {
            actorDTOResp = filmActorService.getByActor(Integer.parseInt(value));
        }

        return Response.ok(actorDTOResp).build();
    }
}
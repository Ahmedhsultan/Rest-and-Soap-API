package com.example.demo.webservices.rest.controllers;


import com.example.demo.servicies.FilmActorService;
import com.example.demo.webservices.rest.DTOs.requests.FilmActorDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.FilmActorDTOResp;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("filmactor")
public class FilmActorController extends BaseController<FilmActorDTOResp, FilmActorService, FilmActorDTOReq>{
    public FilmActorController() throws InstantiationException, IllegalAccessException {
    }

    @Override
    public Response get(@QueryParam("column") String columnName,
                        @QueryParam("value") String value,
                        @DefaultValue(value = "0")@QueryParam("pageNumber") Integer pageNumber,
                        @DefaultValue(value = "10")@QueryParam("count") Integer count) {
        FilmActorService filmActorService = new FilmActorService();

        List<FilmActorDTOResp> actorDTOResp = new ArrayList<>();
        if (columnName.equalsIgnoreCase("filmid"))
            actorDTOResp = filmActorService.getByFilm(Integer.parseInt(value));
        else if (columnName.equalsIgnoreCase("actorid")) {
            actorDTOResp = filmActorService.getByActor(Integer.parseInt(value));
        }

        return Response.ok(actorDTOResp).build();
    }
}
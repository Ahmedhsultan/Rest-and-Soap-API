package com.example.demo.webservices.rest.controllers;

import com.example.demo.repository.entities.FilmCategory;
import com.example.demo.servicies.FilmActorService;
import com.example.demo.servicies.FilmCategoryService;
import com.example.demo.webservices.rest.DTOs.requests.FilmCategoryDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.FilmActorDTOResp;
import com.example.demo.webservices.rest.DTOs.resources.FilmCategoryDTOResp;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path(("filmcategory"))
public class FilmCategoryController extends BaseController<FilmCategoryDTOResp, FilmCategoryService>{
    public FilmCategoryController(){
        super(new FilmCategoryService());
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(FilmCategoryDTOReq filmCategoryDTOReq){
        FilmCategoryService filmCategoryService = new FilmCategoryService();
        filmCategoryService.create(filmCategoryDTOReq);

        return Response.ok().build();
    }

    @Override
    public Response get(String columnName, String value) {
        FilmCategoryService filmCategoryService = new FilmCategoryService();

        List<FilmCategoryDTOResp> filmCategoryDTOResps = new ArrayList<>();
        if (columnName.toLowerCase().equals("filmid"))
            filmCategoryDTOResps = filmCategoryService.getByFilm(Integer.parseInt(value));
        else if (columnName.toLowerCase().equals("categoryid")) {
            filmCategoryDTOResps = filmCategoryService.getByCategory(Integer.parseInt(value));
        }

        return Response.ok(filmCategoryDTOResps).build();
    }
}

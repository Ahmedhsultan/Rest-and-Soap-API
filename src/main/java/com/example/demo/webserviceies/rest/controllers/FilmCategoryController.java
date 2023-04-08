package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.FilmActorService;
import com.example.demo.servicies.FilmCategoryService;
import com.example.demo.webserviceies.rest.DTOs.FilmActorDTO;
import com.example.demo.webserviceies.rest.DTOs.FilmCategoryDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(("filmcategory"))
public class FilmCategoryController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(FilmCategoryDTO filmCategoryDTO){
        FilmCategoryService filmCategoryService = new FilmCategoryService();
        filmCategoryService.create(filmCategoryDTO);

        return Response.ok().build();
    }
}

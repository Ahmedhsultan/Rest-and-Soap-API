package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.CountryService;
import com.example.demo.servicies.FilmCategoryService;
import com.example.demo.webserviceies.rest.DTOs.requests.FilmCategoryDTOReq;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(("filmcategory"))
public class FilmCategoryController extends BaseController<FilmCategoryService>{
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
}

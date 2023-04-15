package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.FilmCategoryService;
import com.example.demo.webservices.rest.DTOs.requests.FilmCategoryDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.ActorDTOResp;
import com.example.demo.webservices.rest.DTOs.resources.FilmCategoryDTOResp;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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
}

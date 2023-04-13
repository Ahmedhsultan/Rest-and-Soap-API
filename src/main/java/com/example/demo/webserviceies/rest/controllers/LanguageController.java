package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.FilmCategoryService;
import com.example.demo.servicies.LanguageService;
import com.example.demo.webserviceies.rest.DTOs.requests.LanguageDTOReq;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("language")
public class LanguageController extends BaseController<LanguageService>{
    public LanguageController(){
        super(new LanguageService());
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(LanguageDTOReq languageDTOReq){
        LanguageService languageService = new LanguageService();
        languageService.create(languageDTOReq);

        return Response.ok().build();
    }
}

package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.LanguageService;
import com.example.demo.webserviceies.rest.DTOs.LanguageDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("language")
public class LanguageController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(LanguageDTO languageDTO){
        LanguageService languageService = new LanguageService();
        languageService.create(languageDTO);

        return Response.ok().build();
    }
}

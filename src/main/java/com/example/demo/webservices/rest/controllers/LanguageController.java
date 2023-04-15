package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.LanguageService;
import com.example.demo.webservices.rest.DTOs.requests.LanguageDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.ActorDTOResp;
import com.example.demo.webservices.rest.DTOs.resources.LanguageDTOResp;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("language")
public class LanguageController extends BaseController<LanguageDTOResp, LanguageService>{
    public LanguageController() throws InstantiationException, IllegalAccessException {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(LanguageDTOReq languageDTOReq){
        LanguageService languageService = new LanguageService();
        languageService.create(languageDTOReq);

        return Response.ok().build();
    }
}

package com.example.demo.webservices.rest.controllers;


import com.example.demo.servicies.LanguageService;
import com.example.demo.webservices.rest.DTOs.requests.LanguageDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.LanguageDTOResp;
import jakarta.ws.rs.Path;

@Path("language")
public class LanguageController extends BaseController<LanguageDTOResp, LanguageService, LanguageDTOReq>{
    public LanguageController() throws InstantiationException, IllegalAccessException {
    }
}

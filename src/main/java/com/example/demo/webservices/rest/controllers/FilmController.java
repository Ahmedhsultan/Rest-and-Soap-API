package com.example.demo.webservices.rest.controllers;


import com.example.demo.servicies.FilmService;
import com.example.demo.webservices.rest.DTOs.requests.FilmDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.FilmDTOResp;
import jakarta.ws.rs.Path;

@Path("film")
public class FilmController extends BaseController<FilmDTOResp, FilmService, FilmDTOReq>{
    public FilmController() throws InstantiationException, IllegalAccessException {
    }
}

package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.CountryService;
import com.example.demo.webservices.rest.DTOs.requests.CountryDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.CountryDTOResp;
import jakarta.ws.rs.Path;

@Path("country")
public class CountryController extends BaseController<CountryDTOResp, CountryService, CountryDTOReq>{
    public CountryController() throws InstantiationException, IllegalAccessException {
    }
}

package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.CityService;
import com.example.demo.webservices.rest.DTOs.requests.CityDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.CityDTOResp;
import jakarta.ws.rs.Path;

@Path("city")
public class CityController extends BaseController<CityDTOResp, CityService, CityDTOReq>{
    public CityController() throws InstantiationException, IllegalAccessException {
    }
}

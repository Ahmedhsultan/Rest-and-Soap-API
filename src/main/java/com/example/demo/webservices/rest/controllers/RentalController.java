package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.RentalService;
import com.example.demo.webservices.rest.DTOs.requests.RentalDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.RentalDTOResp;
import jakarta.ws.rs.Path;

@Path("rental")
public class RentalController extends BaseController<RentalDTOResp, RentalService, RentalDTOReq>{
    public RentalController() throws InstantiationException, IllegalAccessException {
    }
}

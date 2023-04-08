package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.CityService;
import com.example.demo.servicies.CountryService;
import com.example.demo.webserviceies.rest.DTOs.CityDTO;
import com.example.demo.webserviceies.rest.DTOs.CountryDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("city")
public class CityController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CityDTO cityDTO){
        CityService cityService = new CityService();
        cityService.createCity(cityDTO);

        return Response.ok().build();
    }
}

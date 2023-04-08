package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.CountryService;
import com.example.demo.webserviceies.rest.DTOs.CountryDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("country")
public class CountryController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CountryDTO countryDTO){
        CountryService countryService = new CountryService();
        countryService.createCountry(countryDTO);

        return Response.ok().build();
    }
}

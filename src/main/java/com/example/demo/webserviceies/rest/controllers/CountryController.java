package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.CityService;
import com.example.demo.servicies.CountryService;
import com.example.demo.webserviceies.rest.DTOs.requests.CountryDTOReq;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("country")
public class CountryController extends BaseController<CountryService>{
    public CountryController(){
        super(new CountryService());
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CountryDTOReq countryDTOReq){
        CountryService countryService = new CountryService();
        countryService.createCountry(countryDTOReq);

        return Response.ok().build();
    }
}

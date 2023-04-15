package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.CountryService;
import com.example.demo.webservices.rest.DTOs.requests.CountryDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.ActorDTOResp;
import com.example.demo.webservices.rest.DTOs.resources.CountryDTOResp;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("country")
public class CountryController extends BaseController<CountryDTOResp, CountryService>{
    public CountryController() throws InstantiationException, IllegalAccessException {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CountryDTOReq countryDTOReq){
        CountryService countryService = new CountryService();
        countryService.createCountry(countryDTOReq);

        return Response.ok().build();
    }
}

package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.CityService;
import com.example.demo.webservices.rest.DTOs.requests.CityDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.ActorDTOResp;
import com.example.demo.webservices.rest.DTOs.resources.CityDTOResp;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("city")
public class CityController extends BaseController<CityDTOResp, CityService>{
    public CityController(){
        super(new CityService());
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CityDTOReq cityDTOReq){
        CityService cityService = new CityService();
        cityService.createCity(cityDTOReq);

        return Response.ok().build();
    }
}

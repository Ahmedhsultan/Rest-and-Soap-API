package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.RentalService;
import com.example.demo.webservices.rest.DTOs.requests.RentalDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.ActorDTOResp;
import com.example.demo.webservices.rest.DTOs.resources.RentalDTOResp;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("rental")
public class RentalController extends BaseController<RentalDTOResp, RentalService>{
    public RentalController(){
        super(new RentalService());
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(RentalDTOReq rentalDTOReq){
        RentalService rentalService = new RentalService();
        rentalService.create(rentalDTOReq);

        return Response.ok().build();
    }
}

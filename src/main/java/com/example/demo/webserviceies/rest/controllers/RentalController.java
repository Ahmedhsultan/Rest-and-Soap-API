package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.PaymentService;
import com.example.demo.servicies.RentalService;
import com.example.demo.webserviceies.rest.DTOs.requests.RentalDTOReq;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("rental")
public class RentalController extends BaseController<RentalService>{
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

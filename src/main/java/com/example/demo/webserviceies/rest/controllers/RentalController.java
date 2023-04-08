package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.RentalService;
import com.example.demo.webserviceies.rest.DTOs.RentalDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("rental")
public class RentalController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(RentalDTO rentalDTO){
        RentalService rentalService = new RentalService();
        rentalService.create(rentalDTO);

        return Response.ok().build();
    }
}

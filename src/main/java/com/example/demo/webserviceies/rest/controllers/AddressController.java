package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.AddressService;
import com.example.demo.webserviceies.rest.DTOs.AddressDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("address")
public class AddressController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(AddressDTO addressDTO){
        AddressService addressService = new AddressService();
        addressService.createAddress(addressDTO);

        return Response.ok().build();
    }
}

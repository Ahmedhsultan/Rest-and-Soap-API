package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.CustomerService;
import com.example.demo.webserviceies.rest.DTOs.CustomerDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("customer")
public class CustomerController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CustomerDTO customerDTO){
        CustomerService customerService = new CustomerService();
        customerService.create(customerDTO);

        return Response.ok().build();
    }
}

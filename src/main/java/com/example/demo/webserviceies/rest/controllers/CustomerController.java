package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.CountryService;
import com.example.demo.servicies.CustomerService;
import com.example.demo.webserviceies.rest.DTOs.requests.CustomerDTOReq;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("customer")
public class CustomerController extends BaseController<CustomerService>{
    public CustomerController(){
        super(new CustomerService());
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CustomerDTOReq customerDTOReq){
        CustomerService customerService = new CustomerService();
        customerService.create(customerDTOReq);

        return Response.ok().build();
    }
}

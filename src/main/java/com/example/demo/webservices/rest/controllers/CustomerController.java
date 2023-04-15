package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.CustomerService;
import com.example.demo.webservices.rest.DTOs.requests.CustomerDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.ActorDTOResp;
import com.example.demo.webservices.rest.DTOs.resources.CategoryDTOResp;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("customer")
public class CustomerController extends BaseController<CategoryDTOResp, CustomerService>{
    public CustomerController() throws InstantiationException, IllegalAccessException {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CustomerDTOReq customerDTOReq){
        CustomerService customerService = new CustomerService();
        customerService.create(customerDTOReq);

        return Response.ok().build();
    }
}

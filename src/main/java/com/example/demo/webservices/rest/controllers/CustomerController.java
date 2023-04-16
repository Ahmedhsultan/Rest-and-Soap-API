package com.example.demo.webservices.rest.controllers;


import com.example.demo.servicies.CustomerService;
import com.example.demo.webservices.rest.DTOs.requests.CustomerDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.CategoryDTOResp;
import jakarta.ws.rs.Path;

@Path("customer")
public class CustomerController extends BaseController<CategoryDTOResp, CustomerService, CustomerDTOReq>{
    public CustomerController() throws InstantiationException, IllegalAccessException {
    }
}

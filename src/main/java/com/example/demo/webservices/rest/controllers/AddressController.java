package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.AddressService;
import com.example.demo.webservices.rest.DTOs.requests.AddressDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.AddressDTOResp;
import jakarta.ws.rs.Path;


@Path("address")
public class AddressController extends BaseController<AddressDTOResp,AddressService, AddressDTOReq>{
    public AddressController() throws InstantiationException, IllegalAccessException {
    }
}

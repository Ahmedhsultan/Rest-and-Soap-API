package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.AddressService;
import com.example.demo.webserviceies.rest.DTOs.requests.AddressDTOReq;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("address")
public class AddressController extends BaseController<AddressService>{
    public AddressController(){
        super(new AddressService());
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(AddressDTOReq addressDTOReq){
        AddressService addressService = new AddressService();
        addressService.createAddress(addressDTOReq);

        return Response.ok().build();
    }
}

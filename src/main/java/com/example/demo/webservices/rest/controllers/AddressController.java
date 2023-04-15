package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.AddressService;
import com.example.demo.webservices.rest.DTOs.requests.AddressDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.ActorDTOResp;
import com.example.demo.webservices.rest.DTOs.resources.AddressDTOResp;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("address")
public class AddressController extends BaseController<AddressDTOResp,AddressService>{
    public AddressController() throws InstantiationException, IllegalAccessException {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(AddressDTOReq addressDTOReq){
        AddressService addressService = new AddressService();
        addressService.createAddress(addressDTOReq);

        return Response.ok().build();
    }
}

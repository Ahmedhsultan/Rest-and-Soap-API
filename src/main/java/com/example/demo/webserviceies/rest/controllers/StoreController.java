package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.StoreService;
import com.example.demo.webserviceies.rest.DTOs.StoreDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("store")
public class StoreController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(StoreDTO storeDTO){
        StoreService storeService = new StoreService();
//        storeService.create(storeDTO);

        return Response.ok().build();
    }
}

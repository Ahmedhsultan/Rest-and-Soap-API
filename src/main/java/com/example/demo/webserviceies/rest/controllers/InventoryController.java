package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.InventoryService;
import com.example.demo.webserviceies.rest.DTOs.requests.InventoryDTOReq;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("inventory")
public class InventoryController extends BaseController<InventoryService>{
    public InventoryController(){
        super(new InventoryService());
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(InventoryDTOReq inventoryDTOReq){
        InventoryService inventoryService = new InventoryService();
        inventoryService.create(inventoryDTOReq);

        return Response.ok().build();
    }
}

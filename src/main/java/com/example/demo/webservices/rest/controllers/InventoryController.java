package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.InventoryService;
import com.example.demo.webservices.rest.DTOs.requests.InventoryDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.ActorDTOResp;
import com.example.demo.webservices.rest.DTOs.resources.InventoryDTOResp;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("inventory")
public class InventoryController extends BaseController<InventoryDTOResp, InventoryService>{
    public InventoryController() throws InstantiationException, IllegalAccessException {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(InventoryDTOReq inventoryDTOReq){
        InventoryService inventoryService = new InventoryService();
        inventoryService.create(inventoryDTOReq);

        return Response.ok().build();
    }
}

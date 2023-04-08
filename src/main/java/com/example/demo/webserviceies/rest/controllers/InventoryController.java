package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.InventoryService;
import com.example.demo.webserviceies.rest.DTOs.InventoryDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("inventory")
public class InventoryController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(InventoryDTO inventoryDTO){
        InventoryService inventoryService = new InventoryService();
        inventoryService.create(inventoryDTO);

        return Response.ok().build();
    }
}

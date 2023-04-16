package com.example.demo.webservices.rest.controllers;


import com.example.demo.servicies.InventoryService;
import com.example.demo.webservices.rest.DTOs.requests.InventoryDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.InventoryDTOResp;
import jakarta.ws.rs.Path;

@Path("inventory")
public class InventoryController extends BaseController<InventoryDTOResp, InventoryService, InventoryDTOReq>{
    public InventoryController() throws InstantiationException, IllegalAccessException {
    }
}

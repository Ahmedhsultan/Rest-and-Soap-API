package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.StoreService;
import com.example.demo.webservices.rest.DTOs.requests.StoreDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.StoreDTOResp;
import jakarta.ws.rs.Path;

@Path("store")
public class StoreController extends BaseController<StoreDTOResp, StoreService, StoreDTOReq> {
    public StoreController() throws InstantiationException, IllegalAccessException {
    }
}

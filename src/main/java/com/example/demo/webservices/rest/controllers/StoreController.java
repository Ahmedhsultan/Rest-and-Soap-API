package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.StoreService;
import com.example.demo.webservices.rest.DTOs.requests.StoreDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.ActorDTOResp;
import com.example.demo.webservices.rest.DTOs.resources.StoreDTOResp;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("store")
public class StoreController extends BaseController<StoreDTOResp, StoreService, StoreDTOReq>{
    public StoreController() throws InstantiationException, IllegalAccessException {
    }
}

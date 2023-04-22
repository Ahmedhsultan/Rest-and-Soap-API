package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.ActorService;
import com.example.demo.webservices.rest.DTOs.requests.ActorDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.ActorDTOResp;
import jakarta.ws.rs.Path;

@Path("actor")
public class ActorController extends BaseController<ActorDTOResp, ActorService, ActorDTOReq> {
    public ActorController() throws InstantiationException, IllegalAccessException {
    }
}

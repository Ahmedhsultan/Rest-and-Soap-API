package com.example.demo.webserviceies.soap.controllers;

import com.example.demo.servicies.ActorService;
import com.example.demo.webserviceies.rest.DTOs.requests.ActorDTOReq;
import com.example.demo.webserviceies.soap.exception.SoapException;
import jakarta.jws.WebService;

@WebService
public class ActorWS {
    public void create(ActorDTOReq actorDTOReq) throws SoapException {
        //Create actor by service
        ActorService actorService = new ActorService();
        actorService.create(actorDTOReq);
    }
}

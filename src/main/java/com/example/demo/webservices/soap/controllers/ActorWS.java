package com.example.demo.webservices.soap.controllers;

import com.example.demo.servicies.ActorService;
import com.example.demo.webservices.rest.DTOs.requests.ActorDTOReq;
import com.example.demo.webservices.soap.exception.SoapException;
import jakarta.jws.WebService;

@WebService
public class ActorWS {
    public void create(ActorDTOReq actorDTOReq) throws SoapException {
        //Create actor by service
        ActorService actorService = new ActorService();
        actorService.post(actorDTOReq);
    }
}

package com.example.demo.webserviceies.soap.controllers;

import com.example.demo.servicies.ActorService;
import com.example.demo.webserviceies.rest.DTOs.ActorDTO;
import com.example.demo.webserviceies.soap.exception.SoapException;
import jakarta.jws.WebService;

@WebService
public class ActorWS {
    public void create(ActorDTO actorDTO) throws SoapException {
        //Create actor by service
        ActorService actorService = new ActorService();
        actorService.create(actorDTO);
    }
}

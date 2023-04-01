package com.example.demo.webserviceies.soap.controllers;

import com.example.demo.repository.entities.Actor;
import com.example.demo.servicies.ActorService;
import com.example.demo.webserviceies.soap.exception.SoapException;
import jakarta.annotation.Resource;
import jakarta.jws.WebService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.xml.ws.WebServiceContext;
import jakarta.xml.ws.handler.MessageContext;

@WebService
public class ActorWS {

    @Resource
    private WebServiceContext context;

    public void create(String firstName, String lastName) throws SoapException {
        //Create request
        MessageContext messageContext = context.getMessageContext();
        HttpServletRequest request = (HttpServletRequest) messageContext.get(MessageContext.SERVLET_REQUEST);

        //Create actor by service
        ActorService actorService = new ActorService(request);
        actorService.create(firstName, lastName);
    }
}

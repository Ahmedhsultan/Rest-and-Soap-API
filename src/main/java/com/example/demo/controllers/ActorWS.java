package com.example.demo.controllers;

import com.example.demo.servicies.ActorService;
import jakarta.annotation.Resource;
import jakarta.jws.WebService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.xml.ws.WebServiceContext;
import jakarta.xml.ws.handler.MessageContext;

@WebService
public class ActorWS {

    @Resource
    private WebServiceContext context;

    public boolean create(String name){
        MessageContext messageContext = context.getMessageContext();
        HttpServletRequest request = (HttpServletRequest) messageContext.get(MessageContext.SERVLET_REQUEST);

        ActorService actorService = new ActorService(request);

        return true;
    }
}

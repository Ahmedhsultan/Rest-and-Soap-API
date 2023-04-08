package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.PaymentService;
import com.example.demo.webserviceies.rest.DTOs.PaymentDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("payment")
public class PaymentController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(PaymentDTO paymentDTO){
        PaymentService paymentService = new PaymentService();
        paymentService.create(paymentDTO);

        return Response.ok().build();
    }
}

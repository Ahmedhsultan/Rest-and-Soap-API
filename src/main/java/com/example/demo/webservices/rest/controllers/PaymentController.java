package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.PaymentService;
import com.example.demo.webservices.rest.DTOs.requests.PaymentDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.ActorDTOResp;
import com.example.demo.webservices.rest.DTOs.resources.PaymentDTOResp;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("payment")
public class PaymentController extends BaseController<PaymentDTOResp, PaymentService>{
    public PaymentController(){
        super(new PaymentService());
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(PaymentDTOReq paymentDTOReq){
        PaymentService paymentService = new PaymentService();
        paymentService.create(paymentDTOReq);

        return Response.ok().build();
    }
}

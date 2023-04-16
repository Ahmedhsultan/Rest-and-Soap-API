package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.PaymentService;
import com.example.demo.webservices.rest.DTOs.requests.PaymentDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.PaymentDTOResp;
import jakarta.ws.rs.Path;

@Path("payment")
public class PaymentController extends BaseController<PaymentDTOResp, PaymentService, PaymentDTOReq>{
    public PaymentController() throws InstantiationException, IllegalAccessException {
    }
}

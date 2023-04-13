package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.PaymentService;
import com.example.demo.servicies.StaffService;
import com.example.demo.webserviceies.rest.DTOs.requests.StaffDTOReq;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("staff")
public class StaffController extends BaseController<StaffService>{
    public StaffController(){
        super(new StaffService());
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(StaffDTOReq staffDTOReq){
        StaffService staffService = new StaffService();
        staffService.create(staffDTOReq);

        return Response.ok().build();
    }
}

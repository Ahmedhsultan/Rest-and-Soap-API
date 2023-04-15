package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.StaffService;
import com.example.demo.webservices.rest.DTOs.requests.StaffDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.ActorDTOResp;
import com.example.demo.webservices.rest.DTOs.resources.StaffDTOResp;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("staff")
public class StaffController extends BaseController<StaffDTOResp, StaffService>{
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

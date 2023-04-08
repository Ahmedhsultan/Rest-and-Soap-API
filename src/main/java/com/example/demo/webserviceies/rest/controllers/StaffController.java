package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.StaffService;
import com.example.demo.webserviceies.rest.DTOs.StaffDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("staff")
public class StaffController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(StaffDTO staffDTO){
        StaffService staffService = new StaffService();
        staffService.create(staffDTO);

        return Response.ok().build();
    }
}

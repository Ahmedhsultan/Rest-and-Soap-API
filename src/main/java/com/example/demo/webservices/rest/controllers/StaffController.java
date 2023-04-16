package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.StaffService;
import com.example.demo.webservices.rest.DTOs.requests.StaffDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.StaffDTOResp;
import jakarta.ws.rs.Path;

@Path("staff")
public class StaffController extends BaseController<StaffDTOResp, StaffService, StaffDTOReq>{
    public StaffController() throws InstantiationException, IllegalAccessException {
    }
}

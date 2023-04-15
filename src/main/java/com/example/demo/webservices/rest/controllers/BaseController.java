package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.BaseService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class BaseController <DTOResp,Service extends BaseService>{
    private Service service;
    protected BaseController(Service service){this.service = service;}
    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    public Response get(@QueryParam("column") String columnName,
                        @QueryParam("value") String value) {
        var actorDTOResp = service.get(columnName, value);

        return Response.ok(actorDTOResp).build();
    }
    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    public Response delete(@QueryParam("column") String columnName,
                           @QueryParam("value") String value) {
        service.delete(columnName, value);

        return Response.ok().build();
    }
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(DTOResp dtoResp) {
        service.delete(dtoResp);

        return Response.ok().build();
    }
}

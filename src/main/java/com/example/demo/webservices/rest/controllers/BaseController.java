package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.BaseService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class BaseController <DTOResp,Service extends BaseService, DTOReq>{
    private Service service;
    protected BaseController() throws InstantiationException, IllegalAccessException {
        //Create new instance from service by reflection
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        Type[] typeArguments = genericSuperclass.getActualTypeArguments();
        Class<Service> serviceClass = (Class<Service>) typeArguments[1];
        this.service = serviceClass.newInstance();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(DTOReq dtoReq){
        var entity = service.post(dtoReq);

        return Response.status(Response.Status.CREATED).entity(entity).build();
    }
    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    public Response get(@QueryParam("column") String columnName,
                        @QueryParam("value") String value,
                        @DefaultValue(value = "0")@QueryParam("pageNumber") Integer pageNumber,
                        @DefaultValue(value = "10")@QueryParam("count") Integer count) {
        var actorDTOResp = service.get(columnName, value, pageNumber, count);

        return Response.ok(actorDTOResp).build();
    }
    @GET
    @Path("/getAll")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response getAll() {
        var actorDTOResps = service.getAll();

        return Response.ok(actorDTOResps).build();
    }
    @GET
    @Path("/count")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response getCount() {
        var count = service.getCount();

        return Response.ok("Rows Number is : " + count).build();
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
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(DTOResp dtoResp) {
        service.put(dtoResp);

        return Response.ok().build();
    }
    @OPTIONS
    public Response options() {
        return Response.status(Response.Status.OK)
                        .header("Allow", "GET, POST, PUT, DELETE, OPTIONS")
                        .build();
    }
}

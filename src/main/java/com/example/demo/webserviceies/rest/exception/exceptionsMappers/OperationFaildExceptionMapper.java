package com.example.demo.webserviceies.rest.exception.exceptionsMappers;

import com.example.demo.webserviceies.rest.exception.exceptions.OperationFaildException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class OperationFaildExceptionMapper implements ExceptionMapper<OperationFaildException> {
    @Override
    public Response toResponse(OperationFaildException e) {
        return Response.status(Response.Status.EXPECTATION_FAILED).entity(e.getLocalizedMessage()).build();
    }
}
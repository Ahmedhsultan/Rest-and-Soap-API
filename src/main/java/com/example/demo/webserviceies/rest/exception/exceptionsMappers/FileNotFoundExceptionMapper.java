package com.example.demo.webserviceies.rest.exception.exceptionsMappers;

import com.example.demo.webserviceies.rest.exception.exceptions.FileNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class FileNotFoundExceptionMapper implements ExceptionMapper<FileNotFoundException> {
    @Override
    public Response toResponse(FileNotFoundException e) {
        return Response.status(Response.Status.NOT_FOUND).entity(e.getLocalizedMessage()).build();
    }
}
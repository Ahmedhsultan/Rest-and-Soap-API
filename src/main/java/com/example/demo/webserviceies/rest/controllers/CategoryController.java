package com.example.demo.webserviceies.rest.controllers;

import com.example.demo.servicies.CategoryService;
import com.example.demo.webserviceies.rest.DTOs.CategoryDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("category")
public class CategoryController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CategoryDTO categoryDTO){
        CategoryService categoryService = new CategoryService();
        categoryService.createCategory(categoryDTO);

        return Response.ok().build();
    }
}

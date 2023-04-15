package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.CategoryService;
import com.example.demo.webservices.rest.DTOs.requests.CategoryDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.ActorDTOResp;
import com.example.demo.webservices.rest.DTOs.resources.CategoryDTOResp;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("category")
public class CategoryController extends BaseController<CategoryDTOResp, CategoryService>{
    public CategoryController(){
        super(new CategoryService());
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CategoryDTOReq categoryDTOReq){
        CategoryService categoryService = new CategoryService();
        categoryService.createCategory(categoryDTOReq);

        return Response.ok().build();
    }
}

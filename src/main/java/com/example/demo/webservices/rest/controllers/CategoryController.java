package com.example.demo.webservices.rest.controllers;

import com.example.demo.servicies.CategoryService;
import com.example.demo.webservices.rest.DTOs.requests.CategoryDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.CategoryDTOResp;
import jakarta.ws.rs.Path;

@Path("category")
public class CategoryController extends BaseController<CategoryDTOResp, CategoryService, CategoryDTOReq>{
    public CategoryController() throws InstantiationException, IllegalAccessException {
    }
}

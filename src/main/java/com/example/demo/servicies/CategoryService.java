package com.example.demo.servicies;

import com.example.demo.repository.entities.Category;
import com.example.demo.repository.repos.CategoryRepo;
import com.example.demo.webservices.rest.DTOs.requests.CategoryDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.CategoryDTOResp;

public class CategoryService extends BaseService<Category, CategoryDTOResp, CategoryRepo, CategoryDTOReq> {
}

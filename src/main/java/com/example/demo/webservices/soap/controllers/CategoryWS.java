package com.example.demo.webservices.soap.controllers;

import com.example.demo.repository.entities.Category;
import com.example.demo.servicies.CategoryService;
import com.example.demo.util.records.QueryPage;
import com.example.demo.webservices.rest.DTOs.requests.CategoryDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.CategoryDTOResp;
import com.example.demo.webservices.soap.exception.SoapException;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class CategoryWS {
    private CategoryService categoryService;

    public CategoryWS() {
        this.categoryService = new CategoryService();
    }

    public Category post(CategoryDTOReq categoryDTOReq) throws SoapException {
        Category category = categoryService.post(categoryDTOReq);

        return category;
    }

    public List<CategoryDTOResp> get(String columnName, String value, Integer pageNumber, Integer count) {
        QueryPage queryPage = new QueryPage(columnName, value, pageNumber, count);
        var categoryDTOResps = categoryService.get(queryPage);

        return categoryDTOResps;
    }

    public List<CategoryDTOResp> getAll() {
        var categoryDTOResps = categoryService.getAll();

        return categoryDTOResps;
    }

    public long getCount() {
        var count = categoryService.getCount();

        return count;
    }

    public boolean delete(String columnName, String value) {
        categoryService.delete(columnName, value);

        return true;
    }

    public boolean deleteByDTO(CategoryDTOResp dtoResp) {
        categoryService.delete(dtoResp);

        return true;
    }

    public boolean put(CategoryDTOResp dtoResp) {
        categoryService.put(dtoResp);

        return true;
    }
}

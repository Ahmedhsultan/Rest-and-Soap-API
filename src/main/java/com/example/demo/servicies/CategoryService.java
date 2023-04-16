package com.example.demo.servicies;

import com.example.demo.repository.entities.Category;
import com.example.demo.repository.repos.CategoryRepo;
import com.example.demo.webservices.rest.DTOs.requests.CategoryDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.CategoryDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

public class CategoryService extends BaseService<Category, CategoryDTOResp, CategoryRepo, CategoryDTOReq>{
    private CategoryRepo categoryRepo;
    private ModelMapper modelMapper;
    public CategoryService(){
        this.categoryRepo = new CategoryRepo();
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Category post(CategoryDTOReq categoryDTOReq) throws PersistenceException {

        Category category = modelMapper.map(categoryDTOReq, Category.class);
        category.setLastUpdate(Instant.now());

        //Save this city
        try {
            categoryRepo.save(category);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this city!!");
        }

        return category;
    }
}

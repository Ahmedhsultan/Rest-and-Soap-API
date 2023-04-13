package com.example.demo.servicies;

import com.example.demo.repository.entities.Category;
import com.example.demo.repository.repos.CategoryRepo;
import com.example.demo.webserviceies.rest.DTOs.requests.CategoryDTOReq;
import com.example.demo.webserviceies.rest.DTOs.resources.CategoryDTOResp;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

public class CategoryService extends BaseService<Category, CategoryDTOResp, CategoryRepo>{
    private CategoryRepo categoryRepo;
    private ModelMapper modelMapper;
    public CategoryService(){
        super(new CategoryRepo(), CategoryDTOResp.class);
        this.categoryRepo = new CategoryRepo();
        this.modelMapper = new ModelMapper();
    }

    public Category createCategory(CategoryDTOReq categoryDTOReq) throws PersistenceException {

        Category category = modelMapper.map(categoryDTOReq, Category.class);
        category.setLastUpdate(Instant.now());

        //Save this city
        try {
            categoryRepo.save(category);
        }catch (PersistenceException persistenceException){
            throw new PersistenceException("Can't save this city!!");
        }

        return category;
    }
}

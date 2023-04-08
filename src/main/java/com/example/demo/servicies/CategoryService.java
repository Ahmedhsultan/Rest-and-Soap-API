package com.example.demo.servicies;

import com.example.demo.repository.entities.Category;
import com.example.demo.repository.entities.City;
import com.example.demo.repository.entities.Country;
import com.example.demo.repository.repos.CategoryRepo;
import com.example.demo.repository.repos.CityRepo;
import com.example.demo.repository.repos.CountryRepo;
import com.example.demo.webserviceies.rest.DTOs.CategoryDTO;
import com.example.demo.webserviceies.rest.DTOs.CityDTO;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;

import java.time.Instant;

public class CategoryService {
    private CategoryRepo categoryRepo;
    private ModelMapper modelMapper;
    public CategoryService(){
        this.categoryRepo = new CategoryRepo();
        this.modelMapper = new ModelMapper();
    }

    public Category createCategory(CategoryDTO categoryDTO) throws PersistenceException {

        Category category = modelMapper.map(categoryDTO, Category.class);
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

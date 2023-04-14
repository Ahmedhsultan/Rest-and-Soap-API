package com.example.demo.repository.repos;

import com.example.demo.repository.entities.Category;
import jakarta.persistence.EntityManager;

public class CategoryRepo extends BaseRepo<Category, Integer>{

    public CategoryRepo() {
        super(Category.class);
    }
}

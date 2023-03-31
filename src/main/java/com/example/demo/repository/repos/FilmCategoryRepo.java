package com.example.demo.repository.repos;

import com.example.demo.repository.entities.Film;
import com.example.demo.repository.entities.FilmCategory;
import jakarta.persistence.EntityManager;

public class FilmCategoryRepo extends BaseRepo<FilmCategory, Integer, String>{

    public FilmCategoryRepo(EntityManager entityManager) {
        super(entityManager, FilmCategory.class);
    }
}

package com.example.demo.repository.repos;

import com.example.demo.repository.entities.FilmCategory;
import com.example.demo.repository.entities.FilmCategoryId;

public class FilmCategoryRepo extends BaseRepo<FilmCategory, FilmCategoryId>{

    public FilmCategoryRepo() {
        super(FilmCategory.class);
    }
}

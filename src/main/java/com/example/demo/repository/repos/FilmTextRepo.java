package com.example.demo.repository.repos;

import com.example.demo.repository.entities.FilmCategory;
import com.example.demo.repository.entities.FilmText;
import jakarta.persistence.EntityManager;

public class FilmTextRepo extends BaseRepo<FilmText, Integer>{

    public FilmTextRepo() {
        super(FilmText.class);
    }
}

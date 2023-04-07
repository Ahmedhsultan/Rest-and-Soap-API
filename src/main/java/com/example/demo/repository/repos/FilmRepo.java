package com.example.demo.repository.repos;

import com.example.demo.repository.entities.Film;
import jakarta.persistence.EntityManager;

public class FilmRepo extends BaseRepo<Film, Integer, String>{

    public FilmRepo() {
        super(Film.class);
    }
}

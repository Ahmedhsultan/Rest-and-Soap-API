package com.example.demo.repository.repos;

import com.example.demo.repository.entities.FilmActor;
import jakarta.persistence.EntityManager;

public class FilmActorRepo extends BaseRepo<FilmActor, Integer, String>{

    public FilmActorRepo() {
        super(FilmActor.class);
    }
}

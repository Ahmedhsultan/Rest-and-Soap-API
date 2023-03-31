package com.example.demo.repository.repos;

import com.example.demo.repository.entities.*;
import jakarta.persistence.EntityManager;

public class CityRepo extends BaseRepo<City, Integer, String>{

    public CityRepo(EntityManager entityManager) {
        super(entityManager, City.class);
    }
}

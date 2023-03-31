package com.example.demo.repository.repos;

import com.example.demo.repository.entities.*;
import jakarta.persistence.EntityManager;

public class CountryRepo extends BaseRepo<Country, Integer, String>{

    public CountryRepo(EntityManager entityManager) {
        super(entityManager, Country.class);
    }
}

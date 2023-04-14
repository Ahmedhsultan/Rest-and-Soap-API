package com.example.demo.repository.repos;

import com.example.demo.repository.entities.*;
import jakarta.persistence.EntityManager;

public class CountryRepo extends BaseRepo<Country, Integer>{

    public CountryRepo() {
        super(Country.class);
    }
}

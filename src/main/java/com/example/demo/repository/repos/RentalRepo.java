package com.example.demo.repository.repos;

import com.example.demo.repository.entities.Rental;
import jakarta.persistence.EntityManager;

public class RentalRepo extends BaseRepo<Rental, Integer>{

    public RentalRepo() {
        super(Rental.class);
    }
}

package com.example.demo.repository.repos;

import com.example.demo.repository.entities.Address;
import jakarta.persistence.EntityManager;

public class AddressRepo extends BaseRepo<Address, Integer, String>{

    public AddressRepo(EntityManager entityManager) {
        super(entityManager, Address.class);
    }
}

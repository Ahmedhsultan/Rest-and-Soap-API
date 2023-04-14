package com.example.demo.repository.repos;

import com.example.demo.repository.entities.Address;
import jakarta.persistence.EntityManager;

public class AddressRepo extends BaseRepo<Address, Integer>{

    public AddressRepo() {
        super(Address.class);
    }
}

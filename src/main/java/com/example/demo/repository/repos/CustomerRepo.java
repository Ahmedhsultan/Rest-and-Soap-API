package com.example.demo.repository.repos;

import com.example.demo.repository.entities.Customer;
import jakarta.persistence.EntityManager;

public class CustomerRepo extends BaseRepo<Customer, Integer, String>{

    public CustomerRepo() {
        super(Customer.class);
    }
}

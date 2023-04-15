package com.example.demo.repository.repos;

import com.example.demo.repository.entities.Customer;

public class CustomerRepo extends BaseRepo<Customer, Integer>{

    public CustomerRepo() {
        super(Customer.class);
    }
}

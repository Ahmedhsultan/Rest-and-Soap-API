package com.example.demo.repository.repos;

import com.example.demo.repository.entities.Staff;
import jakarta.persistence.EntityManager;

public class StaffRepo extends BaseRepo<Staff, Integer>{

    public StaffRepo() {
        super(Staff.class);
    }
}

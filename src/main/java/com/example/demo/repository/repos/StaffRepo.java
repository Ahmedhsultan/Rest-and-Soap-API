package com.example.demo.repository.repos;

import com.example.demo.repository.entities.Staff;
import jakarta.persistence.EntityManager;

public class StaffRepo extends BaseRepo<Staff, Integer, String>{

    public StaffRepo(EntityManager entityManager) {
        super(entityManager, Staff.class);
    }
}

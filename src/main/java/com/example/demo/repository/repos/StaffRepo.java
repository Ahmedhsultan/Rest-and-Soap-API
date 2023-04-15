package com.example.demo.repository.repos;

import com.example.demo.repository.entities.Staff;

public class StaffRepo extends BaseRepo<Staff, Integer>{

    public StaffRepo() {
        super(Staff.class);
    }
}

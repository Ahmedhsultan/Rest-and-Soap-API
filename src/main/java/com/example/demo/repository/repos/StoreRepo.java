package com.example.demo.repository.repos;

import com.example.demo.repository.entities.Store;
import jakarta.persistence.EntityManager;

public class StoreRepo extends BaseRepo<Store, Integer, String>{

    public StoreRepo() {
        super(Store.class);
    }
}

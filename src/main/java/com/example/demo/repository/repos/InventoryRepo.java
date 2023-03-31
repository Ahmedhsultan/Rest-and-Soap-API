package com.example.demo.repository.repos;

import com.example.demo.repository.entities.Inventory;
import jakarta.persistence.EntityManager;

public class InventoryRepo extends BaseRepo<Inventory, Integer, String>{

    public InventoryRepo(EntityManager entityManager) {
        super(entityManager, Inventory.class);
    }
}

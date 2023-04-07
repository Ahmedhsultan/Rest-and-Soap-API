package com.example.demo.repository.repos;

import com.example.demo.repository.entities.Inventory;
import com.example.demo.repository.entities.Language;
import jakarta.persistence.EntityManager;

public class LanguageRepo extends BaseRepo<Language, Integer, String>{

    public LanguageRepo() {
        super(Language.class);
    }
}

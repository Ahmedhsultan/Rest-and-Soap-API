package com.example.demo.repository.repos;

import com.example.demo.repository.entities.Language;

public class LanguageRepo extends BaseRepo<Language, Integer>{

    public LanguageRepo() {
        super(Language.class);
    }
}

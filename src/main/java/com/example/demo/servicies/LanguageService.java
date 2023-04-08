package com.example.demo.servicies;

import com.example.demo.repository.entities.Language;
import com.example.demo.repository.repos.LanguageRepo;
import com.example.demo.webserviceies.rest.DTOs.LanguageDTO;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

public class LanguageService {
    private LanguageRepo languageRepo;
    private ModelMapper modelMapper;
    public LanguageService(){
        this.languageRepo = new LanguageRepo();
        this.modelMapper = new ModelMapper();
    }

    public Language create(LanguageDTO languageDTO) throws PersistenceException {
        //Create Language
        Language language = modelMapper.map(languageDTO, Language.class);
        language.setLastUpdate(Instant.now());

        //Save this language
        try {
            languageRepo.save(language);
        }catch (PersistenceException persistenceException){
            throw new PersistenceException("Can't save this language!!");
        }

        return language;
    }
}
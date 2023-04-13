package com.example.demo.servicies;

import com.example.demo.repository.entities.Language;
import com.example.demo.repository.repos.LanguageRepo;
import com.example.demo.webserviceies.rest.DTOs.requests.LanguageDTOReq;
import com.example.demo.webserviceies.rest.DTOs.resources.LanguageDTOResp;
import com.example.demo.webserviceies.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

public class LanguageService extends BaseService<Language, LanguageDTOResp, LanguageRepo>{
    private LanguageRepo languageRepo;
    private ModelMapper modelMapper;
    public LanguageService(){
        super(new LanguageRepo(), LanguageDTOResp.class);
        this.languageRepo = new LanguageRepo();
        this.modelMapper = new ModelMapper();
    }

    public Language create(LanguageDTOReq languageDTOReq) throws PersistenceException {
        //Create Language
        Language language = modelMapper.map(languageDTOReq, Language.class);
        language.setLastUpdate(Instant.now());

        //Save this language
        try {
            languageRepo.save(language);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this language!!");
        }

        return language;
    }
}
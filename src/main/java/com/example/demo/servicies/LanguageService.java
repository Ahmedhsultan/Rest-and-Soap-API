package com.example.demo.servicies;

import com.example.demo.repository.entities.Language;
import com.example.demo.repository.repos.LanguageRepo;
import com.example.demo.repository.UnitOfWork;
import com.example.demo.webservices.rest.DTOs.requests.LanguageDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.LanguageDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

public class LanguageService extends BaseService<Language, LanguageDTOResp, LanguageRepo, LanguageDTOReq>{
    private ModelMapper modelMapper;
    public LanguageService(){
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Language post(LanguageDTOReq languageDTOReq) throws PersistenceException {
        //Create Language
        Language language = modelMapper.map(languageDTOReq, Language.class);
        language.setLastUpdate(Instant.now());

        //Save this language
        try {
            UnitOfWork.getInstance().getLanguageRepo().save(language);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this language!!");
        }

        return language;
    }
}
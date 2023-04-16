package com.example.demo.servicies;

import com.example.demo.repository.entities.Film;
import com.example.demo.repository.entities.Language;
import com.example.demo.repository.repos.FilmRepo;
import com.example.demo.repository.repos.LanguageRepo;
import com.example.demo.webservices.rest.DTOs.requests.FilmDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.FilmDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

public class FilmService extends BaseService<Film, FilmDTOResp, FilmRepo, FilmDTOReq>{
    private LanguageRepo languageRepo;
    private FilmRepo filmRepo;
    private ModelMapper modelMapper;
    public FilmService(){
        this.filmRepo = new FilmRepo();
        this.languageRepo = new LanguageRepo();
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Film post(FilmDTOReq filmDTOReq) throws PersistenceException {
        //Fetch language from db
        Language language = languageRepo.find("name", filmDTOReq.getLanguage()).get(0);
        Language OriginalLanguage = languageRepo.find("name", filmDTOReq.getOriginalLanguage()).get(0);

        Film film = modelMapper.map(filmDTOReq, Film.class);
        film.setLanguage(language);
        film.setOriginalLanguage(OriginalLanguage);
        film.setLastUpdate(Instant.now());

        //Save this film
        try {
            filmRepo.save(film);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this film!!");
        }

        return film;
    }
}
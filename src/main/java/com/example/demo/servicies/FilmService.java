package com.example.demo.servicies;

import com.example.demo.repository.entities.Film;
import com.example.demo.repository.entities.Language;
import com.example.demo.repository.repos.FilmRepo;
import com.example.demo.repository.UnitOfWork;
import com.example.demo.webservices.rest.DTOs.requests.FilmDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.FilmDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

public class FilmService extends BaseService<Film, FilmDTOResp, FilmRepo, FilmDTOReq>{
    private ModelMapper modelMapper;
    public FilmService(){
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Film post(FilmDTOReq filmDTOReq) throws PersistenceException {
        //Fetch language from db
        Language language = UnitOfWork.getInstance().getLanguageRepo().find(filmDTOReq.getLanguageId());
        Language OriginalLanguage = UnitOfWork.getInstance().getLanguageRepo().find(filmDTOReq.getOriginalLanguageId());

        Film film = modelMapper.map(filmDTOReq, Film.class);
        film.setLanguage(language);
        film.setOriginalLanguage(OriginalLanguage);
        film.setId(null);

        //Save this film
        try {
            UnitOfWork.getInstance().getFilmRepo().save(film);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this film!!");
        }

        return film;
    }
}
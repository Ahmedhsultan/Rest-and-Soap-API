package com.example.demo.servicies;

import com.example.demo.repository.entities.Film;
import com.example.demo.repository.entities.Language;
import com.example.demo.repository.repos.FilmRepo;
import com.example.demo.repository.repos.LanguageRepo;
import com.example.demo.webserviceies.rest.DTOs.FilmDTO;
import com.example.demo.webserviceies.rest.DTOs.LanguageDTO;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;

import java.time.Instant;

public class FilmService {
    private LanguageRepo languageRepo;
    private FilmRepo filmRepo;
    private ModelMapper modelMapper;
    public FilmService(){
        this.filmRepo = new FilmRepo();
        this.languageRepo = new LanguageRepo();
        this.modelMapper = new ModelMapper();
    }

    public Film create(FilmDTO filmDTO) throws PersistenceException {
        //Fetch language from db
        Language language = languageRepo.getByName("name", filmDTO.getLanguage());
        Language OriginalLanguage = languageRepo.getByName("name", filmDTO.getOriginalLanguage());

        Film film = modelMapper.map(filmDTO, Film.class);
        film.setLanguage(language);
        film.setOriginalLanguage(OriginalLanguage);
        film.setLastUpdate(Instant.now());

        //Save this film
        try {
            filmRepo.save(film);
        }catch (PersistenceException persistenceException){
            throw new PersistenceException("Can't save this film!!");
        }

        return film;
    }
}
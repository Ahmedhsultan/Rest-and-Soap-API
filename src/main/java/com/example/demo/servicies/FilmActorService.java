package com.example.demo.servicies;

import com.example.demo.repository.entities.*;
import com.example.demo.repository.repos.ActorRepo;
import com.example.demo.repository.repos.FilmActorRepo;
import com.example.demo.repository.repos.FilmRepo;
import com.example.demo.repository.repos.LanguageRepo;
import com.example.demo.webserviceies.rest.DTOs.FilmActorDTO;
import com.example.demo.webserviceies.rest.DTOs.FilmDTO;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;

import java.time.Instant;

public class FilmActorService {
    private ActorRepo actorRepo;
    private FilmRepo filmRepo;
    private FilmActorRepo filmActorRepo;
    private ModelMapper modelMapper;
    public FilmActorService(){
        this.filmActorRepo = new FilmActorRepo();
        this.filmRepo = new FilmRepo();
        this.actorRepo = new ActorRepo();
        this.modelMapper = new ModelMapper();
    }

    public FilmActor create(FilmActorDTO filmActorDTO) throws PersistenceException {
        //Fetch language from db
        Film film = filmRepo.getByName("title", filmActorDTO.getTitle());
        Actor actor = actorRepo.getByName("firstName", filmActorDTO.getFirstName());

        FilmActorId filmActorId = new FilmActorId();
        filmActorId.setActorId(actor.getId());
        filmActorId.setFilmId(film.getId());

        FilmActor filmActor = new FilmActor();
        filmActor.setId(filmActorId);
        filmActor.setActor(actor);
        filmActor.setFilm(film);
        filmActor.setLastUpdate(Instant.now());

        //Save this filmActor
        try {
            filmActorRepo.update(filmActor);
        }catch (PersistenceException persistenceException){
            throw new PersistenceException("Can't save this filmActor!!");
        }

        return filmActor;
    }
}
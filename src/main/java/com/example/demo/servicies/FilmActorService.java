package com.example.demo.servicies;

import com.example.demo.repository.entities.*;
import com.example.demo.repository.repos.ActorRepo;
import com.example.demo.repository.repos.FilmActorRepo;
import com.example.demo.repository.repos.FilmRepo;
import com.example.demo.webservices.rest.DTOs.requests.FilmActorDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.FilmActorDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.FileNotFoundException;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class FilmActorService extends BaseService<FilmActor, FilmActorDTOResp, FilmActorRepo>{
    private ActorRepo actorRepo;
    private FilmRepo filmRepo;
    private FilmActorRepo filmActorRepo;
    private ModelMapper modelMapper;
    public FilmActorService(){
        super(new FilmActorRepo());
        this.filmActorRepo = new FilmActorRepo();
        this.filmRepo = new FilmRepo();
        this.actorRepo = new ActorRepo();
        this.modelMapper = new ModelMapper();
    }

    public FilmActor create(FilmActorDTOReq filmActorDTOReq) throws PersistenceException {
        //Fetch language from db
        Film film = filmRepo.find("title", filmActorDTOReq.getTitle()).get(0);
        Actor actor = actorRepo.find("firstName", filmActorDTOReq.getFirstName()).get(0);

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
            throw new OperationFaildException("Can't save this filmActor!!");
        }

        return filmActor;
    }
    public List<FilmActorDTOResp> getByFilm(int filmId) throws FileNotFoundException {
        try {
            Film film = filmRepo.find(filmId);
            List<FilmActor> filmActors = filmActorRepo.getByFilm(film);
            List<FilmActorDTOResp> dtoResp = filmActors.stream().map(x -> modelMapper.map(x, FilmActorDTOResp.class))
                    .collect(Collectors.toList());

            return dtoResp;
        }catch (PersistenceException persistenceException){
            throw new FileNotFoundException("Can't find this object!!");
        }
    }
    public List<FilmActorDTOResp> getByActor(int actorId) throws FileNotFoundException {
        try {
            Actor actor = actorRepo.find(actorId);
            List<FilmActor> filmActors = filmActorRepo.getByActor(actor);
            List<FilmActorDTOResp> dtoResp = filmActors.stream().map(x -> modelMapper.map(x, FilmActorDTOResp.class))
                    .collect(Collectors.toList());

            return dtoResp;
        }catch (PersistenceException persistenceException){
            throw new FileNotFoundException("Can't find this object!!");
        }
    }
    public void delete(int actorId, int filmId){

    }
}
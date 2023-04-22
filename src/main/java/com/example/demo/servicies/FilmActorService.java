package com.example.demo.servicies;

import com.example.demo.repository.UnitOfWork;
import com.example.demo.repository.entities.Actor;
import com.example.demo.repository.entities.Film;
import com.example.demo.repository.entities.FilmActor;
import com.example.demo.repository.entities.FilmActorId;
import com.example.demo.repository.repos.FilmActorRepo;
import com.example.demo.util.Mapper;
import com.example.demo.webservices.rest.DTOs.requests.FilmActorDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.FilmActorDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.FileNotFoundException;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;

import java.util.List;

public class FilmActorService extends BaseService<FilmActor, FilmActorDTOResp, FilmActorRepo, FilmActorDTOReq> {
    @Override
    public FilmActor post(FilmActorDTOReq filmActorDTOReq) throws PersistenceException {
        //Fetch language from db
        Film film = UnitOfWork.getInstance().getFilmRepo().find(filmActorDTOReq.getFilmId());
        Actor actor = UnitOfWork.getInstance().getActorRepo().find(filmActorDTOReq.getActorId());

        FilmActorId filmActorId = new FilmActorId();
        filmActorId.setActorId(actor.getId());
        filmActorId.setFilmId(film.getId());

        FilmActor filmActor = new FilmActor();
        filmActor.setId(filmActorId);
        filmActor.setActor(actor);
        filmActor.setFilm(film);

        //Save this filmActor
        try {
            UnitOfWork.getInstance().getFilmActorRepo().update(filmActor);
        } catch (PersistenceException persistenceException) {
            throw new OperationFaildException("Can't save this filmActor!!");
        }

        return filmActor;
    }

    public List<FilmActorDTOResp> getByFilm(int filmId) throws FileNotFoundException {
        try {
            Film film = UnitOfWork.getInstance().getFilmRepo().find(filmId);
            List<FilmActor> filmActors = UnitOfWork.getInstance().getFilmActorRepo().<Film>find("film", film);
            List<FilmActorDTOResp> dtoResp = filmActors.stream().map(x -> Mapper.MAPPER.getModelMapper().map(x, FilmActorDTOResp.class))
                    .toList();

            return dtoResp;
        } catch (PersistenceException persistenceException) {
            throw new FileNotFoundException("Can't find this object!!");
        }
    }

    public List<FilmActorDTOResp> getByActor(int actorId) throws FileNotFoundException {
        try {
            Actor actor = UnitOfWork.getInstance().getActorRepo().find(actorId);
            List<FilmActor> filmActors = UnitOfWork.getInstance().getFilmActorRepo().<Actor>find("actor", actor);
            List<FilmActorDTOResp> dtoResp = filmActors.stream().map(x -> Mapper.MAPPER.getModelMapper().map(x, FilmActorDTOResp.class))
                    .toList();

            return dtoResp;
        } catch (PersistenceException persistenceException) {
            throw new FileNotFoundException("Can't find this object!!");
        }
    }
}
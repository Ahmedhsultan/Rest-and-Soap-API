package com.example.demo.webservices.soap.controllers;

import com.example.demo.repository.entities.Film;
import com.example.demo.servicies.FilmActorService;
import com.example.demo.servicies.FilmService;
import com.example.demo.webservices.rest.DTOs.requests.FilmDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.FilmActorDTOResp;
import com.example.demo.webservices.rest.DTOs.resources.FilmDTOResp;
import com.example.demo.webservices.soap.exception.SoapException;
import jakarta.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public class FilmActorWS {
    private FilmService FilmService;
    public FilmActorWS(){
        this.FilmService = new FilmService();
    }
    public Film post(FilmDTOReq filmDTOReq) throws SoapException {
        Film film = FilmService.post(filmDTOReq);

        return film;
    }
    public List<FilmActorDTOResp> get(String columnName, String value, Integer pageNumber, Integer count) {
        FilmActorService filmActorService = new FilmActorService();

        List<FilmActorDTOResp> actorDTOResp = new ArrayList<>();
        if (columnName.toLowerCase().equals("filmid"))
            actorDTOResp = filmActorService.getByFilm(Integer.parseInt(value));
        else if (columnName.toLowerCase().equals("actorid")) {
            actorDTOResp = filmActorService.getByActor(Integer.parseInt(value));
        }

        return actorDTOResp;
    }
    public List<FilmDTOResp> getAll() {
        var filmDTOResps = FilmService.getAll();

        return filmDTOResps;
    }
    public long getCount() {
        var count = FilmService.getCount();

        return count;
    }
    public boolean delete(String columnName, String value) {
        FilmService.delete(columnName, value);

        return true;
    }
    public boolean deleteByDTO(FilmDTOResp dtoResp) {
        FilmService.delete(dtoResp);

        return true;
    }
    public boolean put(FilmDTOResp dtoResp) {
        FilmService.put(dtoResp);

        return true;
    }
}

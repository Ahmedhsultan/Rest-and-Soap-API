package com.example.demo.webservices.soap.controllers;

import com.example.demo.repository.entities.Film;
import com.example.demo.servicies.FilmService;
import com.example.demo.webservices.rest.DTOs.requests.FilmDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.FilmDTOResp;
import com.example.demo.webservices.soap.exception.SoapException;
import jakarta.jws.WebService;
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
    public List<FilmDTOResp> get(String columnName, String value, Integer pageNumber, Integer count) {
        var filmDTOResps = FilmService.get(columnName, value, pageNumber, count);

        return filmDTOResps;
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

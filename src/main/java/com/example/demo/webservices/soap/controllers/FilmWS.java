package com.example.demo.webservices.soap.controllers;

import com.example.demo.repository.entities.Film;
import com.example.demo.servicies.FilmService;
import com.example.demo.util.records.QueryPage;
import com.example.demo.webservices.rest.DTOs.requests.FilmDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.FilmDTOResp;
import com.example.demo.webservices.soap.exception.SoapException;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public class FilmWS {
    private FilmService filmService;
    public FilmWS(){
        this.filmService = new FilmService();
    }
    public Film post(FilmDTOReq filmDTOReq) throws SoapException {
        Film film = filmService.post(filmDTOReq);

        return film;
    }
    public List<FilmDTOResp> get(String columnName, String value, Integer pageNumber, Integer count) {
        QueryPage queryPage = new QueryPage(columnName, value, pageNumber, count);
        var filmDTOResps = filmService.get(queryPage);

        return filmDTOResps;
    }
    public List<FilmDTOResp> getAll() {
        var filmDTOResps = filmService.getAll();

        return filmDTOResps;
    }
    public long getCount() {
        var count = filmService.getCount();

        return count;
    }
    public boolean delete(String columnName, String value) {
        filmService.delete(columnName, value);

        return true;
    }
    public boolean deleteByDTO(FilmDTOResp dtoResp) {
        filmService.delete(dtoResp);

        return true;
    }
    public boolean put(FilmDTOResp dtoResp) {
        filmService.put(dtoResp);

        return true;
    }
}

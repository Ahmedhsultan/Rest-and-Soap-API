package com.example.demo.webservices.soap.controllers;

import com.example.demo.repository.entities.FilmText;
import com.example.demo.servicies.FilmTextService;
import com.example.demo.util.records.QueryPage;
import com.example.demo.webservices.rest.DTOs.requests.FilmTextDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.FilmTextDTOResp;
import com.example.demo.webservices.soap.exception.SoapException;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class FilmTextWS {
    private FilmTextService filmTextService;

    public FilmTextWS() {
        this.filmTextService = new FilmTextService();
    }

    public FilmText post(FilmTextDTOReq filmTextDTOReq) throws SoapException {
        FilmText filmText = filmTextService.post(filmTextDTOReq);

        return filmText;
    }

    public List<FilmTextDTOResp> get(String columnName, String value, Integer pageNumber, Integer count) {
        QueryPage queryPage = new QueryPage(columnName, value, pageNumber, count);
        var filmTextDTOResps = filmTextService.get(queryPage);

        return filmTextDTOResps;
    }

    public List<FilmTextDTOResp> getAll() {
        var filmTextDTOResps = filmTextService.getAll();

        return filmTextDTOResps;
    }

    public long getCount() {
        var count = filmTextService.getCount();

        return count;
    }

    public boolean delete(String columnName, String value) {
        filmTextService.delete(columnName, value);

        return true;
    }

    public boolean deleteByDTO(FilmTextDTOResp dtoResp) {
        filmTextService.delete(dtoResp);

        return true;
    }

    public boolean put(FilmTextDTOResp dtoResp) {
        filmTextService.put(dtoResp);

        return true;
    }
}

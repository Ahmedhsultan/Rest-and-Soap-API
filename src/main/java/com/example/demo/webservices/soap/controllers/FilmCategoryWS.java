package com.example.demo.webservices.soap.controllers;

import com.example.demo.repository.entities.FilmCategory;
import com.example.demo.servicies.FilmCategoryService;
import com.example.demo.webservices.rest.DTOs.requests.FilmCategoryDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.FilmCategoryDTOResp;
import com.example.demo.webservices.soap.exception.SoapException;
import jakarta.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public class FilmCategoryWS {
    private FilmCategoryService filmCategoryService;
    public FilmCategoryWS(){
        this.filmCategoryService = new FilmCategoryService();
    }
    public FilmCategory post(FilmCategoryDTOReq filmCategoryDTOReq) throws SoapException {
        FilmCategory filmCategory = filmCategoryService.post(filmCategoryDTOReq);

        return filmCategory;
    }
    public List<FilmCategoryDTOResp> get(String columnName, String value, Integer pageNumber, Integer count) {
        FilmCategoryService filmCategoryService = new FilmCategoryService();

        List<FilmCategoryDTOResp> filmCategoryDTOResps = new ArrayList<>();
        if (columnName.toLowerCase().equals("filmid"))
            filmCategoryDTOResps = filmCategoryService.getByFilm(Integer.parseInt(value));
        else if (columnName.toLowerCase().equals("categoryid")) {
            filmCategoryDTOResps = filmCategoryService.getByCategory(Integer.parseInt(value));
        }

        return filmCategoryDTOResps;
    }
    public List<FilmCategoryDTOResp> getAll() {
        var filmCategoryDTOResps = filmCategoryService.getAll();

        return filmCategoryDTOResps;
    }
    public long getCount() {
        var count = filmCategoryService.getCount();

        return count;
    }
    public boolean delete(String columnName, String value) {
        filmCategoryService.delete(columnName, value);

        return true;
    }
    public boolean deleteByDTO(FilmCategoryDTOResp dtoResp) {
        filmCategoryService.delete(dtoResp);

        return true;
    }
    public boolean put(FilmCategoryDTOResp dtoResp) {
        filmCategoryService.put(dtoResp);

        return true;
    }
}

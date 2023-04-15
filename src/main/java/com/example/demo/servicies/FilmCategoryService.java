package com.example.demo.servicies;

import com.example.demo.repository.entities.*;
import com.example.demo.repository.repos.*;
import com.example.demo.webservices.rest.DTOs.requests.FilmCategoryDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.FilmActorDTOResp;
import com.example.demo.webservices.rest.DTOs.resources.FilmCategoryDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.FileNotFoundException;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class FilmCategoryService extends BaseService<FilmCategory, FilmCategoryDTOResp, FilmCategoryRepo>{
    private CategoryRepo categoryRepo;
    private FilmRepo filmRepo;
    private FilmCategoryRepo filmCategoryRepo;
    private ModelMapper modelMapper;
    public FilmCategoryService(){
        super(new FilmCategoryRepo());
        this.filmCategoryRepo = new FilmCategoryRepo();
        this.filmRepo = new FilmRepo();
        this.categoryRepo = new CategoryRepo();
        this.modelMapper = new ModelMapper();
    }

    public FilmCategory create(FilmCategoryDTOReq filmCategoryDTOReq) throws PersistenceException {
        //Fetch language from db
        Film film = filmRepo.find("title", filmCategoryDTOReq.getFilmTitle()).get(0);
        Category category = categoryRepo.find("name", filmCategoryDTOReq.getCategoryName()).get(0);

        //Create filmCategory
        FilmCategoryId filmCategoryId = new FilmCategoryId();
        filmCategoryId.setCategoryId(category.getId());
        filmCategoryId.setFilmId(film.getId());

        FilmCategory filmCategory = new FilmCategory();
        filmCategory.setId(filmCategoryId);
        filmCategory.setCategory(category);
        filmCategory.setFilm(film);
        filmCategory.setLastUpdate(Instant.now());

        //Save this filmCategory
        try {
            filmCategoryRepo.update(filmCategory);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this filmCategory!!");
        }

        return filmCategory;
    }

    public List<FilmCategoryDTOResp> getByFilm(int filmId) throws FileNotFoundException {
        try {
            Film film = filmRepo.find(filmId);
            List<FilmCategory> filmActors = filmCategoryRepo.<Film>find("film",film);
            List<FilmCategoryDTOResp> dtoResp = filmActors.stream().map(x -> modelMapper.map(x, FilmCategoryDTOResp.class))
                    .collect(Collectors.toList());

            return dtoResp;
        }catch (PersistenceException persistenceException){
            throw new FileNotFoundException("Can't find this object!!");
        }
    }
    public List<FilmCategoryDTOResp> getByCategory(int categoryId) throws FileNotFoundException {
        try {
            Category category = categoryRepo.find(categoryId);
            List<FilmCategory> filmActors = filmCategoryRepo.<Category>find("category", category);
            List<FilmCategoryDTOResp> dtoResp = filmActors.stream().map(x -> modelMapper.map(x, FilmCategoryDTOResp.class))
                    .collect(Collectors.toList());

            return dtoResp;
        }catch (PersistenceException persistenceException){
            throw new FileNotFoundException("Can't find this object!!");
        }
    }
}
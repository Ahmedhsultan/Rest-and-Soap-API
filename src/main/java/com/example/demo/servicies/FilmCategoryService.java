package com.example.demo.servicies;

import com.example.demo.repository.entities.*;
import com.example.demo.repository.repos.*;
import com.example.demo.webservices.rest.DTOs.requests.FilmCategoryDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.FilmCategoryDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

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
        Film film = filmRepo.getByName("title", filmCategoryDTOReq.getFilmTitle()).get(0);
        Category category = categoryRepo.getByName("name", filmCategoryDTOReq.getCategoryName()).get(0);

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
}
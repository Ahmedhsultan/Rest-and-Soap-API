package com.example.demo.servicies;

import com.example.demo.repository.UnitOfWork;
import com.example.demo.repository.entities.*;
import com.example.demo.repository.repos.*;
import com.example.demo.webservices.rest.DTOs.requests.FilmCategoryDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.FilmCategoryDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.FileNotFoundException;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class FilmCategoryService extends BaseService<FilmCategory, FilmCategoryDTOResp, FilmCategoryRepo, FilmCategoryDTOReq>{
    private ModelMapper modelMapper;
    public FilmCategoryService(){
        this.modelMapper = new ModelMapper();
    }

    @Override
    public FilmCategory post(FilmCategoryDTOReq filmCategoryDTOReq) throws PersistenceException {
        //Fetch language from db
        Film film = UnitOfWork.getInstance().getFilmRepo().find(filmCategoryDTOReq.getFilmId());
        Category category = UnitOfWork.getInstance().getCategoryRepo().find(filmCategoryDTOReq.getCategoryId());

        //Create filmCategory
        FilmCategoryId filmCategoryId = new FilmCategoryId();
        filmCategoryId.setCategoryId(category.getId());
        filmCategoryId.setFilmId(film.getId());

        FilmCategory filmCategory = new FilmCategory();
        filmCategory.setId(filmCategoryId);
        filmCategory.setCategory(category);
        filmCategory.setFilm(film);

        //Save this filmCategory
        try {
            UnitOfWork.getInstance().getFilmCategoryRepo().update(filmCategory);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this filmCategory!!");
        }

        return filmCategory;
    }

    public List<FilmCategoryDTOResp> getByFilm(int filmId) throws FileNotFoundException {
        try {
            Film film = UnitOfWork.getInstance().getFilmRepo().find(filmId);
            List<FilmCategory> filmActors = UnitOfWork.getInstance().getFilmCategoryRepo().<Film>find("film",film);
            List<FilmCategoryDTOResp> dtoResp = filmActors.stream().map(x -> modelMapper.map(x, FilmCategoryDTOResp.class))
                    .collect(Collectors.toList());

            return dtoResp;
        }catch (PersistenceException persistenceException){
            throw new FileNotFoundException("Can't find this object!!");
        }
    }
    public List<FilmCategoryDTOResp> getByCategory(int categoryId) throws FileNotFoundException {
        try {
            Category category = UnitOfWork.getInstance().getCategoryRepo().find(categoryId);
            List<FilmCategory> filmActors = UnitOfWork.getInstance().getFilmCategoryRepo().<Category>find("category", category);
            List<FilmCategoryDTOResp> dtoResp = filmActors.stream().map(x -> modelMapper.map(x, FilmCategoryDTOResp.class))
                    .collect(Collectors.toList());

            return dtoResp;
        }catch (PersistenceException persistenceException){
            throw new FileNotFoundException("Can't find this object!!");
        }
    }
}
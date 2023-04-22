package com.example.demo.servicies;

import com.example.demo.repository.UnitOfWork;
import com.example.demo.repository.entities.Category;
import com.example.demo.repository.entities.Film;
import com.example.demo.repository.entities.FilmCategory;
import com.example.demo.repository.entities.FilmCategoryId;
import com.example.demo.repository.repos.FilmCategoryRepo;
import com.example.demo.util.Mapper;
import com.example.demo.webservices.rest.DTOs.requests.FilmCategoryDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.FilmCategoryDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.FileNotFoundException;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;

import java.util.List;

public class FilmCategoryService extends BaseService<FilmCategory, FilmCategoryDTOResp, FilmCategoryRepo, FilmCategoryDTOReq> {
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
        } catch (PersistenceException persistenceException) {
            throw new OperationFaildException("Can't save this filmCategory!!");
        }

        return filmCategory;
    }

    public List<FilmCategoryDTOResp> getByFilm(int filmId) throws FileNotFoundException {
        try {
            Film film = UnitOfWork.getInstance().getFilmRepo().find(filmId);
            List<FilmCategory> filmActors = UnitOfWork.getInstance().getFilmCategoryRepo().<Film>find("film", film);
            List<FilmCategoryDTOResp> dtoResp = filmActors.stream().map(x -> Mapper.MAPPER.getModelMapper().map(x, FilmCategoryDTOResp.class))
                    .toList();

            return dtoResp;
        } catch (PersistenceException persistenceException) {
            throw new FileNotFoundException("Can't find this object!!");
        }
    }

    public List<FilmCategoryDTOResp> getByCategory(int categoryId) throws FileNotFoundException {
        try {
            Category category = UnitOfWork.getInstance().getCategoryRepo().find(categoryId);
            List<FilmCategory> filmActors = UnitOfWork.getInstance().getFilmCategoryRepo().<Category>find("category", category);
            List<FilmCategoryDTOResp> dtoResp = filmActors.stream().map(x -> Mapper.MAPPER.getModelMapper().map(x, FilmCategoryDTOResp.class))
                    .toList();

            return dtoResp;
        } catch (PersistenceException persistenceException) {
            throw new FileNotFoundException("Can't find this object!!");
        }
    }
}
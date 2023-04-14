package com.example.demo.repository.repos;

import com.example.demo.repository.entities.Actor;
import com.example.demo.repository.entities.Film;
import com.example.demo.repository.entities.FilmActor;
import com.example.demo.repository.entities.FilmActorId;
import com.example.demo.repository.manager.Manager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class FilmActorRepo extends BaseRepo<FilmActor, FilmActorId>{

    public FilmActorRepo() {
        super(FilmActor.class);
    }

    public List<FilmActor> getByFilm(Film film){
        List<FilmActor> entity = Manager.doTransaction((entityManager)->{
            //Definitions
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<FilmActor> criteriaQuery = criteriaBuilder.createQuery(entityClass);
            Root<FilmActor> root = criteriaQuery.from(entityClass);

            //Queries
            criteriaQuery.where(criteriaBuilder.equal(root.get("film"), film)).select(root);
            List<FilmActor> result = entityManager.createQuery(criteriaQuery).getResultList();

            return result;
        });

        return  entity;
    }
    public List<FilmActor> getByActor(Actor actor){
        List<FilmActor> entity = Manager.doTransaction((entityManager)->{
            //Definitions
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<FilmActor> criteriaQuery = criteriaBuilder.createQuery(entityClass);
            Root<FilmActor> root = criteriaQuery.from(entityClass);

            //Queries
            criteriaQuery.where(criteriaBuilder.equal(root.get("actor"), actor)).select(root);
            List<FilmActor> result = entityManager.createQuery(criteriaQuery).getResultList();

            return result;
        });

        return  entity;
    }
}

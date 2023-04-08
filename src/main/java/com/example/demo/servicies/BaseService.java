package com.example.demo.servicies;

import com.example.demo.repository.repos.BaseRepo;
import jakarta.persistence.PersistenceException;

public class BaseService <Entity, Repo extends BaseRepo<Entity,Integer,String>>{
    Repo repo;
    public BaseService(Repo repo){
        this.repo = repo;
    }

    public Entity get (String columnName, String value){
        try {
            Entity entity = repo.getByName(columnName, value);
            return entity;
        }catch (PersistenceException persistenceException){
            return null;
        }
    }
    public Boolean delete (String columnName, String value){
        try {
            Boolean status = repo.deleteByName(columnName, value);
            return status;
        }catch (PersistenceException persistenceException){
            throw new PersistenceException("Can't delete this entity!!");
        }
    }
}

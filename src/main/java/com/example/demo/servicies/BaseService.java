package com.example.demo.servicies;

import com.example.demo.repository.repos.BaseRepo;

public class BaseService <Entity, Repo extends BaseRepo<Entity,Integer,String>>{
    Repo repo;
    public BaseService(Repo repo){
        this.repo = repo;
    }

    public Entity get (String columnName, String value){
        Entity entity = repo.getByName(columnName, value);
        return entity;
    }
    public Boolean delete (String columnName, String value){
        Boolean status = repo.deleteByName(columnName, value);
        return status;
    }
}

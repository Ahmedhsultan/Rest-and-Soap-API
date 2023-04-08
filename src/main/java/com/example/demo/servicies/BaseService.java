package com.example.demo.servicies;

import com.example.demo.repository.repos.BaseRepo;

public class BaseService <Entity, Repo extends BaseRepo<Entity,Integer,String>>{
    Repo repo;
    public BaseService(Repo repo){
        this.repo = repo;
    }

    public Entity Get (String coulmnName, String name){
        Entity entity = repo.getByName(coulmnName, name);
        return entity;
    }
    public Boolean Delete (String coulmnName, String name){
        Boolean status = repo.deleteByName(coulmnName, name);
        return status;
    }
}

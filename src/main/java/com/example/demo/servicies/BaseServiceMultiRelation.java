package com.example.demo.servicies;


import com.example.demo.repository.repos.BaseRepo;
import com.example.demo.repository.repos.CategoryRepo;
import com.example.demo.webservices.rest.DTOs.resources.CategoryDTOResp;

public class BaseServiceMultiRelation <Entity, DTOResp, Repo extends BaseRepo <Entity, ?>> extends BaseService<Entity, DTOResp, Repo>{
    public BaseServiceMultiRelation(Repo repo){
        super(repo);
    }

}

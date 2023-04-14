package com.example.demo.servicies;

import com.example.demo.repository.repos.BaseRepo;
import com.example.demo.webservices.rest.exception.exceptions.FileNotFoundException;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class BaseService <Entity, DTOResp, Repo extends BaseRepo<Entity,?>>{
    private Repo repo;
    private Class<DTOResp> dtoClass;
    private ModelMapper modelMapper;
    public BaseService(Repo repo, Class<DTOResp> dtoClass){
        this.repo = repo;
        this.modelMapper = new ModelMapper();
        this.dtoClass = dtoClass;
    }

    public List<DTOResp> get (String columnName, String value) throws FileNotFoundException{
        try {
            List<Entity> entity = repo.getByName(columnName, value);
            List<DTOResp> dtoResp = entity.stream().map(x -> modelMapper.map(x, dtoClass))
                    .collect(Collectors.toList());

            return dtoResp;
        }catch (PersistenceException persistenceException){
            throw new FileNotFoundException("Can't find this object!!");
        }
    }
    public Boolean delete (String columnName, String value) throws OperationFaildException{
        try {
            Boolean status = repo.deleteByColumnName(columnName, value);
            return status;
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't delete this entity!!");
        }
    }
}

package com.example.demo.servicies;

import com.example.demo.repository.UnitOfWork;
import com.example.demo.repository.entities.Actor;
import com.example.demo.repository.repos.BaseRepo;
import com.example.demo.webservices.rest.exception.exceptions.FileNotFoundException;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class BaseService <Entity, DTOResp, Repo extends BaseRepo<Entity,?>, DTOReq>{
    private Repo repo;
    private Class<DTOResp> dtoClass;
    private Class<Entity> entityClass;
    private ModelMapper modelMapper;
    public BaseService(){
        this.modelMapper = new ModelMapper();

        //Get class type of generics by reflections
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        Type[] typeArguments = genericSuperclass.getActualTypeArguments();
        this.entityClass = (Class<Entity>) typeArguments[0];
        this.dtoClass = (Class<DTOResp>) typeArguments[1];
        //Create instance from service by reflection
        try {
            this.repo = ((Class<Repo>) typeArguments[2]).getDeclaredConstructor().newInstance();
        }catch (Exception e){e.printStackTrace();}
    }

    public Entity post(DTOReq dtoReq) throws PersistenceException{
        //Create object of entity
        Entity entity = modelMapper.map(dtoReq, entityClass);

        //Save this entity
        try {
            repo.save(entity);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this " + entity.getClass().getSimpleName() + " !!");
        }

        return entity;
    }

    public List<DTOResp> get (String columnName, String value, Integer pageNumber, Integer count) throws FileNotFoundException{
        try {
            List<Entity> entity = repo.find(columnName, value, pageNumber, count);
            List<DTOResp> dtoResp = entity.stream().map(x -> modelMapper.map(x, dtoClass))
                    .collect(Collectors.toList());

            return dtoResp;
        }catch (PersistenceException persistenceException){
            throw new FileNotFoundException("Can't find this object!!");
        }
    }
    public List<DTOResp> getAll () throws FileNotFoundException{
        try {
            List<Entity> entity = repo.findAll();
            List<DTOResp> dtoResp = entity.stream().map(x -> modelMapper.map(x, dtoClass))
                    .collect(Collectors.toList());

            return dtoResp;
        }catch (PersistenceException persistenceException){
            throw new FileNotFoundException("Can't find any object!!");
        }
    }
    public Long getCount () throws FileNotFoundException{
        try {
            Long rowCount = repo.count();

            return rowCount;
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't count table!!");
        }
    }
    public Boolean delete (String columnName, String value) throws OperationFaildException{
        try {
            Boolean status = repo.delete(columnName, value);
            return status;
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't delete this entity!!");
        }
    }
    public Boolean delete (DTOResp dtoResp) throws OperationFaildException{
        try {
            Entity entity = modelMapper.map(dtoResp, entityClass);
            Boolean status = repo.delete(entity);
            return status;
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't delete this entity!!");
        }
    }
    public Boolean put (DTOResp dtoResp) throws OperationFaildException{
        try {
            Entity entity = modelMapper.map(dtoResp, entityClass);
            repo.update(entity);
            return true;
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't edit this entity!!");
        }
    }
}

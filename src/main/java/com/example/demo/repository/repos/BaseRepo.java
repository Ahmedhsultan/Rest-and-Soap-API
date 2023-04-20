package com.example.demo.repository.repos;

import com.example.demo.repository.manager.Manager;
import com.example.demo.util.records.QueryPage;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseRepo <Entity, ID>{
    protected Class<Entity> entityClass;
    public BaseRepo(){
        //Get class type of generics by reflections
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        Type[] typeArguments = genericSuperclass.getActualTypeArguments();
        this.entityClass = (Class<Entity>) typeArguments[0];
    }

    public Entity find(ID id) throws OperationFaildException{
        Entity entity = Manager.doTransaction((entityManager)->{
            //Definitions
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Entity> criteriaQuery = criteriaBuilder.createQuery(entityClass);
            Root<Entity> root = criteriaQuery.from(entityClass);

            //Queries
            criteriaQuery.where(criteriaBuilder.equal(root.get("id"), id)).select(root);
            Entity result = null;
            try {
                result = entityManager.createQuery(criteriaQuery).getSingleResult();
            }catch (PersistenceException exception){
                throw new OperationFaildException(entityClass.getSimpleName() + " Id isn't exist!!");
            }

            return result;
        });

        return  entity;
    }
    public List<Entity> find(QueryPage queryPage){
        List<Entity> entity = Manager.doTransaction((entityManager)->{
            //Definitions
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Entity> criteriaQuery = criteriaBuilder.createQuery(entityClass);
            Root<Entity> root = criteriaQuery.from(entityClass);

            //Queries
            criteriaQuery.where(criteriaBuilder.equal(root.get(queryPage.columnName()), queryPage.value())).select(root);
            List<Entity> result = entityManager.createQuery(criteriaQuery)
                    .setFirstResult(queryPage.pageNumber())
                    .setMaxResults(queryPage.count())
                    .getResultList();

            return result;
        });

        return  entity;
    }
    public <Type> List<Entity> find(String columnName, Type value){
        List<Entity> entity = Manager.doTransaction((entityManager)->{
            //Definitions
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Entity> criteriaQuery = criteriaBuilder.createQuery(entityClass);
            Root<Entity> root = criteriaQuery.from(entityClass);

            //Queries
            criteriaQuery.where(criteriaBuilder.equal(root.get(columnName), value)).select(root);
            List<Entity> result = entityManager.createQuery(criteriaQuery).getResultList();

            return result;
        });

        return  entity;
    }
    public List<Entity> findAll(){
        List<Entity> entitys = Manager.doTransaction((entityManager)->{
            //Definitions
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Entity> criteriaQuery = criteriaBuilder.createQuery(entityClass);
            Root<Entity> root = criteriaQuery.from(entityClass);

            //Queries
            criteriaQuery.select(root);
            List<Entity> result = entityManager.createQuery(criteriaQuery).getResultList();

            return result;
        });

        return  entitys;
    }
    public boolean delete(Entity entity){
        Boolean status = Manager.doTransaction((entityManager)->{
            Entity entityMerged = entityManager.merge(entity);
            entityManager.remove(entityMerged);
            return true;
        });
        return  status;
    }
    public boolean delete(String columnName, String value){
        Boolean status = Manager.doTransaction((entityManager)->{
            //Definitions
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaDelete<Entity> criteriaDelete = criteriaBuilder.createCriteriaDelete(entityClass);
            Root<Entity> root = criteriaDelete.from(entityClass);

            //Queries
            criteriaDelete.where(criteriaBuilder.equal(root.get(columnName), value));
            int row = entityManager.createQuery(criteriaDelete).executeUpdate();

            if (row>0)
                return true;
            else
                return false;
        });

        return  status;
    }
    public boolean save(Entity entity){
        Boolean status = Manager.doTransaction((entityManager)->{
            entityManager.persist(entity);
            return true;
        });
        return  status;
    }
    public Entity update(Entity entity){
        Entity result = Manager.doTransaction((entityManager)->{
            Entity entityMerged = entityManager.merge(entity);
            return entityMerged;
        });
        return  result;
    }
    public Long count(){
        Long count = Manager.doTransaction((entityManager)->{
            //Definitions
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);

            //Queries
            criteriaQuery.select(criteriaBuilder.count(criteriaQuery.from(entityClass)));
            Long rowCount = entityManager.createQuery(criteriaQuery).getSingleResult();

            return rowCount;
        });

        return  count;
    }
}

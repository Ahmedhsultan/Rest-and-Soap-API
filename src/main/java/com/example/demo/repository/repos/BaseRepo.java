package com.example.demo.repository.repos;

import com.example.demo.repository.manager.Manager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class BaseRepo <Entity, ID, Name>{
    protected Class<Entity> entityClass;
    public BaseRepo(Class<Entity> entityClass){this.entityClass = entityClass;}

    public Entity getById(ID id){
        Entity entity = Manager.doTransaction((entityManager)->{
            //Definitions
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Entity> criteriaQuery = criteriaBuilder.createQuery(entityClass);
            Root<Entity> root = criteriaQuery.from(entityClass);

            //Queries
            criteriaQuery.where(criteriaBuilder.equal(root.get("id"), id)).select(root);
            Entity result = entityManager.createQuery(criteriaQuery).getSingleResult();

            return result;
        });

        return  entity;
    }
    public List<Entity> getAll(){
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
    public boolean deleteById(ID id){
        Boolean status = Manager.doTransaction((entityManager)->{
            //Definitions
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaDelete<Entity> criteriaDelete = criteriaBuilder.createCriteriaDelete(entityClass);
            Root<Entity> root = criteriaDelete.from(entityClass);

            //Queries
            criteriaDelete.where(criteriaBuilder.equal(root.get("id"), id));
            entityManager.createQuery(criteriaDelete).executeUpdate();

            return true;
        });

        return  status;
    }
    public boolean deleteByName(String coulmnName, String name){
        Boolean status = Manager.doTransaction((entityManager)->{
            //Definitions
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaDelete<Entity> criteriaDelete = criteriaBuilder.createCriteriaDelete(entityClass);
            Root<Entity> root = criteriaDelete.from(entityClass);

            //Queries
            criteriaDelete.where(criteriaBuilder.equal(root.get(coulmnName), name));
            entityManager.createQuery(criteriaDelete).executeUpdate();

            return true;
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
    public boolean update(Entity entity){
        Boolean status = Manager.doTransaction((entityManager)->{
            entityManager.merge(entity);
            return true;
        });
        return  status;
    }
    public Entity getByName(String coulmnName, String name){
        Entity entity = Manager.doTransaction((entityManager)->{
            //Definitions
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Entity> criteriaQuery = criteriaBuilder.createQuery(entityClass);
            Root<Entity> root = criteriaQuery.from(entityClass);

            //Queries
            criteriaQuery.where(criteriaBuilder.equal(root.get(coulmnName), name)).select(root);
            Entity result = entityManager.createQuery(criteriaQuery).getSingleResult();

            return result;
        });

        return  entity;
    }
}

package com.example.demo.repository.repos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class BaseRepo <Entity, ID, Name>{

    protected EntityManager entityManager;
    protected CriteriaQuery<Entity> criteriaQuery;
    protected CriteriaDelete<Entity> criteriaDelete;
    protected CriteriaBuilder criteriaBuilder;
    protected Root<Entity> root;
    protected Class<Entity> entityClass;
    public BaseRepo(EntityManager entityManager, Class<Entity> entityClass){
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
        this.criteriaQuery = criteriaBuilder.createQuery(entityClass);
        this.root = criteriaQuery.from(entityClass);
        this.entityClass = entityClass;
        this.criteriaDelete = criteriaBuilder.createCriteriaDelete(entityClass);
    }

    public Entity getById(ID id){
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"), id)).select(root);
        Entity entity = entityManager.createQuery(criteriaQuery).getSingleResult();

        return  entity;
    }
    public List<Entity> getAll(){
        criteriaQuery.select(root);
        List<Entity> entitys = entityManager.createQuery(criteriaQuery).getResultList();

        return  entitys;
    }
    public boolean deleteById(ID id){
        criteriaDelete.where(criteriaBuilder.equal(root.get("id"), id));
        //entityManager.getTransaction().begin();
        entityManager.createQuery(criteriaDelete).executeUpdate();
        //entityManager.getTransaction().commit();

        return  true;
    }
    public boolean save(Entity entity){
        entityManager.persist(entity);
        return true;
    }
    public Entity getByName(Name name){
        criteriaQuery.where(criteriaBuilder.equal(root.get(name.toString()), name)).select(root);
        Entity entity = entityManager.createQuery(criteriaQuery).getSingleResult();

        return  entity;
    }
}

package com.example.demo.repository.repos;

import com.example.demo.repository.entities.Actor;
import jakarta.persistence.EntityManager;

public class ActorRepo extends BaseRepo<Actor, Integer>{

    public ActorRepo() {super(Actor.class);}
}

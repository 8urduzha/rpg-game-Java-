package com.rpg.repository;

import com.rpg.entity.HeroClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class HeroClassRepository {

    @Autowired
    private EntityManagerFactory entityManagerFactory;


    public HeroClass save (HeroClass heroClass){

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(heroClass);
        entityManager.flush();
        entityManager.getTransaction().commit();

        return heroClass;
    }

}

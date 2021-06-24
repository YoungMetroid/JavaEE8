package com.starting.Chapter2_JPA;

import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class JPAProvider {
    @Produces

    public EntityManager create()
    {
        System.out.println("producing entity manager");
        return Persistence.createEntityManagerFactory("tttt").createEntityManager();
    }
    public void close(@Disposes EntityManager entityManager)
    {
        System.out.println("Closing entity manager");
        entityManager.close();
    }
}

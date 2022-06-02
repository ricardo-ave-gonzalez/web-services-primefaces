package com.ave.component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConectorJPA {
	private EntityManager em;

    public ConectorJPA() {
         EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPAPU");

        em = entityManagerFactory.createEntityManager();
    }
    public EntityManager getEntityManager() {
        return em;
    }
}

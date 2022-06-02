package com.ave.component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConectorJPA {
	private EntityManager em;

	public ConectorJPA() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");

		em = emf.createEntityManager();
	}

	public EntityManager getEntityManager() {
		return em;
	}
}

package com.github.neylorsousa.treinamento.laboratorio3.producers;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {
	private static EntityManagerFactory factory;

	@Produces
	@RequestScoped
	public EntityManager criaEntityManager() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("laboratorio3PU");
		}
		return factory.createEntityManager();
	}

	public void finaliza(@Disposes EntityManager manager) {
		manager.close();
	}
}

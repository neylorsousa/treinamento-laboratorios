package com.github.neylorsousa.treinamento.laboratorio3.producers;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by 02109880104 on 21/10/2016.
 */
public class EntityManagerProducerTest {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("laboratorio3PUTest");

	@Produces
	@RequestScoped
	public EntityManager criaEntityManager() {
		return factory.createEntityManager();
	}

	public void finaliza(@Disposes EntityManager manager) {
		manager.close();
	}
}
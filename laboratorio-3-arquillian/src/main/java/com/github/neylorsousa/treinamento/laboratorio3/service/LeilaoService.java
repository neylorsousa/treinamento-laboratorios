package com.github.neylorsousa.treinamento.laboratorio3.service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.github.neylorsousa.treinamento.laboratorio3.entity.Lance;
import com.github.neylorsousa.treinamento.laboratorio3.entity.Leilao;

@Named
public class LeilaoService {

	@Inject
	private EntityManager entityManager;

	@Transactional
	public void cadastrarLance(Lance lance) {
		entityManager.persist(lance);
	}

	@Transactional
	public void excluirLance(Integer idLance) {
		Lance lance = entityManager.getReference(Lance.class, idLance);
		entityManager.remove(lance);
	}

	public void cadastrarLeilao(Leilao leilao) {
		entityManager.persist(leilao);
	}

	public Lance maiorLance(Integer idLeilao) {
		TypedQuery<Lance> query = entityManager.createQuery("select a from Lance a where a.leilao.id=:id order by valor desc limit 1", Lance.class);
		query.setParameter("id", idLeilao);
		return query.getSingleResult();
	}
}

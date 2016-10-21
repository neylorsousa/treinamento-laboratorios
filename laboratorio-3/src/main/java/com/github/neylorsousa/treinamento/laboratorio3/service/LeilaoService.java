package com.github.neylorsousa.treinamento.laboratorio3.service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
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

	public Lance maiorLance(Integer idLeilao) {
		// fazer pesquisar com entitymanager

		//return leilao.getLances().stream().max((l1, l2) -> l1.getValor().compareTo(l2.getValor())).get();

		return null;
	}
}

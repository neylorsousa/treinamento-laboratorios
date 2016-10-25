package com.github.neylorsousa.treinamento.laboratorio3.service;

import com.github.neylorsousa.treinamento.laboratorio3.entity.Leilao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class LeilaoService {

	@Autowired
	private EntityManager entityManager;

	@Transactional
	public void persistir(Leilao leilao) {
		if (leilao.getId() == null) {
			entityManager.persist(leilao);
		} else {
			entityManager.merge(leilao);
		}
	}

	@Transactional
	public void deletar(Integer idLeilao) {
		//TODO desafio não permitir deletar leilões com lances vinculados, lançar error e fazer com que o teste entenda isso
		entityManager.remove(entityManager.getReference(Leilao.class, idLeilao));
	}

	public Leilao pesquisarPorId(Integer idLeilao) {
		return entityManager.find(Leilao.class, idLeilao);
	}
}
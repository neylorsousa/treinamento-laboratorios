package com.github.neylorsousa.treinamento.laboratorio5.service;

import javax.persistence.EntityManager;

import com.github.neylorsousa.treinamento.laboratorio5.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired
	private EntityManager entityManager;

	public Usuario findByUsername(String username) {
		return entityManager.createQuery("from Usuario where username=:username", Usuario.class)
			.setParameter("username",username)
			.getSingleResult();
	}
}

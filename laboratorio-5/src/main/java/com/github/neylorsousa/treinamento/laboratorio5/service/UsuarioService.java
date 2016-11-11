package com.github.neylorsousa.treinamento.laboratorio5.service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import com.github.neylorsousa.treinamento.laboratorio5.annotation.Show;
import com.github.neylorsousa.treinamento.laboratorio5.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.toList;

@Service
public class UsuarioService {

	@Autowired
	private EntityManager entityManager;

	public Usuario findByUsername(String username) {
		Usuario user = entityManager.createQuery("from Usuario where username=:username", Usuario.class)
			.setParameter("username", username)
			.getSingleResult();
		printAnnotationShow(user);
		return user;
	}

	private void printAnnotationShow(Usuario usuario) {
		Arrays.stream(usuario.getClass().getDeclaredFields())
			.filter(field -> field.isAnnotationPresent(Show.class))
			.forEach(field -> printField(field, usuario));
	}

	private void printField(Field field, Usuario usuario) {
		try {
			field.setAccessible(true);
			System.out.println("=========================================================");
			System.out.println("Atributo " + field.getName() + " : " + field.get(usuario));
			System.out.println("=========================================================");
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}

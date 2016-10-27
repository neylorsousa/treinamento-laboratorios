package com.github.neylorsousa.treinamento.laboratorio5.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Leilao implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;

	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Leilao leilao = (Leilao) o;
		return Objects.equals(id, leilao.id) &&
				Objects.equals(nome, leilao.nome);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}
}
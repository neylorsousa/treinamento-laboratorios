package com.github.neylorsousa.treinamento.laboratorio3.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Leilao {

	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 1, max = 255)
	@NotNull
	private String nome;

	@OneToMany(mappedBy = "leilao", targetEntity = Lance.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Lance> lances;

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

	public List<Lance> getLances() {
		return lances;
	}

	public void setLances(List<Lance> lances) {
		if (lances != null) lances.forEach(lance -> lance.setLeilao(this));
		this.lances = lances;
	}
}
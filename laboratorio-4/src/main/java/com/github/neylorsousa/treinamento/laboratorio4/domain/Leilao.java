package com.github.neylorsousa.treinamento.laboratorio4.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Leilao implements Serializable {

	private String nome;

	private List<Lance> lances = new ArrayList<>();

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
		this.lances = lances;
	}

	public Lance getMaiorLance() {
		return lances.stream().max((l1,l2) -> l1.getValor().compareTo(l2.getValor())).orElse(new Lance());
	}
}
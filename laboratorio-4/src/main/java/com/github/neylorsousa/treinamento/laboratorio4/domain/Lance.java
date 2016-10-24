package com.github.neylorsousa.treinamento.laboratorio4.domain;

import java.io.Serializable;
import java.util.Objects;

public class Lance implements Serializable {
	private String nomePessoa;

	private Double valor;

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Lance lance = (Lance) o;
		return Objects.equals(nomePessoa, lance.nomePessoa) &&
				Objects.equals(valor, lance.valor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nomePessoa, valor);
	}
}
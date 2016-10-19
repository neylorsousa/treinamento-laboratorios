package com.github.neylorsousa.treinamento.teste.laboratorio1;

public class Item {
	private String produto;
	private Double valor;

	public Item(String produto, Double valor) {
		this.produto = produto;
		this.valor = valor;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}

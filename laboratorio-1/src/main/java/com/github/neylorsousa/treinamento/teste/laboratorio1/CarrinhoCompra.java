package com.github.neylorsousa.treinamento.teste.laboratorio1;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompra {
	private List<Item> itens = new ArrayList<Item>();

	public void addItem(Item item) {
		itens.add(item);
	}

	public List<Item> getItens() {
		return itens;
	}
}
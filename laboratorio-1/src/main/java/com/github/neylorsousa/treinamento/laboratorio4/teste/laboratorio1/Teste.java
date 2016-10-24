package com.github.neylorsousa.treinamento.laboratorio4.teste.laboratorio1;

public class Teste {
	public static void main(String[] args) {
		CarrinhoCompra carrinho = new CarrinhoCompra();
		carrinho.addItem(new Item("Livro", 10.0));
		carrinho.addItem(new Item("Carrinho", 20.0));
		carrinho.addItem(new Item("Papel", 21.0));

		System.out.println(carrinho.getItens().size() == 3);
	}
}
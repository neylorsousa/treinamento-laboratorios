package com.github.neylorsousa.treinamento.laboratorio4.laboratorio2;

import com.github.neylorsousa.treinamento.laboratorio4.teste.laboratorio1.CarrinhoCompra;

public class Pedido {
	private CarrinhoCompra carrinhoCompra;
	private Endereco enderecoEntrega;

	public Pedido(CarrinhoCompra carrinhoCompra, String cepEnderecoEntrega) {
		this.carrinhoCompra = carrinhoCompra;
		this.enderecoEntrega = new Endereco();
		this.enderecoEntrega.carregarEnderecoPorCep(cepEnderecoEntrega);
	}

	public CarrinhoCompra getCarrinhoCompra() {
		return carrinhoCompra;
	}

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}
}

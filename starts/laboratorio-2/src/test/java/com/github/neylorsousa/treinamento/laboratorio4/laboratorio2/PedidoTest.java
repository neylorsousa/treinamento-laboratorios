package com.github.neylorsousa.treinamento.laboratorio4.laboratorio2;

import com.github.neylorsousa.treinamento.laboratorio4.teste.laboratorio1.CarrinhoCompra;
import com.github.neylorsousa.treinamento.laboratorio4.teste.laboratorio1.Item;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PedidoTest {
	@Test
	public void criarPedidoComEnderecoEntregaValido() {
		CarrinhoCompra carrinho = new CarrinhoCompra();
		carrinho.addItem(new Item("Livro", 10.0));
		Pedido pedido = new Pedido(carrinho, "72302116");
		assertThat("Verifica se o pedido localiza um endereço válido.", pedido.getEnderecoEntrega().getUf(), equalTo("DF"));
	}
}

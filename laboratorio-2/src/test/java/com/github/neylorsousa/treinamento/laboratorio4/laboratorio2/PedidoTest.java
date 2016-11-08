package com.github.neylorsousa.treinamento.laboratorio4.laboratorio2;

import com.github.neylorsousa.treinamento.laboratorio4.teste.laboratorio1.CarrinhoCompra;
import com.github.neylorsousa.treinamento.laboratorio4.teste.laboratorio1.Item;
import okhttp3.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PedidoTest {

	private OkHttpClient cepWebServiceMock;

	@Before
	//É necessário configurar o mockito-extension
	public void beforeMethod() throws IOException {
		cepWebServiceMock = mock(OkHttpClient.class);
		Response responseMock = mock(Response.class);
		Call callMock = mock(Call.class);
		when(responseMock.body()).thenReturn(mock(ResponseBody.class));
		when(responseMock.body().string()).thenReturn("{\"cep\": \"72302-116\",\"logradouro\": \"QR 106 Conjunto 15-A\",\"complemento\": \"\",\"bairro\": \"Samambaia Sul (Samambaia)\",\"localidade\": \"Brasília\",\"uf\": \"DF\",\"unidade\": \"\",\"ibge\": \"5300108\",\"gia\": \"\"}");
		when(callMock.execute()).thenReturn(responseMock);
		when(cepWebServiceMock.newCall(any(Request.class))).thenReturn(callMock);
	}

	@Test
	public void criarPedidoComEnderecoEntrega() {
		Pedido pedido = carregarPedido();
		assertThat("Verifica se o pedido localiza um endereço válido.", pedido.getEnderecoEntrega().getUf(), equalTo("DF"));
	}

	@Test
	//TODO criar o mock para a conexão com a menor alteração possível
	public void adicionarUsuarioAoPedido() {
		Pedido pedido = carregarPedido();
		pedido.carregarUsuarioPorCpf("60828292639");
		assertThat("Verifica se o pedido localiza um endereço válido.", pedido.getUsuario().getLogin(), equalTo("lero@gmail.com"));
	}

	private Pedido carregarPedido() {
		CarrinhoCompra carrinho = new CarrinhoCompra();
		carrinho.addItem(new Item("Livro", 10.0));
		return new Pedido(carrinho, "72302116", cepWebServiceMock);
	}

}

package com.github.neylorsousa.treinamento.laboratorio4.laboratorio2;

import com.github.neylorsousa.treinamento.laboratorio4.teste.laboratorio1.CarrinhoCompra;
import com.github.neylorsousa.treinamento.laboratorio4.teste.laboratorio1.Item;
import org.junit.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CarrinhoCompraTest {

	private static CarrinhoCompra carrinho;

	@BeforeClass
	public static void antesInstanciarClasse() {
		carrinho = new CarrinhoCompra();
	}

	@Before
	public void antesCadaMetodo() {
		carrinho.addItem(new Item("Livro", 10.0));
		carrinho.addItem(new Item("Carrinho", 20.0));
		carrinho.addItem(new Item("Papel", 21.0));
	}

	@Test
	public void carrinhoCompraDeveArmazenarOsItens() {
		String razao = "Carrinho de Compra deve armazenar os intes informados";
		assertThat(razao, carrinho.getItens().size(), equalTo(3));
	}

	@After
	public void aposCadaMetodo() {
		carrinho.getItens().clear();
	}

	@AfterClass
	public static void aposDestruirClasse() {
		carrinho = null;
	}
}

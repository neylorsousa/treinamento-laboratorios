package com.github.neylorsousa.treinamento.laboratorio3.service;

import com.github.neylorsousa.treinamento.laboratorio3.entity.Leilao;
import com.github.neylorsousa.treinamento.laboratorio3.faker.LeilaoFaker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LeilaoServiceTest {

	@Autowired
	private LeilaoService leilaoService;

	@Test
	public void persistirLeilaoSemId() {
		Leilao leilao = LeilaoFaker.novo();
		leilaoService.persistir(leilao);
		assertThat("Persistencia de leilao sem ID", leilao.getId(), notNullValue());
	}

	@Test
	public void persistirLeilaoComId() {
		Leilao leilao = LeilaoFaker.existenteNoBanco(leilaoService);
		leilao.setNome("Mudando o nome");
		leilaoService.persistir(leilao);
		assertThat("Persistencia de leilao com ID, ou seja, atualizacao.", leilao, equalTo(leilaoService.pesquisarPorId(leilao.getId())));
	}

	@Test
	public void deletarLeilao() {
		Leilao leilao = LeilaoFaker.existenteNoBanco(leilaoService);
		leilaoService.deletar(leilao.getId());
		assertThat("Deleção do Leilão pelo o ID", leilaoService.pesquisarPorId(leilao.getId()), nullValue());
	}
}
package com.github.neylorsousa.treinamento.laboratorio5.controller;

import com.github.neylorsousa.treinamento.laboratorio5.entity.Leilao;
import com.github.neylorsousa.treinamento.laboratorio5.faker.LeilaoFaker;
import com.github.neylorsousa.treinamento.laboratorio5.service.LeilaoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class LeilaoControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private LeilaoService leilaoService;

	@Test
	public void salvarLeilaoDeveRetornarID() {
		Leilao leilao = restTemplate.postForObject("/leiloes", LeilaoFaker.novo(), Leilao.class);
		assertThat("Salvar um novo leilão pelo endpoint /leiloes", leilao.getId(), notNullValue());
	}

	@Test
	public void atualizarLeilao() {
		Leilao leilao = LeilaoFaker.existenteNoBanco(leilaoService);
		leilao.setNome("Atualização do Nome");
		ResponseEntity<Leilao> updateResponse = restTemplate.exchange("/leiloes", HttpMethod.PUT, new HttpEntity<>(leilao), Leilao.class);
		assertThat("Atualização de leilão", updateResponse.getStatusCode(), equalTo(HttpStatus.OK));
	}

	@Test
	public void buscarLeilaoPorId() {
		Leilao leilao = LeilaoFaker.existenteNoBanco(leilaoService);
		Leilao leilaoReponse = restTemplate.getForObject("/leiloes/{id}", Leilao.class, leilao.getId());
		assertThat("Buscar o leilão por ID", leilao, equalTo(leilaoReponse));
	}

	@Test
	public void removerLeilaoPorId() {
		Leilao leilao = LeilaoFaker.existenteNoBanco(leilaoService);
		ResponseEntity<Void> deleteResponse = restTemplate.exchange("/leiloes/{id}", HttpMethod.DELETE, HttpEntity.EMPTY, Void.class, leilao.getId());
		assertThat("Remoção do leilão", deleteResponse.getStatusCode(), equalTo(HttpStatus.OK));
	}

}

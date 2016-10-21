package com.github.neylorsousa.treinamento.laboratorio3.faker;

import com.github.javafaker.Faker;
import com.github.neylorsousa.treinamento.laboratorio3.entity.Leilao;

public class LeilaoFaker {

	private static final Faker faker = new Faker();

	public Leilao novoSemIdSemLances() {
		Leilao leilao = new Leilao();
		leilao.setNome(faker.name().name());
		return leilao;
	}

}

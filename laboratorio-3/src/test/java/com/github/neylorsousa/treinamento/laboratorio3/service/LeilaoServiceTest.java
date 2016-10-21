package com.github.neylorsousa.treinamento.laboratorio3.service;

import javax.inject.Inject;

import com.github.neylorsousa.treinamento.laboratorio3.faker.LeilaoFaker;
import com.github.neylorsousa.treinamento.laboratorio3.producers.EntityManagerProducerTest;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class LeilaoServiceTest {

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class)
			.addClass(EntityManagerProducerTest.class)
			.addClass(LeilaoService.class)
			.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
			.addAsManifestResource("test-persistence.xml", "persistence.xml");
	}

	@Inject
	private LeilaoService leilaoService;

	@Test
	public void cadastrarLance() throws Exception {

	}

	@Test
	public void excluirLance() throws Exception {

	}

	@Test
	public void cadastrarLeilaoSemLances() {
		LeilaoFaker leilaoFaker = new LeilaoFaker();
		leilaoService.cadastrarLeilao(leilaoFaker.novoSemIdSemLances());
	}

	@Test
	public void maiorLance() throws Exception {

	}

}
package com.github.neylorsousa.treinamento.laboratorio3.service;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.github.neylorsousa.treinamento.laboratorio3.entity.Lance;
import com.github.neylorsousa.treinamento.laboratorio3.entity.Leilao;
import com.github.neylorsousa.treinamento.laboratorio3.faker.LeilaoFaker;
import com.github.neylorsousa.treinamento.laboratorio3.producers.EntityManagerProducerTest;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
@Ignore
public class LeilaoServiceTest {

	@Deployment
	public static JavaArchive createDeployment() {
		JavaArchive javaArchive = ShrinkWrap.create(JavaArchive.class)
			.addClass(EntityManagerProducerTest.class)
			.addClass(Lance.class)
			.addClass(Leilao.class)
			.addClass(LeilaoService.class)
			.addAsManifestResource("test-persistence.xml", "persistence.xml")
			.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		return javaArchive;
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
	@Transactional(Transactional.TxType.REQUIRED)
	public void cadastrarLeilaoSemLances() {
		LeilaoFaker leilaoFaker = new LeilaoFaker();
		leilaoService.cadastrarLeilao(leilaoFaker.novoSemIdSemLances());
	}

	@Test
	public void maiorLance() throws Exception {

	}

}
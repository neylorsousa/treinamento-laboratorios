package com.github.neylorsousa.treinamento.laboratorio4.view;

import com.github.neylorsousa.treinamento.laboratorio4.domain.Leilao;
import com.github.neylorsousa.treinamento.laboratorio4.util.WicketTesterSingleton;
import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.util.Collections.singletonList;

public class LeilaoPageTest {

	private WicketTester tester;

	@Before
	public void beforeMethod() {
		tester = WicketTesterSingleton.newInstance();
		tester.startPage(LeilaoPage.class);
	}

	@Test
	public void naoPermitirIncluirLeilaoSemNome() {
		FormTester form = tester.newFormTester("form", false);
		form.submit();
		tester.assertErrorMessages("Campo 'nome' é obrigatório.");
	}

	@Test
	public void salvarLeilaoValido() {
		FormTester form = tester.newFormTester("form", false);
		Leilao leilao = new Leilao();
		leilao.setNome("Qualquer pessoa");
		form.setValue("nome", leilao.getNome());
		form.submit();
		//tester.assertFeedback("message", "Leilão salvo com sucesso!");
		tester.assertListView("leiloes", singletonList(leilao));
	}

	@After
	public void afterMethod() {
		tester.destroy();
	}
}

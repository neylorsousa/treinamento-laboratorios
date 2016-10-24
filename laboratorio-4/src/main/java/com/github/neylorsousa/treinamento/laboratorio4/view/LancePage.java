package com.github.neylorsousa.treinamento.laboratorio4.view;

import com.github.neylorsousa.treinamento.laboratorio4.domain.Leilao;
import com.github.neylorsousa.treinamento.laboratorio4.view.template.TemplatePage;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

public class LancePage extends TemplatePage {
	private static final long serialVersionUID = 1L;

	private Leilao leilao;

	public LancePage(Leilao leilao, Page leilaoPage) {
		this.leilao = leilao;
		add(new Label("leilao", leilao.getNome()));
		add(new Link("voltar"){
			@Override
			public void onClick() {
				getPage().setResponsePage(leilaoPage);
			}
		});
	}

	@Override
	protected void onBeforeRender() {
		addOrReplace(new FeedbackPanel("message"));
		addOrReplace(new Label("nomeMaiorLance", leilao.getMaiorLance().getNomePessoa()));
		addOrReplace(new Label("valorMaiorLance", leilao.getMaiorLance().getValor()));
		super.onBeforeRender();
	}
}
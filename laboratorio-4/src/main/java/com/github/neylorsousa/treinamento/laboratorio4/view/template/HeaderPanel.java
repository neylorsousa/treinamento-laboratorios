package com.github.neylorsousa.treinamento.laboratorio4.view.template;

import com.github.neylorsousa.treinamento.laboratorio4.view.LanceViewPage;
import com.github.neylorsousa.treinamento.laboratorio4.view.LeilaoPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.markup.html.panel.Panel;

public class HeaderPanel extends Panel {

	public HeaderPanel(String id) {
		super(id);
		add(new Link("leilaoMenu"){
			@Override
			public void onClick() {
				setResponsePage(new LeilaoPage());
			}
		});
		add(new StatelessLink("lancesMenu") {
			@Override
			public void onClick() {
				setResponsePage(LanceViewPage.class);
			}
		});
	}
}

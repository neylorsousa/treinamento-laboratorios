package com.github.neylorsousa.treinamento.laboratorio4.view.template;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

public class HeaderPanel extends Panel {

	public HeaderPanel(String id) {
		super(id);
		add(new Link("leilaoMenu"){
			@Override
			public void onClick() {

			}
		});
	}
}

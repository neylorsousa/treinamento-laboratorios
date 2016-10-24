package com.github.neylorsousa.treinamento.laboratorio4.view;

import com.github.neylorsousa.treinamento.laboratorio4.domain.LanceViewDTO;
import com.github.neylorsousa.treinamento.laboratorio4.domain.Leilao;
import com.github.neylorsousa.treinamento.laboratorio4.view.template.TemplatePage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;

import java.util.ArrayList;
import java.util.List;

public class LanceViewPage extends TemplatePage {
	private static final long serialVersionUID = 1L;

	List<LanceViewDTO> entities = new ArrayList<>();

	public LanceViewPage() {
		add(new FeedbackPanel("message"));
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		if (getSession().getAttributeNames().contains(LeilaoPage.LEILOES_SESSION_ID)) {
			for (Leilao leilao : (List<Leilao>) getSession().getAttribute(LeilaoPage.LEILOES_SESSION_ID)) {
				entities.addAll(LanceViewDTO.leilaoToListDto(leilao));
			}
		}
		if (entities.isEmpty()) {
			warn("Não possui nenhum leilão ou lance cadastrado.");
		}
	}

	@Override
	protected void onBeforeRender() {
		add(new ListView<LanceViewDTO>("lances", entities) {
			@Override
			protected void populateItem(ListItem<LanceViewDTO> item) {
				item.add(new Label("leilao", new PropertyModel<>(item.getModel(), "leilao")));
				item.add(new Label("nomePessoa", new PropertyModel<>(item.getModel(), "nomePessoa")));
				item.add(new Label("valorLance", new PropertyModel<>(item.getModel(), "valorLance")));
			}
		});
		super.onBeforeRender();
	}
}
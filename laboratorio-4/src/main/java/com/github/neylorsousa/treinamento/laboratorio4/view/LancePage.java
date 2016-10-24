package com.github.neylorsousa.treinamento.laboratorio4.view;

import com.github.neylorsousa.treinamento.laboratorio4.domain.Lance;
import com.github.neylorsousa.treinamento.laboratorio4.domain.Leilao;
import com.github.neylorsousa.treinamento.laboratorio4.view.template.TemplatePage;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import static java.util.stream.Collectors.toList;

public class LancePage extends TemplatePage {
	private static final long serialVersionUID = 1L;

	private Leilao leilao;
	private Form lanceForm;
	private Lance lance;

	public LancePage(Leilao leilao, Page leilaoPage) {
		this.leilao = leilao;
		add(new Label("leilao", leilao.getNome()));
		add(lanceForm = new Form("form"){
			@Override
			protected void onSubmit() {
				leilao.getLances().add(lance);
				setDefaultModel(new CompoundPropertyModel<>(lance = new Lance()));
			}
		});
		lanceForm.setDefaultModel(new CompoundPropertyModel<>(lance = new Lance()));
		lanceForm.add(new TextField("nomePessoa").setRequired(true));
		lanceForm.add(new TextField("valor").setRequired(true));
		add(new Link("voltar"){
			@Override
			public void onClick() {
				getPage().setResponsePage(leilaoPage);
			}
		});
	}

	@Override
	protected void onBeforeRender() {
		addOrReplace(new LanceListView());
		addOrReplace(new FeedbackPanel("message"));
		addOrReplace(new Label("nomeMaiorLance", leilao.getMaiorLance().getNomePessoa()));
		addOrReplace(new Label("valorMaiorLance", leilao.getMaiorLance().getValor()));
		super.onBeforeRender();
	}

	class LanceListView extends ListView<Lance> {
		public LanceListView() {
			super("lances", leilao.getLances().stream().collect(toList()));
		}

		@Override
		protected void populateItem(ListItem<Lance> item) {
			item.add(new Label("nome", new PropertyModel<>(item.getModel(), "nomePessoa")));
			item.add(new Label("valor", new PropertyModel<>(item.getModel(), "valor")));
			item.add(new Link("excluir") {
				@Override
				public void onClick() {
					leilao.getLances().removeIf(l ->l.equals(item.getModel().getObject()));
					getPage().info("Leilão \"" + item.getModel().getObject().getNomePessoa() + "\" removido com sucesso!");
				}
			});
		}
	}
}

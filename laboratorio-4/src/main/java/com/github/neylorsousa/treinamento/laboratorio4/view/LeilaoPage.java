package com.github.neylorsousa.treinamento.laboratorio4.view;

import com.github.neylorsousa.treinamento.laboratorio4.domain.Leilao;
import com.github.neylorsousa.treinamento.laboratorio4.view.template.TemplatePage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import java.util.ArrayList;
import static java.util.stream.Collectors.toList;

public class LeilaoPage extends TemplatePage {
	private static final long serialVersionUID = 1L;

	public static final String LEILOES_SESSION_ID="leiloes";

	private ArrayList<Leilao> leiloes;

	private Leilao leilao;

	private Form leilaoForm;

	public LeilaoPage() {
		add(leilaoForm = new Form("form") {
			@Override
			protected void onSubmit() {
				leiloes.remove(leilao);
				leiloes.add(leilao);
				getPage().info("Leilão salvo com sucesso!");
				setDefaultModel(new CompoundPropertyModel<>(leilao = new Leilao()));
			}
		});
		leilaoForm.setDefaultModel(new CompoundPropertyModel<>(leilao = new Leilao()));
		leilaoForm.add(new TextField("nome").setRequired(true));
    }


	@Override
	protected void onInitialize() {
		super.onInitialize();
		if (getSession().getAttributeNames().contains(LEILOES_SESSION_ID)) {
			leiloes = (ArrayList<Leilao>) getSession().getAttribute(LEILOES_SESSION_ID);
		} else {
			leiloes = new ArrayList<>();
		}
	}

	@Override
	protected void onBeforeRender() {
		addOrReplace(new LeilaoListView());
		addOrReplace(new FeedbackPanel("message"));
		super.onBeforeRender();
	}

	@Override
	protected void onAfterRender() {
		super.onAfterRender();
		getSession().setAttribute(LEILOES_SESSION_ID, leiloes);
	}

	class LeilaoListView extends ListView<Leilao> {
		public LeilaoListView() {
			super("leiloes", leiloes.stream().collect(toList()));
		}

		@Override
		protected void populateItem(ListItem<Leilao> item) {
			item.add(new Label("nome", new PropertyModel<>(item.getModel(), "nome")));
			item.add(new Link("editar") {
				@Override
				public void onClick() {
					leilao = leiloes.stream().filter(l -> l.getNome().equals(item.getModel().getObject().getNome())).findFirst().get();
					leilaoForm.setDefaultModel(new CompoundPropertyModel<>(leilao));
				}
			});

			item.add(new Link("excluir") {
				@Override
				public void onClick() {
					leiloes.removeIf(l -> l.getNome().equals(item.getModel().getObject().getNome()));
					getPage().info("Leilão \"" + item.getModel().getObject().getNome() + "\" removido com sucesso!");
				}
			});

			item.add(new Link("lances") {
				@Override
				public void onClick() {
					getPage().setResponsePage(new LancePage(item.getModel().getObject(), getPage()));
				}
			});
		}
	}
}
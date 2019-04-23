
package com.ipgg.ipggos.view.vaadin;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.ipgg.ipggos.model.OrdemServico;
import com.ipgg.ipggos.persistence.GenericHibernateDAOImp;
import com.ipgg.ipggos.persistence.HibernateUtil;
import com.ipgg.ipggos.view.crudview.OrdemServicoFormViewForUpdate;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewBeforeLeaveEvent;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class TelaListaOS extends VerticalLayout implements View {

	public static final String VIEW_NAME = "lista_os_view";
	private TextField campoPesquisa;
	private Button pesquisar;
	private Button criarOS;
	private Button btnMsgs;
	private Grid<OrdemServico> grid;
	private Session session;

	public TelaListaOS() {
		// List<OrdemChamado> listaOS = Arrays.asList();
		campoPesquisa = new TextField();
		campoPesquisa.setWidth("80%");
		campoPesquisa.setSizeFull();
		pesquisar = new Button("Pesquisar");
		criarOS = new Button("Nova O.S.");
		btnMsgs = new Button("Mensagens");
		grid = new Grid<>();
		// tabela.setItems(listaOS);

		Button visualizarOS = new Button("ICONE VISUALIZAR");
		Button avaliarOS = new Button("ICONE AVALIAR");
		Button feedbackOS = new Button("ICONE FEEDBACK");

		criarOS.addListener((e) -> Main.navigator.navigateTo(TelaSolicitacao.VIEW_NAME));
		btnMsgs.addListener(			
					e -> {					
						Set<OrdemServico> selectedItems = this.grid.getSelectedItems();
						if (selectedItems.size() == 1) {
							Main.navigator.navigateTo(TelaFeedBackListDeUmaOS.VIEW_NAME+"/"+selectedItems.iterator().next().getId().toString());							
						} else if (selectedItems.size() == 0) {
							Notification.show("SELECIONE UMA ORDEM DE SERVICO");
						} else {
							Notification.show("SELECIONE APENAS UMA ORDEM DE SERVICO, POR FAVOR.");
						}
						// Main.navigator.navigateTo(OrdemDeServico_FeedbacksListView.VIEW_NAME+"/id=4"));
					});

		grid.setCaption("Ordem de Chamado");
		grid.setWidth("80%");
		grid.setSizeFull();
		grid.addColumn(OrdemServico::getId).setCaption("Nº O.S.").setWidth(60);
		grid.addColumn(OrdemServico::getSolicitante).setCaption("Solicitante");
		grid.addColumn(OrdemServico::getDiretoria).setCaption("Diretoria");
		grid.addColumn(OrdemServico::getTipoServico).setCaption("Tipo Serviço");
		grid.addColumn(OrdemServico::getGrauNecessidade).setCaption("Grau Necessidade");
		grid.addColumn(OrdemServico::getStatus).setCaption("Status");
		//grid.addComponentColumn(this::buildUpdateButton).setCaption("Mensagens");
		// tabela.addColumn("").setCaption("Ações");

		HorizontalLayout header = new HorizontalLayout();
		header.addComponent(campoPesquisa);
		header.addComponent(pesquisar);
		header.addComponent(criarOS);
		header.addComponent(btnMsgs);
		header.setWidth("80%");
		header.setSizeFull();

		addComponent(header);
		addComponent(grid);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		this.session = HibernateUtil.getSessionFactory().openSession();
		GenericHibernateDAOImp<OrdemServico, Long> dao = new GenericHibernateDAOImp<>(session, OrdemServico.class,
				Long.class);
		List<OrdemServico> listOrdemServico = dao.ListarTodos();
		listOrdemServico.forEach(item -> System.out.println(item));
		this.grid.getDataProvider().refreshAll();
		this.grid.setItems(listOrdemServico);
		View.super.enter(event);
	}

	@Override
	public void beforeLeave(ViewBeforeLeaveEvent event) {
		System.out.println("TelaListaOS -> public void beforeLeave(ViewBeforeLeaveEvent event) {...");
		this.session.close();
		View.super.beforeLeave(event);
	}

}

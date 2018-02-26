
package com.ipgg.ipgg_os.view.vaadin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ipgg.ipgg_os.model.common.OrdemChamado;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class TelaListaOS extends VerticalLayout implements View {
	public static final String VIEW_NAME="lista_os_view";
	private TextField campoPesquisa;
	private Button pesquisar;
	private Button criarOS;
	private Grid<OrdemChamado> tabela;
	
	public TelaListaOS() {
		//List<OrdemChamado> listaOS = Arrays.asList();
		campoPesquisa = new TextField();
		campoPesquisa.setWidth("80%");
		campoPesquisa.setSizeFull();
		pesquisar = new Button("Pesquisar");
		criarOS = new Button("Nova O.S.");
		tabela = new Grid<>();
		//tabela.setItems(listaOS);
		
		Button visualizarOS = new Button("ICONE VISUALIZAR");
		Button avaliarOS = new Button("ICONE AVALIAR");
		Button feedbackOS = new Button("ICONE FEEDBACK");
		
		criarOS.addListener((e) -> MainView.navigator.navigateTo(TelaSolicitacao.VIEW_NAME));
		
		tabela.setCaption("Ordem de Chamado");
		tabela.setWidth("80%");
		tabela.setSizeFull();
		tabela.addColumn(OrdemChamado::getNos).setCaption("Nº O.S.");
		tabela.addColumn(OrdemChamado::getSolicitante).setCaption("Solicitante");
		tabela.addColumn(OrdemChamado::getDiretoria).setCaption("Diretoria");
		tabela.addColumn(OrdemChamado::getTipoServico).setCaption("Tipo Serviço");
		tabela.addColumn(OrdemChamado::getGrauNecessidade).setCaption("Grau Necessidade");
		tabela.addColumn(OrdemChamado::getStatus).setCaption("Status");
		//tabela.addColumn("").setCaption("Ações");
		
		HorizontalLayout header = new HorizontalLayout();
		header.addComponent(campoPesquisa);
		header.addComponent(pesquisar);
		header.addComponent(criarOS);
		header.setWidth("80%");
		header.setSizeFull();
		
		addComponent(header);
		addComponent(tabela);
	}
}

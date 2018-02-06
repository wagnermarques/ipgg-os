package com.ipgg.ipgg_os.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

public class TelaFeedBack extends FormLayout implements View {
	protected static final String VIEW_NAME = "tela_feedback";

	private TextField nos;
	private TextField gerencia;
	private TextField diretoria;
	private TextField local;
	private TextField servico;
	private TextField tipoServico;
	private TextArea posicionamento;
	private Button confirmar;
	private Button cancelar;

	public TelaFeedBack() {
		nos = new TextField("Nº O.S.");
		gerencia = new TextField("Gerência");
		diretoria = new TextField("Diretoria");
		local = new TextField("Local");
		servico = new TextField("Serviço Solicitado");
		tipoServico = new TextField("Tipo de Serviço");
		posicionamento = new TextArea("Descrição do Serviço a ser realizado");
		confirmar = new Button("Confirmar");
		cancelar = new Button("Cancelar");
		
		HorizontalLayout footer = new HorizontalLayout();
		
		nos.setEnabled(false);
		
		nos.setDescription("Nº da Ordem de Serviço");
		nos.setWidth("80%");

		gerencia.setDescription("Gerência");
		gerencia.setWidth("80%");

		diretoria.setDescription("Diretoria");
		diretoria.setWidth("80%");

		local.setDescription("Local Disponível");
		local.setWidth("80%");

		servico.setDescription("Serviço");
		servico.setWidth("80%");

		tipoServico.setDescription("Tipo de Serviço");
		tipoServico.setWidth("80%");

		posicionamento.setDescription("Posicionamento");
		posicionamento.setWidth("80%");
		
		addComponent(nos);
		addComponent(gerencia);
		addComponent(diretoria);
		addComponent(local);
		addComponent(servico);
		addComponent(tipoServico);
		addComponent(posicionamento);
		
		footer.addComponent(confirmar);
		footer.addComponent(cancelar);
		addComponent(footer);
	}
	
	@Override
    public void enter(ViewChangeEvent event) {
        //Notification.show("Bem-vindo, teste 2.");
	}
}

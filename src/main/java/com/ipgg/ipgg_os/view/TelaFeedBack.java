package com.ipgg.ipgg_os.view;

import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

public class TelaFeedBack extends FormLayout {
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
		
		addComponent(nos);
		addComponent(gerencia);
		addComponent(diretoria);
		addComponent(local);
		addComponent(servico);
		addComponent(tipoServico);
		addComponent(tipoServico);
		addComponent(posicionamento);
		
		footer.addComponent(confirmar);
		footer.addComponent(cancelar);
		addComponent(footer);
	}
}

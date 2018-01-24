package com.ipgg.ipgg_os;

import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

public class TelaAvaliacao extends FormLayout {
	TextField nos;
	ComboBox<String> manutencao;
	ComboBox<String> tenico;
	ComboBox<String> statusServico;
	TextArea descricaoServico;
	ComboBox<String> tipoDefeito;
	TextArea descricaoDefeito;
	TextField recebimentoServico;
	DateField data;
	Button confirmar;
	Button cancelar;
	Button finalizar;
	
	public TelaAvaliacao() {
		nos = new TextField("Nº O. S.");
		manutencao = new ComboBox<>("Manutenção");
		tenico = new ComboBox<String>("Técnico");
		statusServico = new ComboBox<String>("Status Serviço");
		descricaoServico = new TextArea("Descrição");
		tipoDefeito = new ComboBox<>("Tipo do Defeito");
		descricaoDefeito = new TextArea("Descrição");
		recebimentoServico = new TextField("Recebimento");
		data = new DateField("Data");
		
		confirmar = new Button("Confirmar");
		cancelar = new Button("Cancelar");
		finalizar = new Button("Finalizar");
		
		HorizontalLayout footer = new HorizontalLayout();
		HorizontalLayout finalizarFooter = new HorizontalLayout();
		
		nos.setEnabled(false);
		
		addComponent(nos);
		addComponent(manutencao);
		addComponent(tenico);
		addComponent(statusServico);
		addComponent(descricaoServico);
		addComponent(tipoDefeito);
		addComponent(descricaoDefeito);
		addComponent(recebimentoServico);
		addComponent(data);
		
		footer.addComponent(confirmar);
		footer.addComponent(cancelar);
		finalizarFooter.addComponent(finalizar);
		addComponent(footer);
		addComponent(finalizarFooter);
	}
}

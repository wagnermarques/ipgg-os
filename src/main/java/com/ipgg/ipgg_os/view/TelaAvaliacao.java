package com.ipgg.ipgg_os.view;

import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

public class TelaAvaliacao extends FormLayout {
	private TextField nos;
	private ComboBox<String> manutencao;
	private ComboBox<String> tenico;
	private ComboBox<String> statusServico;
	private TextArea descricaoServico;
	private ComboBox<String> tipoDefeito;
	private TextArea descricaoDefeito;
	private TextField recebimentoServico;
	private DateField data;
	private Button confirmar;
	private Button cancelar;
	private Button finalizar;
	
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

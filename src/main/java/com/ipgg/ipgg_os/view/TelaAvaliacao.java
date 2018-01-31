package com.ipgg.ipgg_os.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

public class TelaAvaliacao extends FormLayout implements View {
	protected static final String VIEW_NAME = "tela_avaliacao";

	private TextField nos;
	private ComboBox<String> manutencao;
	private ComboBox<String> tecnico;
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
		tecnico = new ComboBox<String>("Técnico");
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
		nos.setDescription("Número da Ordem de serviço");
		nos.setWidth("80%");

		manutencao.setDescription("Manutenção");
		manutencao.setWidth("80%");

		tecnico.setDescription("Técnico responsável");
		tecnico.setWidth("80%");

		statusServico.setDescription("Status do serviço");
		statusServico.setWidth("80%");

		descricaoServico.setDescription("Descrição do serviço");
		descricaoServico.setWidth("80%");

		tipoDefeito.setDescription("Tipo de defeito identificado");
		tipoDefeito.setWidth("80%");

		descricaoDefeito.setDescription("Descrição do defeito");
		descricaoDefeito.setWidth("80%");

		recebimentoServico.setDescription("Recebimento do serviço");
		recebimentoServico.setWidth("80%");

		data.setDescription("Data");
		data.setWidth("20%");

		finalizar.setDescription("Finalizar Avaliação");

		addComponent(nos);
		addComponent(manutencao);
		addComponent(tecnico);
		addComponent(statusServico);
		addComponent(descricaoServico);
		addComponent(tipoDefeito);
		addComponent(descricaoDefeito);
		addComponent(recebimentoServico);
		addComponent(data);

		footer.addComponent(confirmar);
		footer.addComponent(cancelar);
		finalizarFooter.addComponent(finalizar);
		setComponentAlignment(finalizar, Alignment.MIDDLE_CENTER);
		addComponent(footer);
		addComponent(finalizarFooter);
	}
	
	@Override
    public void enter(ViewChangeEvent event) {
        Notification.show("Bem-vindo, teste 1.");
	}
}

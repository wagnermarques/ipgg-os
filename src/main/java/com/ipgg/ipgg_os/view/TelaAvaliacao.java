package com.ipgg.ipgg_os.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

public class TelaAvaliacao extends FormLayout implements View {
	private static final long serialVersionUID = 1L;

	protected static final String VIEW_NAME = "tela_avaliacao";

	private TextField nos;
	private ComboBox<String> manutencao;
	private TextField empresa;
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
		empresa = new TextField("Empresa");
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

		nos.setReadOnly(true);
		nos.setDescription("Número da Ordem de serviço");
		nos.setWidth("80%");

		manutencao.setDescription("Manutenção");
		String manutencaoItens[] = {
			"Interna", "Externa", "Contratada"
		};
		manutencao.setItems(manutencaoItens);
		manutencao.setEmptySelectionAllowed(false);
		manutencao.setTextInputAllowed(false);
		manutencao.addSelectionListener((e) -> {
			String item = manutencao.getSelectedItem().get();
			String opcInterna = manutencaoItens[0];
			String opcExterna = manutencaoItens[1];
			String opcContratada = manutencaoItens[2];
			if (item.equals(opcInterna)) {
				tecnico.setItems("Técnicos internos");
				tecnico.setEmptySelectionAllowed(false);
				tecnico.setReadOnly(false);
				empresa.setValue("");
				empresa.setReadOnly(true);
			} else if (item.equals(opcExterna)) {
				tecnico.setEmptySelectionAllowed(true);
				tecnico.setValue("");
				tecnico.setItems("");
				tecnico.setReadOnly(true);
				empresa.setValue("");
				empresa.setReadOnly(false);
			} else if (item.equals(opcContratada)) {
				tecnico.setEmptySelectionAllowed(true);
				tecnico.setValue("");
				tecnico.setItems("");
				tecnico.setReadOnly(true);
				empresa.setValue("");
				empresa.setReadOnly(false);
			}
		});
		manutencao.setWidth("80%");
		
		empresa.setDescription("Nome da empresa");
		empresa.setReadOnly(true);
		empresa.setWidth("80%");

		tecnico.setDescription("Técnico responsável");
		tecnico.setReadOnly(true);
		tecnico.setEmptySelectionAllowed(false);
		tecnico.setTextInputAllowed(false);
		tecnico.setWidth("80%");

		statusServico.setDescription("Status do serviço");
		String statusServicoItens[] = {
			"Concluído", "Aguardando peça",
			"Aguardando Orçamento", "Outro"
		};
		statusServico.setItems(statusServicoItens);
		statusServico.setEmptySelectionAllowed(false);
		statusServico.setTextInputAllowed(false);
		statusServico.setWidth("80%");

		descricaoServico.setDescription("Descrição do serviço");
		descricaoServico.setWidth("80%");

		tipoDefeito.setDescription("Tipo de defeito identificado");
		String tipoDefeitoItens[] = {
			"Erro de operação", "Abuso na utilização",
			"Falha no componente", "Outro"
		};
		tipoDefeito.setItems(tipoDefeitoItens);
		tipoDefeito.setEmptySelectionAllowed(false);
		tipoDefeito.setTextInputAllowed(false);
		tipoDefeito.setWidth("80%");

		descricaoDefeito.setDescription("Descrição do defeito");
		descricaoDefeito.setWidth("80%");

		recebimentoServico.setDescription("Recebimento do status do serviço");
		recebimentoServico.setWidth("80%");

		data.setDescription("Data");
		data.setWidth("30%");

		confirmar.setDescription("Confirmar dados");
		cancelar.setDescription("Cancelar alterações realizadas");
		finalizar.setDescription("Finalizar Ordem de Serviço");

		addComponent(nos);
		addComponent(manutencao);
		addComponent(empresa);
		addComponent(tecnico);
		addComponent(statusServico);
		addComponent(descricaoServico);
		addComponent(tipoDefeito);
		addComponent(descricaoDefeito);
		addComponent(recebimentoServico);
		addComponent(data);

		footer.addComponent(confirmar);
		footer.addComponent(cancelar);
		footer.addComponent(finalizar);
		addComponent(footer);
		
	}

	@Override
    public void enter(ViewChangeEvent event) {
		//Notification.show("Bem-vindo, teste 1.");
	}
}

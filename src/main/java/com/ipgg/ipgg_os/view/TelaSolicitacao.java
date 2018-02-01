package com.ipgg.ipgg_os.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

public class TelaSolicitacao extends FormLayout implements View {
	protected static final String VIEW_NAME = "tela_solicitacao";

	private TextField nos;
	private ComboBox<String> solicitante;
	private TextField gerencia;
	private TextField diretoria;
	private ComboBox<String> local;
	private ComboBox<String> servico;
	private ComboBox<String> tipoServico;
	private TextField bemPatrimonial;
	private TextField nPatrimonio;
	private TextArea descricaoServico;
	private ComboBox<String> grauNecessidade;
	private ComboBox<String> rechamado;
	private TextField osAnterior;
	private Button confirmar;
	private Button cancelar;

	public TelaSolicitacao() {
		nos = new TextField("Nº O.S.");
		solicitante = new ComboBox<>("Solicitante Autorizado");
		gerencia = new TextField("Gerência");
		diretoria = new TextField("Diretoria");
		local = new ComboBox<>("Local");
		servico = new ComboBox<>("Serviço Solicitado");
		tipoServico = new ComboBox<>("Tipo de Serviço");
		bemPatrimonial = new TextField("Bem Patrimonial");
		nPatrimonio = new TextField("Nº de Patrimônio");
		descricaoServico = new TextArea("Descrição do Serviço a ser realizado");
		grauNecessidade = new ComboBox<>("Grau de necessidade");
		rechamado = new ComboBox<>("Rechamado");
		osAnterior = new TextField("O.S. anterior");

		confirmar = new Button("Confirmar");
		cancelar = new Button("Cancelar");

		HorizontalLayout footer = new HorizontalLayout();

		nos.setEnabled(false);
		osAnterior.setEnabled(false);
		
		nos.setDescription("Nº da Ordem de Serviço");
		nos.setWidth("80%");

		solicitante.setDescription("Solicitante autorizado");
		solicitante.setWidth("80%");

		gerencia.setDescription("Gerência");
		gerencia.setWidth("80%");

		diretoria.setDescription("Diretoria");
		diretoria.setWidth("80%");

		local.setDescription("Locais disponíveis");
		local.setWidth("80%");

		servico.setDescription("Serviço solicitado");
		String servicoItens[] = {
			"Manutenção Corretiva", "Manutenção Preventiva",
			"Instalação", "Calibração"
		};
		servico.setEmptySelectionAllowed(false);
		servico.setItems(servicoItens);
		servico.setWidth("80%");

		tipoServico.setDescription("Tipo de serviço");
		String tipoServicoItens[] = {
				"Alvenaria", "Chaveiro", "Elétrica",
				"Hidráulica", "Marcenaria", "Mobiliário/Equipamentos",
				"Pintura", "Serralheria", "Outros"
		};
		tipoServico.setEmptySelectionAllowed(false);
		tipoServico.setItems(tipoServicoItens);
		tipoServico.setWidth("80%");

		bemPatrimonial.setDescription("Bem patrimonial");
		bemPatrimonial.setWidth("80%");

		nPatrimonio.setDescription("Número do patrimônio");
		nPatrimonio.setWidth("80%");

		descricaoServico.setDescription("Descrição do serviço");
		descricaoServico.setWidth("80%");

		grauNecessidade.setDescription("Grau de necessidade");
		String grauNecessidadeItens[] = {
			"Normal", "Urgência", "Emergência"
		};
		grauNecessidade.setEmptySelectionAllowed(false);
		grauNecessidade.setItems(grauNecessidadeItens);
		grauNecessidade.setWidth("80%");

		rechamado.setDescription("Rechamado");
		String rechamdoItens[] = {
			"Não", "Sim"
		};
		rechamado.setEmptySelectionAllowed(false);
		rechamado.setItems(rechamdoItens);
		rechamado.setWidth("80%");

		osAnterior.setDescription("Número da O.S. anterior");
		osAnterior.setWidth("80%");

		addComponent(nos);
		addComponent(solicitante);
		addComponent(gerencia);
		addComponent(diretoria);
		addComponent(local);
		addComponent(servico);
		addComponent(tipoServico);
		addComponent(nPatrimonio);
		addComponent(descricaoServico);
		addComponent(grauNecessidade);
		addComponent(rechamado);
		addComponent(osAnterior);

		footer.addComponent(confirmar);
		footer.addComponent(cancelar);
		addComponent(footer);
	}
	
	@Override
    public void enter(ViewChangeEvent event) {
        Notification.show("Bem-vindo, teste 3.");
	}
}
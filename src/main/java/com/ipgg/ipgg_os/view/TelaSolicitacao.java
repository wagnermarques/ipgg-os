package com.ipgg.ipgg_os.view;

import org.vaadin.ui.NumberField;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

public class TelaSolicitacao extends FormLayout implements View {
	protected static final String VIEW_NAME = "tela_solicitacao";

	private TextField nos;
	private TextField solicitante;
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
	private NumberField osAnterior;
	private Button confirmar;
	private Button cancelar;

	public TelaSolicitacao() {
		nos = new TextField("Nº O.S.");
		solicitante = new TextField("Solicitante Autorizado");
		gerencia = new TextField("Gerência");
		diretoria = new TextField("Diretoria");
		local = new ComboBox<>("Local");
		servico = new ComboBox<>("Serviço Solicitado");
		tipoServico = new ComboBox<>("Tipo de Serviço");
		bemPatrimonial = new TextField("Bem Patrimonial");
		nPatrimonio = new NumberField("Nº de Patrimônio");
		descricaoServico = new TextArea("Descrição do Serviço a ser realizado");
		grauNecessidade = new ComboBox<>("Grau de necessidade");
		rechamado = new ComboBox<>("Rechamado");
		osAnterior = new NumberField("O.S. anterior");

		confirmar = new Button("Confirmar");
		cancelar = new Button("Cancelar");

		HorizontalLayout footer = new HorizontalLayout();

		nos.setReadOnly(true);
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

		servico.setDescription("Selecione o serviço desejado");
		String servicoItens[] = {
			"Manutenção Corretiva", "Manutenção Preventiva",
			"Instalação", "Calibração"
		};
		servico.setEmptySelectionAllowed(false);
		servico.setTextInputAllowed(false);
		servico.setItems(servicoItens);
		servico.setWidth("80%");

		tipoServico.setDescription("Selecione o tipo de serviço");
		String tipoServicoItens[] = {
			"Alvenaria", "Chaveiro", "Elétrica",
			"Hidráulica", "Marcenaria", "Mobiliário/Equipamentos",
			"Pintura", "Serralheria", "Outros"
		};
		tipoServico.setEmptySelectionAllowed(false);
		tipoServico.setTextInputAllowed(false);
		tipoServico.setItems(tipoServicoItens);
		tipoServico.setWidth("80%");
		tipoServico.addSelectionListener((e) -> {
			String item = tipoServico.getSelectedItem().get();
			String equipamentoMobiliario = tipoServicoItens[5];
			if (item.equals(equipamentoMobiliario)) {
				bemPatrimonial.setEnabled(true);
				nPatrimonio.setEnabled(true);
			} else {
				bemPatrimonial.setEnabled(false);
				bemPatrimonial.setValue("");
				nPatrimonio.setEnabled(false);
				nPatrimonio.setValue("");
			}
		});

		bemPatrimonial.setDescription("Bem patrimonial");
		bemPatrimonial.setReadOnly(false);
		bemPatrimonial.setWidth("80%");

		nPatrimonio.setDescription("Número do patrimônio");
		nPatrimonio.setWidth("80%");
		nPatrimonio.setReadOnly(false);
		

		descricaoServico.setDescription("Descrição do serviço");
		descricaoServico.setWidth("80%");

		grauNecessidade.setDescription("Selecione o grau de necessidade");
		String grauNecessidadeItens[] = { "Normal", "Urgência", "Emergência" };
		grauNecessidade.setSelectedItem(grauNecessidadeItens[0]);
		grauNecessidade.setEmptySelectionAllowed(false);
		grauNecessidade.setTextInputAllowed(false);
		grauNecessidade.setItems(grauNecessidadeItens);
		grauNecessidade.setWidth("80%");

		rechamado.setDescription("Rechamado");
		String rechamdoItens[] = { "Sim", "Não" };
		rechamado.setSelectedItem(rechamdoItens[1]);
		rechamado.setEmptySelectionAllowed(false);
		rechamado.setTextInputAllowed(false);
		rechamado.setItems(rechamdoItens);
		rechamado.setWidth("80%");
		rechamado.addSelectionListener((e) -> {
			String item = rechamado.getSelectedItem().get();
			String sim = rechamdoItens[0];
			if (item.equals(sim)) {
				osAnterior.setReadOnly(true);
			} else {
				osAnterior.setReadOnly(false);
				osAnterior.setValue("");
			}
		});

		osAnterior.setDescription("Número da O.S. anterior");
		osAnterior.setWidth("80%");
		osAnterior.setMaxValue(Long.MAX_VALUE);
		osAnterior.setDecimalAllowed(false);
		osAnterior.setGroupingUsed(false);
		osAnterior.setNegativeAllowed(false);
		osAnterior.setDecimalSeparatorAlwaysShown(false);
		osAnterior.setReadOnly(false);
		
		confirmar.setDescription("Confirmar dados");
		cancelar.setDescription("Cancelar O.S.");

		addComponent(nos);
		addComponent(solicitante);
		addComponent(gerencia);
		addComponent(diretoria);
		addComponent(local);
		addComponent(servico);
		addComponent(tipoServico);
		addComponent(bemPatrimonial);
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
		//Notification.show("Bem-vindo, teste 3.");
	}
}
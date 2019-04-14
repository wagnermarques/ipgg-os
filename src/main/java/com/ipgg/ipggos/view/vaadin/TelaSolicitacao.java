package com.ipgg.ipggos.view.vaadin;

import org.hibernate.Session;

import org.vaadin.ui.NumberField;

import com.ipgg.ipggos.model.OrdemServico;
import com.ipgg.ipggos.persistence.GenericHibernateDAOImp;
import com.ipgg.ipggos.persistence.HibernateUtil;
import com.ipgg.ipggos.persistence.IGenericDAO;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewBeforeLeaveEvent;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

public class TelaSolicitacao extends FormLayout implements View {
	public static final String VIEW_NAME = "tela_solicitacao";

	//private TextField nos;
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
	private ComboBox<Boolean> rechamado;
	private NumberField osAnterior;
	private OrdemServico ordemServico;
	private IGenericDAO<OrdemServico, Long> osDao;
	private Button confirmar;
	private Button cancelar;

	Binder<OrdemServico> binder = new Binder<OrdemServico>(OrdemServico.class);

	private GenericHibernateDAOImp<OrdemServico, Long> dao;
		
	public TelaSolicitacao() {		
		
		this.ordemServico = new OrdemServico();
		this.ordemServico.setStatus("pendente");//s os he criada com o status de pendente
		this.binder.setBean(ordemServico);	
	
//		nos = new NumberField("Nº O.S.");
//		nos.setEnabled(false);
//		nos.setReadOnly(true);
//		nos.setDescription("Nº da Ordem de Serviço");
//		nos.setWidth("80%");
		//binder.forField(nos).bind("id");
		
		
		solicitante = new TextField("Solicitante Autorizado");
		binder.forField(solicitante).bind("solicitante");
		
		gerencia = new TextField("Gerência");
		binder.forField(gerencia).bind("gerencia");
		
		diretoria = new TextField("Diretoria");
		binder.forField(diretoria).bind("diretoria");
		
		local = new ComboBox<>("Local");
		binder.forField(local).bind("local");
		
		servico = new ComboBox<>("Serviço Solicitado");
		binder.forField(servico).bind("servico");
		servico.setDescription("Selecione o serviço desejado");
		String servicoItens[] = {
			"Manutenção Corretiva", "Manutenção Preventiva",
			"Instalação", "Calibração"
		};
		
		servico.setEmptySelectionAllowed(false);
		servico.setTextInputAllowed(false);
		servico.setItems(servicoItens);
		servico.setWidth("80%");
		
		tipoServico = new ComboBox<>("Tipo de Serviço");
		binder.forField(tipoServico).bind("tipoServico");
		
		bemPatrimonial = new TextField("Bem Patrimonial");
		binder.forField(bemPatrimonial).bind("bemPatrimonial");
		bemPatrimonial.setDescription("Bem patrimonial");
		bemPatrimonial.setReadOnly(false);
		bemPatrimonial.setWidth("80%");
		
		nPatrimonio = new TextField("Nº de Patrimônio");
		binder.forField(nPatrimonio).bind("numPatrimonio");
		
		descricaoServico = new TextArea("Descrição do Serviço a ser realizado");
		binder.forField(descricaoServico).bind("descricaoServico");
		
		grauNecessidade = new ComboBox<>("Grau de necessidade");
		binder.forField(grauNecessidade).bind("grauNecessidade");
		
		rechamado = new ComboBox<Boolean>("Rechamado");
		binder.forField(rechamado).bind("rechamado");
		rechamado.setDescription("Rechamado");
		String rechamdoItens[] = { "Sim", "Não" };
		//rechamado.setSelectedItem(rechamdoItens[1]);
		rechamado.setEmptySelectionAllowed(false);
		rechamado.setTextInputAllowed(false);
		//rechamado.setItems(rechamdoItens);
		rechamado.setWidth("80%");
		rechamado.addSelectionListener((e) -> {
			//String itemSelectec = rechamado.getSelectedItem().get();
			System.out.println("rechamado.getSelectedItem().get();");
			System.out.println(rechamado.getSelectedItem().get());
			String sim = rechamdoItens[0];
			//if (itemSelectec.equals(sim)) {
				//osAnterior.setReadOnly(true);
				//osAnterior.setVa
			//} else {
			//	osAnterior.setReadOnly(false);
			//	osAnterior.setValue(false);
			//}
		});

		
		osAnterior = new NumberField("O.S. anterior");
		//binder.forField(osAnterior).bind("osAnterior");
		
		
		confirmar = new Button("Confirmar");		
		cancelar = new Button("Cancelar");		
		
		HorizontalLayout footer = new HorizontalLayout();


		solicitante.setDescription("Solicitante autorizado");
		solicitante.setWidth("80%");

		gerencia.setDescription("Gerência");
		gerencia.setWidth("80%");

		diretoria.setDescription("Diretoria");
		diretoria.setWidth("80%");

		local.setDescription("Locais disponíveis");
		local.setWidth("80%");

	

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

		
		osAnterior.setDescription("Número da O.S. anterior");
		osAnterior.setWidth("80%");
		osAnterior.setMaxValue(Long.MAX_VALUE);
		osAnterior.setDecimalAllowed(false);
		osAnterior.setGroupingUsed(false);
		osAnterior.setNegativeAllowed(false);
		osAnterior.setDecimalSeparatorAlwaysShown(false);
		osAnterior.setReadOnly(false);
		
		confirmar.setDescription("Confirmar dados");
		confirmar.addClickListener((e)->{
			
			try {
				this.binder.writeBean(this.ordemServico);
				this.dao.beginTransaction();
				this.dao.inserir(this.ordemServico);
				this.dao.commit();
				
				new Notification("Operacao Concluida com Sucesso",
					    "Ordem de Servico Salva",
					    Notification.Type.HUMANIZED_MESSAGE, true)
					    .show(Page.getCurrent());
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
						
		});
		cancelar.setDescription("Cancelar O.S.");
		cancelar.addListener((e) -> Main.navigator.navigateTo(TelaListaOS.VIEW_NAME));

		//addComponent(nos);
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
		Session session = HibernateUtil.getSessionFactory().openSession();	
		this.dao = new GenericHibernateDAOImp<>(session, OrdemServico.class, Long.class);		
	}
	
	@Override
	public void beforeLeave(ViewBeforeLeaveEvent event) {
		System.out.println("TelaSolicitacao -> public void beforeLeave(ViewBeforeLeaveEvent event) {...");
		
		this.dao.clearSession();
		this.dao.closeSession();
		View.super.beforeLeave(event);
	}

}
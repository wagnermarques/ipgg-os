package com.ipgg.ipggos.view.crudview;


import java.util.Map;


import org.hibernate.Session;
import org.vaadin.ui.NumberField;

import com.ipgg.ipggos.model.OrdemServico;
import com.ipgg.ipggos.persistence.GenericHibernateDAOImp;
import com.ipgg.ipggos.persistence.HibernateUtil;
import com.ipgg.ipggos.persistence.IGenericDAO;
import com.ipgg.ipggos.view.vaadin.ForFieldConverterStringToLong;
import com.ipgg.ipggos.view.vaadin.Main;
import com.ipgg.ipggos.view.vaadin.TelaListaOS;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewBeforeLeaveEvent;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;



public class OrdemServicoFormViewForUpdate extends FormLayout implements View {

	public static final String VIEW_NAME = "tela_solicitacao_4update";

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
	private ComboBox<Boolean> rechamado;
	private NumberField osAnterior;
	private OrdemServico ordemServico;
	private IGenericDAO<OrdemServico, Long> pDao;
	private Button confirmar;
	private Button cancelar;

	Binder<OrdemServico> binder = new Binder<OrdemServico>(OrdemServico.class);

	private GenericHibernateDAOImp<OrdemServico,Long> dao;
	
		
	public OrdemServicoFormViewForUpdate() {					
		this.binder.setBean(this.ordemServico);
		
		nos = new NumberField("Nº O.S.");
		nos.setEnabled(false);
		nos.setReadOnly(true);
		nos.setDescription("Nº da Ordem de Serviço");
		nos.setWidth("80%");
		binder.forField(nos).withConverter(new ForFieldConverterStringToLong()).bind("nos");
		
		solicitante = new TextField("Solicitante Autorizado");
		binder.forField(solicitante).bind(OrdemServico::getSolicitante, OrdemServico::setSolicitante);
		
		gerencia = new TextField("Gerência");
		binder.forField(gerencia).bind("gerencia");
		
		diretoria = new TextField("Diretoria");
		binder.forField(diretoria).bind("diretoria");
		
		local = new ComboBox<>("Local");
		binder.forField(local).bind("local");
		
		servico = new ComboBox<>("Serviço Solicitado");
		binder.forField(servico).bind("servico");
		
		tipoServico = new ComboBox<>("Tipo de Serviço");
		binder.forField(tipoServico).bind("tipoServico");
		
		bemPatrimonial = new TextField("Bem Patrimonial");
		binder.forField(bemPatrimonial).bind("bemPatrimonial");
		bemPatrimonial.setDescription("Bem patrimonial");
		bemPatrimonial.setReadOnly(false);
		bemPatrimonial.setWidth("80%");
		
		nPatrimonio = new TextField("Nº de Patrimônio");
		binder.forField(nPatrimonio).bind("nPatrimonio");
		
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
				System.out.println("this.ordemServico.getNos() ->" + this.ordemServico.getId());
				System.out.println("this.ordemServico.getSolicitante() ->" + this.ordemServico.getSolicitante());
				System.out.println("this.ordemServico.getGerencia()-> "+this.ordemServico.getGerencia());
				System.out.println("this.ordemServico.getDiretoria() ->" +this.ordemServico.getDiretoria());
				System.out.println("this.ordemServico.getTipoServico() ->" +this.ordemServico.getTipoServico());
				System.out.println("this.ordemServico.getBemPatrimonial() ->" +this.ordemServico.getBemPatrimonial());
				System.out.println("this.ordemServico.getnPatrimonio() ->" +this.ordemServico.getNumPatrimonio());
				System.out.println("this.ordemServico.getDescricaoServico() ->" +this.ordemServico.getDescricaoServico());
				System.out.println("this.ordemServico.getGrauNecessidade() ->" +this.ordemServico.getGrauNecessidade());
				System.out.println("this.ordemServico.getRechamado() ->" +this.ordemServico.getRechamado());
				System.out.println("this.ordemServico.getOsAnterior() ->" +this.ordemServico.getOsAnterior());
				System.out.println("this.ordemServico.getStatus() ->" +this.ordemServico.getStatus());
			} catch (ValidationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
			this.dao.beginTransaction();
			this.dao.inserir(this.ordemServico);
			this.dao.commit();			
		});
		cancelar.setDescription("Cancelar O.S.");
		cancelar.addListener((e) -> Main.navigator.navigateTo(TelaListaOS.VIEW_NAME));

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
		System.out.println("OrdemServicoFormViewForUpdate -> public void enter(ViewChangeEvent event) {...");
		Map<String, String> parameterMap = event.getParameterMap();
		String osId = parameterMap.get("id");
		System.out.println("id="+parameterMap.get("id"));
		
		Session session = HibernateUtil.getSessionFactory().openSession();	
		this.dao = new GenericHibernateDAOImp<>(session, OrdemServico.class, Long.class);
		this.ordemServico = this.dao.getById(Long.parseLong(osId));
                System.out.println(this.ordemServico);
                this.binder.readBean(this.ordemServico);
	}
	
	@Override
	public void beforeLeave(ViewBeforeLeaveEvent event) {
		System.out.println("OrdemServicoFormViewForUpdate -> public void beforeLeave(ViewBeforeLeaveEvent event) {...");
		
		this.dao.clearSession();
		this.dao.closeSession();
		View.super.beforeLeave(event);
	}

	}

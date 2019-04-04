package com.ipgg.ipggos.view.crudview;

import java.io.File;

import org.hibernate.Session;

import com.ipgg.ipggos.model.OrdemServico;
import com.ipgg.ipggos.persistence.GenericHibernateDAOImp;
import com.ipgg.ipggos.persistence.HibernateUtil;
import com.ipgg.ipggos.persistence.IGenericDAO;
import com.ipgg.ipggos.view.vaadin.Main;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewBeforeLeaveEvent;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileResource;
import com.vaadin.server.Page;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;

public class OrdemDeServicoFormViewForUpdate extends FormLayout implements View {

	public final static String VIEW_NAME = "ordem_servico_form_update";
	public final static String FORM_CAPTION = "Formulario: Alterar Ordem de Servico";
	private OrdemServico ordemDeServico;
	private Binder<OrdemServico> pessBinder;
	private IGenericDAO<OrdemServico, Long> osDAO;

	public OrdemDeServicoFormViewForUpdate() {

		this.ordemDeServico = null; // A instancia de usuairo a ser alterada sera setada no evento enter da view
		this.setCaption(OrdemDeServicoFormViewForUpdate.FORM_CAPTION);

		GridLayout gridLayout = new GridLayout(2, 3);// 2 colunas e 3 linhas
		gridLayout.setWidth("80%");
		gridLayout.setHeight("70%");

		
		
		// Mostra imagem de uma ordem de servico?
		// TODO: criar uma maneira pro upload da imagem da foto da pessoa
		// TODO: maneira de inserir primeiro uma pessoa e depois um usuario
		// correspondente
		FileResource resource = new FileResource(new File(Main.basepath + "/WEB-INF/images/defaultAccountImg.jpg"));
		Image image = new Image("Foto", resource);
		image.setWidth("90%");
		image.setHeight("300px");

		// Primeira coluna,Primeira linha ate a Primeira coluna mesmo e terceira linha
		gridLayout.addComponent(image, 0, 0, 0, 2);
		gridLayout.setComponentAlignment(image, Alignment.MIDDLE_CENTER);


		
		this.pessBinder = new Binder<>(OrdemServico.class);
		TextField txtSolicitante = new TextField("solicitante");
		txtSolicitante.setWidth("80%");
		txtSolicitante.setIcon(VaadinIcons.USER);			
		txtSolicitante.setRequiredIndicatorVisible(true);		
		pessBinder.forField(txtSolicitante).bind("solicitante");
		
		TextField txtGerencia = new TextField("gerencia");
		txtGerencia.setWidth("80%");
		txtGerencia.setIcon(VaadinIcons.USER);			
		txtGerencia.setRequiredIndicatorVisible(true);		
		pessBinder.forField(txtGerencia).bind("gerencia");

		TextField txtDiretoria = new TextField("diretoria");
		txtDiretoria.setWidth("80%");
		txtDiretoria.setIcon(VaadinIcons.USER);			
		txtDiretoria.setRequiredIndicatorVisible(true);		
		pessBinder.forField(txtGerencia).bind("diretoria");
		
		TextField txtLocal = new TextField("local");
		txtLocal.setWidth("80%");
		txtLocal.setIcon(VaadinIcons.USER);			
		txtLocal.setRequiredIndicatorVisible(true);			
		pessBinder.forField(txtLocal).bind("local");
		
		TextField txtServico = new TextField("servico");
		txtServico.setWidth("80%");
		txtServico.setIcon(VaadinIcons.USER);			
		txtServico.setRequiredIndicatorVisible(true);			
		pessBinder.forField(txtLocal).bind("servico");
		
		TextField txtTipoServico = new TextField("tipoServico");
		txtTipoServico.setWidth("80%");
		txtTipoServico.setIcon(VaadinIcons.USER);			
		txtTipoServico.setRequiredIndicatorVisible(true);			
		pessBinder.forField(txtLocal).bind("tipoServico");
		
		TextField txtBemPatrimonial = new TextField("bemPatrimonial");
		txtBemPatrimonial.setWidth("80%");
		txtBemPatrimonial.setIcon(VaadinIcons.USER);			
		txtBemPatrimonial.setRequiredIndicatorVisible(true);			
		pessBinder.forField(txtLocal).bind("bemPatrimonial");
				
		TextField txtNumPatrimonio = new TextField("numPatrimonio");
		txtNumPatrimonio.setWidth("80%");
		txtNumPatrimonio.setIcon(VaadinIcons.USER);			
		txtNumPatrimonio.setRequiredIndicatorVisible(true);			
		pessBinder.forField(txtNumPatrimonio).bind("numPatrimonio");
		
		TextField txtDescServico = new TextField("descricaoServico");
		txtDescServico.setWidth("80%");
		txtDescServico.setIcon(VaadinIcons.USER);			
		txtDescServico.setRequiredIndicatorVisible(true);			
		pessBinder.forField(txtLocal).bind("descricaoServico");
		
		TextField txtGrauDeNecessidade = new TextField("grauNecessidade");
		txtGrauDeNecessidade.setWidth("80%");
		txtGrauDeNecessidade.setIcon(VaadinIcons.USER);			
		txtGrauDeNecessidade.setRequiredIndicatorVisible(true);			
		pessBinder.forField(txtLocal).bind("grauNecessidade");
		
		TextField txtRechamado = new TextField("rechamado");
		txtRechamado.setWidth("80%");
		txtRechamado.setIcon(VaadinIcons.USER);			
		txtRechamado.setRequiredIndicatorVisible(true);			
		pessBinder.forField(txtLocal).bind("rechamado");
		
		TextField txtOsAnterior = new TextField("osAnterior");
		txtOsAnterior.setWidth("80%");
		txtOsAnterior.setIcon(VaadinIcons.USER);			
		txtOsAnterior.setRequiredIndicatorVisible(true);			
		pessBinder.forField(txtLocal).bind("osAnterior");
		
		TextField txtStatus = new TextField("status");
		txtStatus.setWidth("80%");
		txtStatus.setIcon(VaadinIcons.USER);			
		txtStatus.setRequiredIndicatorVisible(true);			
		pessBinder.forField(txtLocal).bind("status");

		// TextField para local
		gridLayout.addComponent(txtLocal, 1, 0, 1, 0);
		gridLayout.setComponentAlignment(txtLocal, Alignment.TOP_LEFT);

		
		//gridLayout.addComponent(txtSenha, 1, 1, 1, 1);

		
		Button btnSalvar = new Button("Salvar");
		btnSalvar.addClickListener((e) -> {
			try {
				pessBinder.writeBean(this.ordemDeServico);
				Session session = HibernateUtil.getSessionFactory().openSession();
				this.osDAO.beginTransaction();
				this.osDAO.alterar(this.ordemDeServico);
				this.osDAO.commit();

				new Notification("Operacao Concluida com Sucesso", "Msg de Operac Concluid com sucess",
						Notification.Type.HUMANIZED_MESSAGE, true).show(Page.getCurrent());
			} catch (ValidationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		gridLayout.addComponent(btnSalvar, 1, 2, 1, 2);
		this.addComponent(gridLayout);

	}

	@Override
	public void enter(ViewChangeEvent event) {
		Long suId = Long.parseLong(event.getParameters());
		Session session = HibernateUtil.getSessionFactory().openSession();
		this.osDAO = new GenericHibernateDAOImp<>(session, OrdemServico.class, Long.class);
		this.ordemDeServico = this.osDAO.getById(suId);

		this.pessBinder.setBean(this.ordemDeServico);
		View.super.enter(event);
	}

	@Override
	public void beforeLeave(ViewBeforeLeaveEvent event) {
		this.osDAO.closeSession();
		this.osDAO = null;
		View.super.beforeLeave(event);
	}

}

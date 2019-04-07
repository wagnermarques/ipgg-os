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
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;



public class OrdemDeServicoFormViewForInsertion extends FormLayout implements View {

		public final static String VIEW_NAME = "ordem_servico_form_insertion";
		public final static String FORM_CAPTION = "Formulario: Inserir Ordem de Servico";
		private OrdemServico odemDeServico;
		private IGenericDAO<OrdemServico,Long> pDAO;
		
		public OrdemDeServicoFormViewForInsertion() {
			
			this.odemDeServico = new OrdemServico();
			Binder<OrdemServico> osBinder = new Binder<>(OrdemServico.class);
			osBinder.setBean(this.odemDeServico);
			
			this.setCaption(OrdemDeServicoFormViewForInsertion.FORM_CAPTION);		
			
			
			VerticalLayout vertLayout = new VerticalLayout();

			vertLayout.setWidth("80%");
			vertLayout.setHeight("70%");
				       						
			TextField txtSolicitante = new TextField("solicitante");
			txtSolicitante.setWidth("80%");
			txtSolicitante.setIcon(VaadinIcons.USER);			
			txtSolicitante.setRequiredIndicatorVisible(true);		
			osBinder.forField(txtSolicitante).bind("solicitante");
			//gridLayout.addComponent(txtSolicitante);
			
			TextField txtGerencia = new TextField("gerencia");
			txtGerencia.setWidth("80%");
			txtGerencia.setIcon(VaadinIcons.USER);			
			txtGerencia.setRequiredIndicatorVisible(true);		
			osBinder.forField(txtGerencia).bind("gerencia");

			TextField txtDiretoria = new TextField("diretoria");
			txtDiretoria.setWidth("80%");
			txtDiretoria.setIcon(VaadinIcons.USER);			
			txtDiretoria.setRequiredIndicatorVisible(true);		
			osBinder.forField(txtGerencia).bind("diretoria");
			
			TextField txtLocal = new TextField("local");
			txtLocal.setWidth("80%");
			txtLocal.setIcon(VaadinIcons.USER);			
			txtLocal.setRequiredIndicatorVisible(true);			
			osBinder.forField(txtLocal).bind("local");
			
			TextField txtServico = new TextField("servico");
			txtServico.setWidth("80%");
			txtServico.setIcon(VaadinIcons.USER);			
			txtServico.setRequiredIndicatorVisible(true);			
			osBinder.forField(txtLocal).bind("servico");
			
			TextField txtTipoServico = new TextField("tipoServico");
			txtTipoServico.setWidth("80%");
			txtTipoServico.setIcon(VaadinIcons.USER);			
			txtTipoServico.setRequiredIndicatorVisible(true);			
			osBinder.forField(txtLocal).bind("tipoServico");
			
			TextField txtBemPatrimonial = new TextField("bemPatrimonial");
			txtBemPatrimonial.setWidth("80%");
			txtBemPatrimonial.setIcon(VaadinIcons.USER);			
			txtBemPatrimonial.setRequiredIndicatorVisible(true);			
			osBinder.forField(txtLocal).bind("bemPatrimonial");
					
			TextField txtNumPatrimonio = new TextField("numPatrimonio");
			txtNumPatrimonio.setWidth("80%");
			txtNumPatrimonio.setIcon(VaadinIcons.USER);			
			txtNumPatrimonio.setRequiredIndicatorVisible(true);			
			osBinder.forField(txtNumPatrimonio).bind("numPatrimonio");
			
			TextField txtDescServico = new TextField("descricaoServico");
			txtDescServico.setWidth("80%");
			txtDescServico.setIcon(VaadinIcons.USER);			
			txtDescServico.setRequiredIndicatorVisible(true);			
			osBinder.forField(txtLocal).bind("descricaoServico");
			
			TextField txtGrauDeNecessidade = new TextField("grauNecessidade");
			txtGrauDeNecessidade.setWidth("80%");
			txtGrauDeNecessidade.setIcon(VaadinIcons.USER);			
			txtGrauDeNecessidade.setRequiredIndicatorVisible(true);			
			osBinder.forField(txtLocal).bind("grauNecessidade");
			
			TextField txtRechamado = new TextField("rechamado");
			txtRechamado.setWidth("80%");
			txtRechamado.setIcon(VaadinIcons.USER);			
			txtRechamado.setRequiredIndicatorVisible(true);			
			osBinder.forField(txtLocal).bind("rechamado");
			
			TextField txtOsAnterior = new TextField("osAnterior");
			txtOsAnterior.setWidth("80%");
			txtOsAnterior.setIcon(VaadinIcons.USER);			
			txtOsAnterior.setRequiredIndicatorVisible(true);			
			osBinder.forField(txtLocal).bind("osAnterior");
			
			TextField txtStatus = new TextField("status");
			txtStatus.setWidth("80%");
			txtStatus.setIcon(VaadinIcons.USER);			
			txtStatus.setRequiredIndicatorVisible(true);			
			osBinder.forField(txtLocal).bind("status");

			

			Button btnSalvar = new Button("Salvar");
			btnSalvar.addClickListener((e)->{
				try {
					osBinder.writeBean(this.odemDeServico);
					Session session = HibernateUtil.getSessionFactory().openSession();
					this.pDAO.beginTransaction();
					this.pDAO.inserir(this.odemDeServico);
					this.pDAO.commit();
					
					new Notification("Operacao Concluida com Sucesso",
						    "Msg de Operac Concluid com sucess",
						    Notification.Type.HUMANIZED_MESSAGE, true)
						    .show(Page.getCurrent());
				} catch (ValidationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
	                
			//gridLayout.addComponent(btnSalvar, 1, 2, 1, 2);

//			JsLabel fzlJsLabel = new JsLabel("asdfasdfafds");
//			gridLayout.addComponent(fzlJsLabel);

			this.addComponent(vertLayout);

		}

		@Override
		public void enter(ViewChangeEvent event) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			this.pDAO = new GenericHibernateDAOImp<>(session, OrdemServico.class, Long.class);
			View.super.enter(event);
		}

		@Override
		public void beforeLeave(ViewBeforeLeaveEvent event) {
			this.pDAO.closeSession();
			this.pDAO = null;
			View.super.beforeLeave(event);
		}

	}

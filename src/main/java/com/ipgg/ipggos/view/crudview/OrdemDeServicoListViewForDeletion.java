package com.ipgg.ipggos.view.crudview;

import java.util.List;


import java.util.logging.Logger;

import org.hibernate.Session;

import com.ipgg.ipggos.model.OrdemServico;
import com.ipgg.ipggos.persistence.GenericHibernateDAOImp;
import com.ipgg.ipggos.persistence.HibernateUtil;
import com.ipgg.ipggos.persistence.IGenericDAO;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewBeforeLeaveEvent;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;



public class OrdemDeServicoListViewForDeletion extends VerticalLayout implements View {

	Logger logger = Logger.getLogger(OrdemDeServicoListViewForDeletion.class.getCanonicalName());

	private List<OrdemServico> listSistemaUsuarios;
	private IGenericDAO<OrdemServico,Long> osDAO;
	private Grid<OrdemServico> grid;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String VIEW_NAME = "ordem_servico_list_view_for_deletion";

	public OrdemDeServicoListViewForDeletion() {
		logger.info(" ### public OrdemDeServicoListViewForDeletion() {... ");
	}

	
	@Override
	public void enter(ViewChangeEvent event) {
		logger.info(" ### OrdemDeServicoListViewForDeletion -> public void enter(ViewChangeEvent event) {...");

		this.listSistemaUsuarios = null;
		Session session = HibernateUtil.getSessionFactory().openSession();		
		this.osDAO = new GenericHibernateDAOImp<>(session, OrdemServico.class, Long.class);		
		this.listSistemaUsuarios = this.osDAO.ListarTodos();
		
		this.grid = new Grid<>();
		this.grid.setItems(this.listSistemaUsuarios);
		this.grid.addColumn(OrdemServico::getId).setCaption("id");
		this.grid.addColumn(OrdemServico::getSolicitante).setCaption("Solicitante");
		this.grid.addColumn(OrdemServico::getGerencia).setCaption("Gerencia");
		this.grid.addColumn(OrdemServico::getDiretoria).setCaption("Diretoria");
		this.grid.addColumn(OrdemServico::getLocal).setCaption("Local");
		this.grid.addColumn(OrdemServico::getServico).setCaption("Servico");
		this.grid.addColumn(OrdemServico::getTipoServico).setCaption("TipoServico");
		this.grid.addColumn(OrdemServico::getBemPatrimonial).setCaption("BemPatrimonial");
		this.grid.addColumn(OrdemServico::getNumPatrimonio).setCaption("NumPatrimonio");
		this.grid.addColumn(OrdemServico::getDescricaoServico).setCaption("DescricaoServico");
		this.grid.addColumn(OrdemServico::getGrauNecessidade).setCaption("GrauNecessidade");
		this.grid.addColumn(OrdemServico::getRechamado).setCaption("Rechamado");
		this.grid.addColumn(OrdemServico::getOsAnterior).setCaption("OsAnterior");
		this.grid.addColumn(OrdemServico::getStatus).setCaption("Status");
			
		this.grid.setFrozenColumnCount(2);
		this.grid.addComponentColumn(this::buildDeleteButton);
		
		this.addComponent(grid);
		View.super.enter(event);
	}

	private Button buildDeleteButton(OrdemServico os) {
		Button button = new Button(VaadinIcons.CLOSE);
		button.addStyleName(ValoTheme.BUTTON_SMALL);
		button.addClickListener(e -> exclui(os));
		return button;
	}

	private void exclui(OrdemServico os) {
		this.osDAO.beginTransaction();
		this.osDAO.excluir(os);
		this.osDAO.commit();
		this.listSistemaUsuarios = osDAO.ListarTodos();
		this.grid.setItems(this.listSistemaUsuarios);
	}



	@Override
	public void beforeLeave(ViewBeforeLeaveEvent event) {
		if(this.osDAO != null) {
			this.osDAO.closeSession();
			this.osDAO = null;
		}
		View.super.beforeLeave(event);
	}

	
	
}

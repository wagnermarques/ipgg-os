package com.ipgg.ipggos.view.crudview;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;

import com.ipgg.ipggos.model.OrdemServico;
import com.ipgg.ipggos.persistence.GenericHibernateDAOImp;
import com.ipgg.ipggos.persistence.HibernateUtil;
import com.ipgg.ipggos.persistence.IGenericDAO;
import com.ipgg.ipggos.view.vaadin.Main;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewBeforeLeaveEvent;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;



public class OrdemDeServicoListViewForUpdate extends VerticalLayout implements View {

	Logger logger = Logger.getLogger(OrdemDeServicoListViewForUpdate.class.getCanonicalName());

	private List<OrdemServico> listOrdemServico;
	private IGenericDAO<OrdemServico,Long> osDAO;
	private Grid<OrdemServico> grid;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String VIEW_NAME = "ordem_servico_list_view_for_Update";
	public static String VIEW_CAPTION = "Alterar Ordem de Servico: (OrdemDeServicoListViewForUpdate) ";

	public OrdemDeServicoListViewForUpdate() {
		logger.info(" ### public OrdemDeServicoListViewForUpdate() {... ");
		setCaption(OrdemDeServicoListViewForUpdate.VIEW_CAPTION);
	}

	
	
	@Override
	public void enter(ViewChangeEvent event) {
		logger.info(" ### SistemaUsuarioListViewForUpdate -> public void enter(ViewChangeEvent event) {...");

		this.listOrdemServico = null;
		Session session = HibernateUtil.getSessionFactory().openSession();		
		this.osDAO = new GenericHibernateDAOImp<>(session, OrdemServico.class, Long.class);		
		this.listOrdemServico = this.osDAO.ListarTodos();
		for(OrdemServico os : this.listOrdemServico) {
			System.out.println(os);
		}
		this.grid = new Grid<>();
		this.grid.setWidth("100%");
		this.grid.addItemClickListener(e -> {
			Main.navigator.navigateTo(OrdemServicoFormViewForUpdate.VIEW_NAME+"/"+e.getItem().getId());
		});
		this.grid.setItems(this.listOrdemServico);
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
		this.grid.addComponentColumn(this::buildUpdateButton);
		
		this.addComponent(grid);
		View.super.enter(event);
	}

	private Button buildUpdateButton(OrdemServico os) {
		Button button = new Button(VaadinIcons.EDIT);
		button.addStyleName(ValoTheme.BUTTON_SMALL);
		button.addClickListener(e -> Main.navigator.navigateTo(OrdemServicoFormViewForUpdate.VIEW_NAME+"/"+os.getId()));
		return button;
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

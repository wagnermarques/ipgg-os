package com.ipgg.ipggos.view.crudview;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;

import com.ipgg.ipggos.model.sistema.SistemaUsuario;
import com.ipgg.ipggos.persistence.GenericHibernateDAOImp;
import com.ipgg.ipggos.persistence.HibernateUtil;
import com.ipgg.ipggos.persistence.IGenericDAO;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

public class SistemaUsuarioListViewForUpdate extends VerticalLayout implements View {

	Logger logger = Logger.getLogger(SistemaUsuarioListView.class.getCanonicalName());

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int numacessos = 0;

	public static String VIEW_NAME = "sistema_usuario_list_view";
	
	public static String VIEW_CAPTION = "Modificar Usuario (SistemaUsuarioListViewForUpdate)";

	private List<SistemaUsuario> listSistUsuarios;
	private IGenericDAO<SistemaUsuario, Long> suDAO;

	private Grid<SistemaUsuario> grid;

	public SistemaUsuarioListViewForUpdate() {
			logger.info(" ### public SistemaUsuarioListViewForUpdate() {... ");
			this.grid = new Grid<>();
			this.grid.addColumn(SistemaUsuario::getId).setCaption("id");
			this.grid.addColumn(SistemaUsuario::getLogin).setCaption("Login");
			this.grid.addColumn(SistemaUsuario::getSenha).setCaption("senha");		
			this.grid.setFrozenColumnCount(2);                
			this.addComponent(this.grid);
			setCaption(SistemaUsuarioFormViewForUpdate.FORM_CAPTION);
		}

	@Override
	public void enter(ViewChangeEvent event) {
		logger.info(" ### public void enter(ViewChangeEvent event) {... [numacessos] => " + this.numacessos++);

		// Cada vez que a view entra a gente quer controlar o seu estado desde o inicio
		// a gente descarta o estado anterior e inicia o estado dela tudo de novo
		this.listSistUsuarios = null;

		if (this.suDAO != null) {
			this.suDAO.clearSession();
			this.suDAO.closeSession();
			this.suDAO = null;
		}

		Session session = HibernateUtil.getSessionFactory().openSession();
		suDAO = new GenericHibernateDAOImp<>(session, SistemaUsuario.class, Long.class);
		this.listSistUsuarios = this.suDAO.ListarTodos();
		// logger.info(this.listSistUsuarios.toString());
		// https://stackoverflow.com/questions/31861375/vaadin-refresh-grid-after-row-modification

		// setEditorEnabled(true);
		// this.grid.setEditorEnabled(false);
		this.grid.getDataProvider().refreshAll();
		this.grid.setItems(this.listSistUsuarios);
		View.super.enter(event);
	}
}
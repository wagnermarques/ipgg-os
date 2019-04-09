package com.ipgg.ipggos.view.crudview;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;

import com.ipgg.ipggos.model.common.Pessoa;
import com.ipgg.ipggos.model.sistema.SistemaUsuario;
import com.ipgg.ipggos.persistence.GenericHibernateDAOImp;
import com.ipgg.ipggos.persistence.HibernateUtil;
import com.ipgg.ipggos.persistence.IGenericDAO;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

public class PessoaListViewForUpdate extends VerticalLayout implements View {

	Logger logger = Logger.getLogger(PessoaListViewForUpdate.class.getCanonicalName());

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int numacessos = 0;

	public static final String VIEW_NAME = "sistema_usuario_list_view";
	public static final String VIEW_CAPTION = "Alterar Pessoa Cadastrada: PessoaListViewForUpdate";
	
	private List<Pessoa> listPessoas;
	private IGenericDAO<Pessoa, Long> pDAO;

	private Grid<Pessoa> grid;

	public PessoaListViewForUpdate() {
			logger.info(" ### public PessoaListViewForUpdate() {... ");
			this.grid = new Grid<>();
			this.grid.addColumn(Pessoa::getId).setCaption("id");
			this.grid.addColumn(Pessoa::getNome).setCaption("Nome");
			this.grid.addColumn(Pessoa::getRg).setCaption("RG");
			this.grid.addColumn(Pessoa::getCpf).setCaption("CPF");
			this.grid.addColumn(Pessoa::getIdentificador).setCaption("Identificador");
			this.grid.setFrozenColumnCount(2);                
			this.addComponent(this.grid);
			setCaption(SistemaUsuarioFormViewForUpdate.FORM_CAPTION);
		}

	@Override
	public void enter(ViewChangeEvent event) {
		logger.info(" ### public void enter(ViewChangeEvent event) {... [numacessos] => " + this.numacessos++);

		// Cada vez que a view entra a gente quer controlar o seu estado desde o inicio
		// a gente descarta o estado anterior e inicia o estado dela tudo de novo
		this.listPessoas = null;

		if (this.pDAO != null) {
			this.pDAO.clearSession();
			this.pDAO.closeSession();
			this.pDAO = null;
		}

		Session session = HibernateUtil.getSessionFactory().openSession();
		pDAO = new GenericHibernateDAOImp<>(session, SistemaUsuario.class, Long.class);
		this.listPessoas = this.pDAO.ListarTodos();
		// logger.info(this.listSistUsuarios.toString());
		// https://stackoverflow.com/questions/31861375/vaadin-refresh-grid-after-row-modification

		// setEditorEnabled(true);
		// this.grid.setEditorEnabled(false);
		this.grid.getDataProvider().refreshAll();
		this.grid.setItems(this.listPessoas);
		View.super.enter(event);
	}
}
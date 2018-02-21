package com.ipgg.ipgg_os.view.crudview;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;

import com.ipgg.ipgg_os.model.common.Pessoa;
import com.ipgg.ipgg_os.persistence.GenericHibernateDAOImp;
import com.ipgg.ipgg_os.persistence.HibernateUtil;
import com.ipgg.ipgg_os.persistence.IGenericDAO;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;



public class PessoaListView extends VerticalLayout implements View {
	
	Logger logger = Logger.getLogger(PessoaListView.class.getCanonicalName());
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int numacessos = 0;
	
	public static String VIEW_NAME="pessoa_list_view";
	
	private List<Pessoa> listPessoas;	
	private IGenericDAO<Pessoa,Long> pessoaDAO;

	private Grid<Pessoa> grid;

	
	public PessoaListView() {
		logger.info(" ### public PessoaListView() {... ");
		this.grid = new Grid<>();
		this.grid.addColumn(Pessoa::getNome).setCaption("Nome");
		this.grid.addColumn(Pessoa::getId).setCaption("Identificador");
		this.grid.addColumn(Pessoa::getRg).setCaption("RG");
		this.grid.addColumn(Pessoa::getCpf).setCaption("CPF");
		this.grid.setFrozenColumnCount(2);                
		this.addComponent(this.grid);
	}


	@Override
	public void enter(ViewChangeEvent event) {
		logger.info(" ### public void enter(ViewChangeEvent event) {... [numacessos] => "+this.numacessos++);
		
		//Cada vez que a view entra a gente quer controlar o seu estado desde o inicio
		//a gente descarta o estado anterior e inicia o estado dela tudo de novo
		this.listPessoas = null;
		
		if(this.pessoaDAO != null) {
			this.pessoaDAO.clearSession();
			this.pessoaDAO.closeSession();
			this.pessoaDAO = null;
		}
		
		Session session = HibernateUtil.getSessionFactory().openSession();		
		pessoaDAO = new GenericHibernateDAOImp<>(session, Pessoa.class, Long.class);
		this.listPessoas = this.pessoaDAO.ListarTodos();

		logger.info(" ### public void enter(ViewChangeEvent event) {... [this.listPessoas.size()] => "+this.listPessoas.size());
		//https://stackoverflow.com/questions/31861375/vaadin-refresh-grid-after-row-modification
		
		//setEditorEnabled(true);
		//this.grid.setEditorEnabled(false);
		this.grid.getDataProvider().refreshAll();
		this.grid.setItems(this.listPessoas);
		View.super.enter(event);
	}
}

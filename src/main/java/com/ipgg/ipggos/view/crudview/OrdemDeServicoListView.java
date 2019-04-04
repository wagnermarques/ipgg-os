package com.ipgg.ipggos.view.crudview;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;

import com.ipgg.ipggos.model.OrdemServico;
import com.ipgg.ipggos.persistence.GenericHibernateDAOImp;
import com.ipgg.ipggos.persistence.HibernateUtil;
import com.ipgg.ipggos.persistence.IGenericDAO;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;



public class OrdemDeServicoListView extends VerticalLayout implements View {
	
	Logger logger = Logger.getLogger(OrdemDeServicoListView.class.getCanonicalName());
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static int numacessos = 0;
	
	public static String VIEW_NAME="ordem_servico_list_view";
	
	private List<OrdemServico> listOrdensDeServicos;	
	private IGenericDAO<OrdemServico,Long> osDAO;

	private Grid<OrdemServico> grid;

	
	public OrdemDeServicoListView() {
		logger.info(" ### public OrdemDeServicoListView() {... ");
		this.grid = new Grid<>();
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
		this.addComponent(this.grid);
	}


	@Override
	public void enter(ViewChangeEvent event) {
            OrdemDeServicoListView.numacessos =+ 1;
		logger.info(" ### public void enter(ViewChangeEvent event) {... [numacessos] => "+ OrdemDeServicoListView.numacessos);
		
		//Cada vez que a view entra a gente quer controlar o seu estado desde o inicio
		//a gente descarta o estado anterior e inicia o estado dela tudo de novo
		this.listOrdensDeServicos = null;
		
		if(this.osDAO != null) {
			this.osDAO.clearSession();
			this.osDAO.closeSession();
			this.osDAO = null;
		}
		
		Session session = HibernateUtil.getSessionFactory().openSession();				
		osDAO = new GenericHibernateDAOImp<>(session, OrdemServico.class, Long.class);
		this.listOrdensDeServicos = this.osDAO.ListarTodos();
		logger.info(this.listOrdensDeServicos.toString());
		//https://stackoverflow.com/questions/31861375/vaadin-refresh-grid-after-row-modification
		
		//setEditorEnabled(true);
		//this.grid.setEditorEnabled(false);
		this.grid.getDataProvider().refreshAll();
		this.grid.setItems(this.listOrdensDeServicos);
		View.super.enter(event);
	}
}

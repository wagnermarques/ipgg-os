package com.ipgg.ipggos.view.vaadin;

import java.util.Locale;

import javax.servlet.annotation.WebServlet;

import com.ipgg.ipggos.view.crudview.OrdemServicoFormViewForUpdate;
import com.ipgg.ipggos.view.crudview.PessoaFormInserirView;
import com.ipgg.ipggos.view.crudview.PessoaListView;
import com.ipgg.ipggos.view.crudview.PessoaListViewForDeletion;
import com.ipgg.ipggos.view.crudview.SistemaUsuarioFormViewForInsertion;
import com.ipgg.ipggos.view.crudview.SistemaUsuarioFormViewForUpdate;
import com.ipgg.ipggos.view.crudview.OrdemDeServicoFormViewForInsertion;
import com.ipgg.ipggos.view.crudview.OrdemDeServicoListView;
import com.ipgg.ipggos.view.crudview.SistemaUsuarioListView;
import com.ipgg.ipggos.view.crudview.SistemaUsuarioListViewForDeletion;
import com.ipgg.ipggos.view.crudview.SistemaUsuarioListViewForUpdate;
import com.ipgg.ipggos.view.crudview.OrdemDeServicoListViewForDeletion;
import com.ipgg.ipggos.view.crudview.OrdemDeServicoListViewForUpdate;
import com.ipgg.ipggos.view.vaadin.menu.MenuPrincipal;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author Clederson Cruz
 * 
 * Sistema web, construído em Java, para auxiliar na manutenção do prédio do
 * Instituto de Geriatria e Gerontologia - "José Ermírio Moraes" (IPGG -JEM)
 * através do controle de ordem de serviço.
 */
@Theme("meutema")
//@Theme("BlueprintCustom")
public class Main extends UI {

	public static String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath(); 
	public static Navigator navigator;
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {    	
    	    	
    	VerticalLayout mainLayout = new VerticalLayout();
    	mainLayout.setCaption("MainLayoutCaption");
    	mainLayout.setSizeFull();
    	mainLayout.setStyleName("mainLayout");
    	    	
    	VerticalLayout bodyLayout = new VerticalLayout();
    	bodyLayout.setCaption("BodyLayoutCaption");
    	bodyLayout.setWidth("100%");
    	bodyLayout.setStyleName("bodyLayout");
    	
    	
    	mainLayout.addComponent(MenuPrincipal.getInstance());
    	mainLayout.addComponent(bodyLayout);    	
    	
    	
    	mainLayout.setExpandRatio(bodyLayout, 1.0f);
    	setContent(mainLayout);    	
    	configNavigation(bodyLayout);
    	
    	getPage().setTitle("IPPG OS");    	
    	UI.getCurrent().setLocale(new Locale("pt-BR")); 
    	setSizeFull();
    }

	private void configNavigation(VerticalLayout bodyLayout) {
	
    	//TelaSolicitacao telaSolicitacao = new TelaSolicitacao();
		//TelaAvaliacao telaAvaliacao = new TelaAvaliacao();
		//TelaFeedBack telaFeedBack = new TelaFeedBack();
		TelaLogin telaLogin = new TelaLogin();
		//TelaListaOS telaListaOS = new TelaListaOS();
		//OrdemServicoFormViewForUpdate ordemServicoFormViewForUpdate = new OrdemServicoFormViewForUpdate();
		
		navigator = new Navigator(this, bodyLayout);
//		navigator.addView("", telaListaOS);
//		navigator.addView(TelaListaOS.VIEW_NAME, telaListaOS);
//		navigator.addView(TelaSolicitacao.VIEW_NAME, telaSolicitacao);
//		navigator.addView(TelaAvaliacao.VIEW_NAME, telaAvaliacao);
//		
//		navigator.addView(TelaFeedBack.VIEW_NAME, telaFeedBack);
//		navigator.addView(TelaListaOS.VIEW_NAME, telaListaOS);

		navigator.addView("", new TelaLogin());
		
		navigator.addView(OrdemDeServicoListView.VIEW_NAME, new OrdemDeServicoListView());
		navigator.addView(OrdemDeServicoFormViewForInsertion.VIEW_NAME, new OrdemDeServicoFormViewForInsertion());
		navigator.addView(OrdemDeServicoListViewForUpdate.VIEW_NAME, new OrdemDeServicoListViewForUpdate());
		navigator.addView(OrdemDeServicoListViewForDeletion.VIEW_NAME, new OrdemDeServicoListViewForDeletion());
						
		navigator.addView(SistemaUsuarioListView.VIEW_NAME, new SistemaUsuarioListView());
		navigator.addView(SistemaUsuarioFormViewForInsertion.VIEW_NAME, new SistemaUsuarioFormViewForInsertion());
		navigator.addView(SistemaUsuarioListViewForUpdate.VIEW_NAME, new SistemaUsuarioListViewForUpdate());
		navigator.addView(SistemaUsuarioFormViewForUpdate.VIEW_NAME, new SistemaUsuarioFormViewForUpdate());
		
		navigator.addView(SistemaUsuarioListViewForDeletion.VIEW_NAME, new SistemaUsuarioListViewForDeletion());
		
		navigator.addView(PessoaFormInserirView.VIEW_NAME, new PessoaFormInserirView(null, null));
		navigator.addView(PessoaListViewForDeletion.VIEW_NAME, new PessoaListViewForDeletion());
		navigator.addView(PessoaListView.VIEW_NAME, new PessoaListView());
	}
	

	public static void setValueInHttpSession(String attrName, Object value) {
		VaadinSession.getCurrent().setAttribute(attrName, value);
	}

	public static Object getValueFromHttpSession(String attrName) {
		return VaadinSession.getCurrent().getAttribute(attrName);
	}

    
    @WebServlet(urlPatterns = "/*", name = "MainWindowServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = Main.class, productionMode = false)
    public static class MainWindowServlet extends VaadinServlet {
    }
}

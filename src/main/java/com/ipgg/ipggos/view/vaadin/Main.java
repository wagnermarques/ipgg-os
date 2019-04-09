package com.ipgg.ipggos.view.vaadin;

import java.util.Locale;

import javax.servlet.annotation.WebServlet;

import com.ipgg.ipggos.model.sistema.SistemaUsuario;
import com.ipgg.ipggos.service.security.LogoutService;
import com.ipgg.ipggos.view.crudview.OrdemDeServicoFormViewForInsertion;
import com.ipgg.ipggos.view.crudview.OrdemDeServicoListView;
import com.ipgg.ipggos.view.crudview.OrdemDeServicoListViewForDeletion;
import com.ipgg.ipggos.view.crudview.OrdemDeServicoListViewForUpdate;
import com.ipgg.ipggos.view.crudview.PessoaFormInserirView;
import com.ipgg.ipggos.view.crudview.PessoaListView;
import com.ipgg.ipggos.view.crudview.PessoaListViewForDeletion;
import com.ipgg.ipggos.view.crudview.PessoaListViewForUpdate;
import com.ipgg.ipggos.view.crudview.SistemaUsuarioFormViewForInsertion;
import com.ipgg.ipggos.view.crudview.SistemaUsuarioFormViewForUpdate;
import com.ipgg.ipggos.view.crudview.SistemaUsuarioListView;
import com.ipgg.ipggos.view.crudview.SistemaUsuarioListViewForDeletion;
import com.ipgg.ipggos.view.crudview.SistemaUsuarioListViewForUpdate;
import com.ipgg.ipggos.view.vaadin.menu.MenuPrincipal;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Clederson Cruz, Wagner Marques
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
	
	public static HorizontalLayout horizLayout4AppUserIdentification;
	public static HorizontalLayout horizLayout;
	
	public static final String SESSION_ATTR_USER_LOGGEDIN = "UserLoggedIn";
	
	public static SistemaUsuario getUserLoggedIn() {
		return (SistemaUsuario)Main.getValueFromHttpSession("userLoggedIn");
	}
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {    	

    	//Layout vertical mestre
    	VerticalLayout mainLayout = new VerticalLayout();
    	
    	//Layout horizontal pra abrigar o menu e o horizLayout de Ident do usuario
    	horizLayout = new HorizontalLayout();
    	horizLayout.setWidth("100%");
    	
    	//Layout onde ocorrera a navegacao de telas
    	VerticalLayout bodyLayout = new VerticalLayout();
    	
    	//Configurando layout mestre
    	mainLayout.setCaption("MainLayoutCaption");
    	mainLayout.setSizeFull();
    	mainLayout.setStyleName("mainLayout");
    	//mainLayout.setCaption(Main.getUserLoggedIn() != null ? Main.getUserLoggedIn().getLogin() : "Nenhum Usuario Logado");
    	mainLayout.setCaption("Main.getUserLoggedIn() != null ? Main.getUserLoggedIn().getLogin() : Nenhum Usuario Logado Main.getUserLoggedIn() != null ? Main.getUserLoggedIn().getLogin() : Nenhum Usuario Logado Main.getUserLoggedIn() != null ? Main.getUserLoggedIn().getLogin() : Nenhum Usuario Logado ");
    	
    	//configurando o layout de navegacao de telas
    	bodyLayout.setCaption("BodyLayoutCaption");
    	bodyLayout.setWidth("100%");
    	bodyLayout.setStyleName("bodyLayout");
    	    	    	    	
    	//Criando o layout de ident do usuario
    	horizLayout4AppUserIdentification = new HorizontalLayout();
    	Label lbUserName = new Label("Usuario Logado = " + Main.getUserLoggedIn() == null ? Main.getUserLoggedIn().getLogin() : "?");
    	Button btnSair = new Button("Sair");
    	btnSair.addClickListener(e -> {
    		new LogoutService().execute();    		
    	});
    	horizLayout4AppUserIdentification.addComponent(lbUserName);
    	horizLayout4AppUserIdentification.addComponent(btnSair);
    	btnSair.setEnabled(false);
    	
    	//MONTAGEM DA INTERFACE DO USUARIO
    	//primeiro colocando o menu e o layout de ident do usuario no horizLayout
    	horizLayout.addComponent(MenuPrincipal.getInstance());
    	horizLayout.addComponent(horizLayout4AppUserIdentification);
    	horizLayout.setComponentAlignment(horizLayout4AppUserIdentification, Alignment.MIDDLE_RIGHT);
    	
    	//colocando o layout horizontal do menu e da ident do usuario layout master
    	mainLayout.addComponent(horizLayout);
    	//e coloando o layout de navegacao de telas no layout master
    	mainLayout.addComponent(bodyLayout);    	
    	
    	//Mais algumas confs do layout mestre
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
		//TelaLogin telaLogin = new TelaLogin();
		//TelaListaOS telaListaOS = new TelaListaOS();
		//OrdemServicoFormViewForUpdate ordemServicoFormViewForUpdate = new OrdemServicoFormViewForUpdate();
		
		navigator = new Navigator(this, bodyLayout);
//		navigator.addView("", telaListaOS);
//		navigator.addView(TelaListaOS.VIEW_NAME, telaListaOS);
//		navigator.addView(TelaSolicitacao.VIEW_NAME, telaSolicitacao);
//		navigator.addView(TelaAvaliacao.VIEW_NAME, telaAvaliacao);
//		
		//navigator.addView(TelaFeedBack.VIEW_NAME, telaFeedBack);
		navigator.addView(TelaListaOS.VIEW_NAME, new TelaListaOS());

		navigator.addView("", new LoginView());
		navigator.addView(LoginView.LOGIN_VIEW_NAME, new LoginView());
		
		navigator.addView(TelaSolicitacao.VIEW_NAME	, new TelaSolicitacao());
		
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
		navigator.addView(PessoaListViewForUpdate.VIEW_NAME, new PessoaListViewForUpdate());
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

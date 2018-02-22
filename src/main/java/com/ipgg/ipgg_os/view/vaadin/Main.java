package com.ipgg.ipgg_os.view.vaadin;

import java.util.Locale;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Clederson Cruz
 * 
 * Sistema web, construído em Java, para auxiliar na manutenção do prédio do
 * Instituto de Geriatria e Gerontologia - "José Ermírio Moraes" (IPGG -JEM)
 * através do controle de ordem de serviço.
 */
@Theme("meutema")
public class Main extends UI {

	public static String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath(); 
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	MainView mainView = new MainView(this);
    	getPage().setTitle("IPPG OS");
    	setContent(mainView);
    	UI.getCurrent().setLocale(new Locale("pt-BR"));
    	setSizeFull();
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

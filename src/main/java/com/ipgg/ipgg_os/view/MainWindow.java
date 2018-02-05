package com.ipgg.ipgg_os.view;

import java.util.Locale;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
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
public class MainWindow extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	MainView mainView = new MainView(this);
    	getPage().setTitle("IPPG OS");
    	setContent(mainView);
    	UI.getCurrent().setLocale(new Locale("pt-BR"));
    	setSizeFull();
    }

    @WebServlet(urlPatterns = "/*", name = "MainWindowServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MainWindow.class, productionMode = false)
    public static class MainWindowServlet extends VaadinServlet {
    }
}

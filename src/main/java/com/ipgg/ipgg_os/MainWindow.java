package com.ipgg.ipgg_os;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.UI;

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
        //FormLayout telaS = new TelaSolicitacao();
    	//FormLayout telaF = new TelaFeedBack();
        
        //setContent(telaS);
        //setContent(telaS);
        setSizeFull();
    }

    @WebServlet(urlPatterns = "/*", name = "MainWindowServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MainWindow.class, productionMode = false)
    public static class MainWindowServlet extends VaadinServlet {
    }
}

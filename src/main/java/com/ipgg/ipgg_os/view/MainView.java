package com.ipgg.ipgg_os.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

public class MainView extends VerticalLayout implements View {
	protected static final String VIEW_NAME = "main";

	private MainWindow mainWindow;
	private Navigator navigator;
	private Button avaliacao;
	private Button solicitacao;
	private Button feedback;
	
	public MainView(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		avaliacao = new Button("Avaliação");
		solicitacao = new Button("Solicitação");
		feedback = new Button("Feedback");

    	TelaSolicitacao telaSolicitacao = new TelaSolicitacao();
    	TelaAvaliacao telaAvaliacao = new TelaAvaliacao();
    	TelaFeedBack telaFeedBack = new TelaFeedBack();

    	navigator = new Navigator(mainWindow, mainWindow);
    	navigator.addView(TelaSolicitacao.VIEW_NAME, telaSolicitacao);
    	navigator.addView(TelaAvaliacao.VIEW_NAME, telaAvaliacao);
    	navigator.addView(TelaFeedBack.VIEW_NAME, telaFeedBack);

    	addComponent(avaliacao);
    	addComponent(solicitacao);
    	addComponent(feedback);
    	
	}
}

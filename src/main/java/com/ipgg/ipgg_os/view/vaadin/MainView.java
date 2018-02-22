package com.ipgg.ipgg_os.view.vaadin;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

public class MainView extends VerticalLayout implements View {
	public static Navigator navigator;

	public MainView(Main mainWindow) {
		HorizontalLayout body = new HorizontalLayout();

		TelaSolicitacao telaSolicitacao = new TelaSolicitacao();
		TelaAvaliacao telaAvaliacao = new TelaAvaliacao();
		TelaFeedBack telaFeedBack = new TelaFeedBack();
		TelaLogin telaLogin = new TelaLogin();
		TelaListaOS telaListaOS = new TelaListaOS();

		navigator = new Navigator(mainWindow, mainWindow);
		navigator.addView("", telaListaOS);
		navigator.addView(TelaListaOS.VIEW_NAME, telaListaOS);
		navigator.addView(TelaSolicitacao.VIEW_NAME, telaSolicitacao);
		navigator.addView(TelaAvaliacao.VIEW_NAME, telaAvaliacao);
		navigator.addView(TelaFeedBack.VIEW_NAME, telaFeedBack);
		navigator.addView(TelaListaOS.VIEW_NAME, telaListaOS);

		body.setWidth("100%");
		addComponent(body);

	}
}

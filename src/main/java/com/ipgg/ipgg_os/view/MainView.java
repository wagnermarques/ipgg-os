package com.ipgg.ipgg_os.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

public class MainView extends VerticalLayout implements View {
	private Navigator navigator;
	private Button avaliacao;
	private Button solicitacao;
	private Button feedback;

	public MainView(MainWindow mainWindow) {
		avaliacao = new Button("Avaliação");
		solicitacao = new Button("Solicitação");
		feedback = new Button("Feedback");
		
		HorizontalLayout body = new HorizontalLayout();
		
		avaliacao.setWidth("80%");
		avaliacao.setHeight("200px");
		solicitacao.setWidth("80%");
		solicitacao.setHeight("200px");
		feedback.setWidth("80%");
		feedback.setHeight("200px");

		TelaSolicitacao telaSolicitacao = new TelaSolicitacao();
		TelaAvaliacao telaAvaliacao = new TelaAvaliacao();
		TelaFeedBack telaFeedBack = new TelaFeedBack();

		navigator = new Navigator(mainWindow, mainWindow);
		navigator.addView("", this);
		navigator.addView(TelaSolicitacao.VIEW_NAME, telaSolicitacao);
		navigator.addView(TelaAvaliacao.VIEW_NAME, telaAvaliacao);
		navigator.addView(TelaFeedBack.VIEW_NAME, telaFeedBack);

		body.addComponent(avaliacao);
		body.setComponentAlignment(avaliacao, Alignment.MIDDLE_CENTER);
		body.addComponent(solicitacao);
		body.setComponentAlignment(solicitacao, Alignment.MIDDLE_CENTER);
		body.addComponent(feedback);
		body.setComponentAlignment(feedback, Alignment.MIDDLE_CENTER);
		body.setWidth("100%");
		addComponent(body);

		avaliacao.addClickListener((e) -> navigator.navigateTo(TelaAvaliacao.VIEW_NAME));

		solicitacao.addClickListener((e) -> navigator.navigateTo(TelaSolicitacao.VIEW_NAME));

		feedback.addClickListener((e) -> navigator.navigateTo(TelaFeedBack.VIEW_NAME));
	}
}

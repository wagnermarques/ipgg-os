package com.ipgg.ipggos.view.vaadin;

import org.jboss.logging.Logger;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class TelaLogin extends VerticalLayout implements View {
	
	private static final long serialVersionUID = 1L;
	private final Logger logger = Logger.getLogger(TelaLogin.class);
	public static final String LOGIN_VIEW_NAME="login_view";
	public static final String VIEW_CAPTION = "Login";
	private TextField username;
	private TextField password;
	private Button acessar;
	private Button cancelar;

	public TelaLogin() {
		
		setCaption(TelaLogin.VIEW_CAPTION);
		
		username = new TextField("Usuário");
		password = new PasswordField("Senha");

		acessar = new Button("Login");
		cancelar = new Button("Cancelar");

		HorizontalLayout footer = new HorizontalLayout();

		addComponent(username);
		addComponent(password);

		acessar.setDescription("Acessar");
		cancelar.setDescription("Cancelar login");

		footer.addComponent(acessar);
		footer.addComponent(cancelar);
		addComponent(footer);
	}
}
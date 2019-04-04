package com.ipgg.ipggos.view.vaadin;

import java.util.HashMap;
import java.util.Map;

import org.jboss.logging.Logger;

import com.ipgg.ipggos.model.sistema.SistemaUsuario;
import com.ipgg.ipggos.service.security.LoginService;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class LoginView extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Logger logger = Logger.getLogger(LoginView.class);
	
	public static final String LOGIN_VIEW_NAME="login_view";
	
	
	public LoginView() {
		
		//layout for buttons ok and clean
		HorizontalLayout buttonsHorizontalLayout = new HorizontalLayout();
		
		FormLayout loginFormLayout = new FormLayout();
		final TextField txtUserName = new TextField("Usuario");
		final TextField txtUserSenha = new PasswordField("Password");
		
		Button buttonOK = new Button("OK", new Button.ClickListener() {			
			@Override
			public void buttonClick(ClickEvent event) {				
				String txtUserNameToBeLogged = txtUserName.getValue();
				String txtPasswordToBeLogged = txtUserSenha.getValue();
				logger.info("txtUserNameToBeLogged = "+txtUserNameToBeLogged);
				logger.info("txtPasswordToBeLogged = "+txtPasswordToBeLogged);
				
				Map<String,String> mapForLoginService = new HashMap<>();				
				mapForLoginService.put("userName", txtUserNameToBeLogged);
				mapForLoginService.put("userPassword", txtPasswordToBeLogged );
				
				LoginService loginService = new LoginService();
				
				try {
					SistemaUsuario authenticatedUser = loginService.execute(mapForLoginService);
					if( authenticatedUser == null ) {
						new Notification("Falha no login!!!");
					}else {
						Main.setValueInHttpSession("userLoggedIn", authenticatedUser);
						Main.navigator.navigateTo(TelaListaOS.VIEW_NAME);
					}					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});	
		Button buttonCleanForm = new Button("Limpar", new Button.ClickListener() {			
			@Override
			public void buttonClick(ClickEvent event) {				
				
			}
		});
	
		buttonsHorizontalLayout.addComponents(buttonOK,buttonCleanForm);		
		loginFormLayout.addComponents(txtUserName,txtUserSenha,buttonsHorizontalLayout);		
		addComponent(loginFormLayout);
	}
	
	
}

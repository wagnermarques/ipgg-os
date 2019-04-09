package com.ipgg.ipggos.view.vaadin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.logging.Logger;

import com.ipgg.ipggos.model.sistema.SistemaUsuario;
import com.ipgg.ipggos.model.sistema.SistemaUsuarioRole;
import com.vaadin.ui.Button;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;

public class ViewComponentsStateController {

	private final Logger logger = Logger.getLogger(ViewComponentsStateController.class);

	private static Map<String, com.vaadin.ui.MenuBar.MenuItem> menus_StateMachine = new HashMap<>();
	private static Map<String, Button> buttons_StateMachine = new HashMap<>();

	public static void registerMenuItem(com.vaadin.ui.MenuBar.MenuItem menuItem) {
		// os itens de menus sao registrados ao serem instanciados
		// portanto aqui sao setados os estados iniciais de cada um deles
		// Por enquanto todos comecam desabilitados e sao habilitados depois do login
		menuItem.setEnabled(false);
		menus_StateMachine.put(menuItem.getText(), menuItem);
	}

	public static void updateComponentsLoginEvent(SistemaUsuario user) {
		Main.horizLayout4AppUserIdentification.getComponent(1).setEnabled(true);
		Main.horizLayout4AppUserIdentification.getComponent(0).setVisible(true);
		((com.vaadin.ui.Label) Main.horizLayout4AppUserIdentification.getComponent(0)).setValue(user.getLogin());

		if (user.userInRole("admin")) {

			// se usuario tem role admin, habilita todos os menus
			MenuBar menuBar = (MenuBar) Main.horizLayout.getComponent(0);
			menuBar.setEnabled(true);
			List<MenuItem> menus = menuBar.getItems();
			
			//Habilitando menu e sub menus cadastro 
			MenuItem menuCadastro = menus.get(0);
			menuCadastro.setEnabled(true);			
			List<MenuItem> itensDoMenuCadastro = menuCadastro.getChildren();
			
			MenuItem subMenuCadastroDeUsuariosDoSistema = itensDoMenuCadastro.get(0);
			subMenuCadastroDeUsuariosDoSistema.setEnabled(true);
			for (MenuItem i1 : subMenuCadastroDeUsuariosDoSistema.getChildren()) {
				i1.setEnabled(true);
			}
			
			MenuItem subMenuCadastroDeOrdensDeServico = itensDoMenuCadastro.get(1);
			subMenuCadastroDeOrdensDeServico.setEnabled(true);
			for (MenuItem i2 : subMenuCadastroDeOrdensDeServico.getChildren()) {
				i2.setEnabled(true);
			}
			
			MenuItem subMenuCadastroDePessoas = itensDoMenuCadastro.get(2);
			subMenuCadastroDePessoas.setEnabled(true);
			for (MenuItem i3 : subMenuCadastroDePessoas.getChildren()) {
				i3.setEnabled(true);
			}			
			
			
			//menuOrdemDeServico
			MenuItem menuItem = menus.get(1);
			menuItem.setEnabled(true);
			menuItem.getChildren().forEach(i -> i.setEnabled(true));
		}		
	}

	public static void updateComponentsLogoutEvent() {
		com.vaadin.ui.MenuBar menuBar = (com.vaadin.ui.MenuBar)Main.horizLayout.getComponent(0);
		menuBar.setEnabled(false);
		Main.horizLayout4AppUserIdentification.getComponent(1).setEnabled(false);
		Main.horizLayout4AppUserIdentification.getComponent(0).setVisible(false);
		((com.vaadin.ui.Label) Main.horizLayout4AppUserIdentification.getComponent(0)).setValue("?");
		Main.navigator.navigateTo(LoginView.LOGIN_VIEW_NAME);
	}

}

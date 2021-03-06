package com.ipgg.ipggos.service.security;

import java.util.Map;
import java.util.logging.Logger;

import org.hibernate.Session;
import com.ipgg.ipggos.model.sistema.SistemaUsuario;
import com.ipgg.ipggos.persistence.HibernateUtil;
import com.ipgg.ipggos.persistence.SistemaUsuarioHibernateDAO;
import com.ipgg.ipggos.service.Command;
import com.ipgg.ipggos.view.vaadin.LoginView;
import com.ipgg.ipggos.view.vaadin.ViewComponentsStateController;


public class LoginService implements Command<Map<String, String>, SistemaUsuario> {

	private final static Logger logger = Logger.getLogger(LoginService.class.getName());

	
	@Override
	public SistemaUsuario execute(Map<String, String> param) throws Exception {
						
		String userNameToBeLoggedIn = param.get("userName");
		String userPasswordToBeLoggedIn = param.get("userPassword");			
		
		// none was informed
		if (userNameToBeLoggedIn == null || userPasswordToBeLoggedIn == null) {
			logger.info("User Not Authenticated: userNameToBeLoggedIn or userPasswordToBeLoggedIn was null");			
			return null;
		}
		
		Session session = HibernateUtil.getSessionFactory().openSession();	
		SistemaUsuarioHibernateDAO sistemaUsuarioDAO = new SistemaUsuarioHibernateDAO(session, SistemaUsuario.class, Long.class);		
		SistemaUsuario loginQueryUserResult = sistemaUsuarioDAO.LoginQuery(userNameToBeLoggedIn,userPasswordToBeLoggedIn);		
		
		if(loginQueryUserResult != null) {
			//FIX: Identificar quem e a pessoa desse usuario
			//FIX: Aplicar roles no usuario
			return loginQueryUserResult;
		}else {
			return null;
		}	
		
	}//execute
	
}//class

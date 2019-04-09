package com.ipgg.ipggos.service.security;

import java.util.logging.Logger;

import com.ipgg.ipggos.view.vaadin.Main;
import com.ipgg.ipggos.view.vaadin.ViewComponentsStateController;


public class LogoutService {

		private final static Logger logger = Logger.getLogger(LogoutService.class.getName());
		
		public void execute() {
			Main.setValueInHttpSession(Main.SESSION_ATTR_USER_LOGGEDIN, null);	
			ViewComponentsStateController.updateComponentsLogoutEvent();
		}
		
	}//class

package com.ipgg.ipgg_os.view.vaadin.framework;

import com.ipgg.ipgg_os.view.vaadin.Main;
import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;



public class DefaultAppSessionInitListener implements SessionInitListener{

	@Override
	public void sessionInit(SessionInitEvent event) throws ServiceException {
		Main.setValueInHttpSession("adminPasswod", "admin123");
		Main.setValueInHttpSession("userLoggedIn", null);
		Main.setValueInHttpSession("usersLoggedIn", null);
	}

}

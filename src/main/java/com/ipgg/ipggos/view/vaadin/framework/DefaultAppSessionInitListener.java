package com.ipgg.ipggos.view.vaadin.framework;

import com.ipgg.ipggos.persistence.HibernateUtil;
import com.ipgg.ipggos.view.vaadin.Main;
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

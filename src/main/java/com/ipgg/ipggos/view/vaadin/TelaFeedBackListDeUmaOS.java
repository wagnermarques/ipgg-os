package com.ipgg.ipggos.view.vaadin;

import java.util.Date;

import org.hibernate.Session;
import org.jboss.logging.Logger;

import com.ipgg.ipggos.model.OrdemServico;
import com.ipgg.ipggos.model.common.FeedbackOS;
import com.ipgg.ipggos.persistence.GenericHibernateDAOImp;
import com.ipgg.ipggos.persistence.HibernateUtil;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewBeforeLeaveEvent;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

public class TelaFeedBackListDeUmaOS extends FormLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(TelaFeedBackListDeUmaOS.class);

	public static final String VIEW_NAME = "tela_feedback_listDeUmOS";

	private OrdemServico os;
	private FeedbackOS newMsg;

	private VerticalLayout msgVertLay;

	private Button btnEnviarMsg;
	private Button fechar;

	private HorizontalLayout headerHorizLay;
	private HorizontalLayout headerHorizLay4NewMsg;
	private VerticalLayout bodyVertLay;

	private Label lbOsId;
	private Label lbOsDesc;
	private Label lbOsStatus;

	private GenericHibernateDAOImp<OrdemServico, Long> osDao;
	private GenericHibernateDAOImp<FeedbackOS, Long> msgDao;
	private TextArea txtAreaNewMsg;

	private Binder<FeedbackOS> binder = new Binder<FeedbackOS>(FeedbackOS.class);

	public TelaFeedBackListDeUmaOS() {

		this.newMsg = new FeedbackOS();

		// Horiz Layout
		headerHorizLay = new HorizontalLayout();
		headerHorizLay.setCaptionAsHtml(true);
		headerHorizLay.setCaption("<h1>Ordem de Servico selecionada</h1>");
		headerHorizLay.setStyleName("OrdemDeServicoPanelStyle");

		this.headerHorizLay4NewMsg = new HorizontalLayout();		
		this.headerHorizLay.setCaption("<h1>Nova Mensagem</h1>");
		this.headerHorizLay.setStyleName("OrdemDeServicoPanelStyle");

		
		this.btnEnviarMsg = new Button("Confirmar");

		this.btnEnviarMsg.addListener(e -> {
			logger.debug("this.btnEnviarMsg.addListener( e->{...");
			try {
				this.newMsg.setDta(new Date());
				this.binder.writeBean(this.newMsg);
				logger.info("this.newMsg.getPosicionamento() = " + this.newMsg.getPosicionamento());
				this.msgDao.inserir(this.newMsg);
				this.os.getFeedbacks().add(this.newMsg);
				this.osDao.alterar(this.os);
				Main.navigator.navigateTo(TelaListaOS.VIEW_NAME);

			} catch (ValidationException e1) {
				e1.printStackTrace();
			}
		});

		
		// Vert Layout (body layour)
		this.bodyVertLay = new VerticalLayout();
		txtAreaNewMsg = new TextArea();
		txtAreaNewMsg.setWidth("100%");
		this.headerHorizLay4NewMsg.addComponent(txtAreaNewMsg);
		this.headerHorizLay4NewMsg.addComponent(this.btnEnviarMsg);

		addComponent(headerHorizLay);
		addComponent(headerHorizLay4NewMsg);
		addComponent(bodyVertLay);

		this.binder.setBean(this.newMsg);
		this.binder.forField(txtAreaNewMsg).bind("posicionamento");
	}

	@Override
	public void enter(ViewChangeEvent event) {

		this.os = null;
		this.lbOsId = null;
		this.lbOsDesc = null;
		this.lbOsStatus = null;

		String strOsId = event.getParameters();
		Long osId = Long.parseLong(strOsId);

		Session session = HibernateUtil.getSessionFactory().openSession();
		osDao = new GenericHibernateDAOImp<OrdemServico, Long>(session, OrdemServico.class, Long.class);
		msgDao = new GenericHibernateDAOImp<FeedbackOS, Long>(session, FeedbackOS.class, Long.class);

		this.os = osDao.getById(osId);
		lbOsId = new Label(this.os.getId().toString());
		lbOsDesc = new Label(this.os.getDescricaoServico());
		lbOsStatus = new Label(this.os.getStatus());

		this.headerHorizLay.addComponent(this.lbOsId);
		this.headerHorizLay.addComponent(this.lbOsDesc);
		this.headerHorizLay.addComponent(this.lbOsStatus);

		for (FeedbackOS msg : this.os.getFeedbacks()) {
			logger.info("msg = ");
			Label lbHr = new Label("------------------------------------------------------------");
			this.bodyVertLay.addComponent(new Label(msg.getDta().toString() + " " +msg.getPosicionamento()));
			this.bodyVertLay.addComponent(lbHr);
		}

		//o commit he dado no onleave page
		this.osDao.beginTransaction();// the session in osDao and msgDao is the same
	}

	@Override
	public void beforeLeave(ViewBeforeLeaveEvent event) {

		this.osDao.flushSession();
		this.osDao.commit();
		this.osDao.clearSession();
		this.osDao.closeSession();

		this.os = null;
		this.lbOsId.setValue("");
		this.lbOsDesc.setValue("");
		this.lbOsStatus.setValue("");
		this.txtAreaNewMsg.setValue("");

		//removo todos os componentes que representam msgs
		this.bodyVertLay.removeAllComponents();
		
		View.super.beforeLeave(event);

	}
}

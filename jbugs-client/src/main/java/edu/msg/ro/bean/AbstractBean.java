package edu.msg.ro.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import edu.msg.ro.business.common.exception.JBugsException;

public abstract class AbstractBean {

	public void handleExeptionI18n(JBugsException e) {
		FacesContext context = FacesContext.getCurrentInstance();
		String eMessage = context.getApplication().evaluateExpressionGet(context, "#{msg['" + e.getMessage() + "']}",
				String.class);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(eMessage));
	}

	public void addMessage(String message) {
		addMessage(null, message);
	}

	public void addMessage(String key, String message) {
		FacesContext.getCurrentInstance().addMessage(key, new FacesMessage(message));
	}
}

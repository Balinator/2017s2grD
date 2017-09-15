package edu.msg.ro.bean;

import java.text.MessageFormat;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import edu.msg.ro.business.common.exception.JBugsExeption;

/**
 * AbstractBean class.
 * 
 * @author balinc
 *
 */
public abstract class AbstractBean {

	protected FacesContext context = FacesContext.getCurrentInstance();

	/**
	 * Translate JBugsExeption exeption message.
	 * 
	 * @param e
	 */
	protected void handleExeptionI18n(JBugsExeption e) {
		addI18nMessage(e.getMessage());
	}

	/**
	 * Translate message send to interface.
	 * 
	 * @param message
	 */
	protected void addI18nMessage(String message) {
		addI18nMessage(null, message, null);
	}

	/**
	 * Translate message send to interface.
	 * 
	 * @param message
	 */
	protected void addI18nMessage(String key, String message) {
		addI18nMessage(key, message, null);
	}

	/**
	 * Translate message send to interface.
	 * 
	 * @param message
	 */
	protected void addI18nMessage(String message, Object messageArguments) {
		addI18nMessage(null, message, messageArguments);
	}

	/**
	 * Translate message send to interface object.
	 * 
	 * @param key
	 * @param message
	 */
	protected void addI18nMessage(String key, String message, Object messageArguments) {
		String eMessage = context.getApplication().evaluateExpressionGet(context, "#{msg['" + message + "']}",
				String.class);
		if (messageArguments != null) {
			MessageFormat formatter = new MessageFormat("");
			formatter.setLocale(context.getViewRoot().getLocale());
			formatter.applyPattern(eMessage);
			eMessage = formatter.format(messageArguments);
		}
		addMessage(key, eMessage);
	}

	/**
	 * Send new message to primeface.
	 * 
	 * @param message
	 */
	protected void addMessage(String message) {
		addMessage(null, message);
	}

	/**
	 * Send new message to primeface object.
	 * 
	 * @param key
	 * @param message
	 */
	protected void addMessage(String key, String message) {
		context.addMessage(key, new FacesMessage(message));
	}
}

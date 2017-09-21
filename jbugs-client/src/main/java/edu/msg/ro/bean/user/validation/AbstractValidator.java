package edu.msg.ro.bean.user.validation;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;

import edu.msg.ro.i18n.Translator;

/**
 * Abastract Validator.
 * 
 * @author balinc
 *
 */
public abstract class AbstractValidator implements Validator {

	/**
	 * Translator {@link Translator}
	 */
	protected Translator t = new Translator();

	/**
	 * Translate message.
	 * 
	 * @param context
	 * @param message
	 * @return {@link FacesMessage}
	 */
	protected FacesMessage translate(FacesContext context, String message) {
		String translated = t.setContext(context).translate(message);
		return newMessage(translated);
	}

	/**
	 * Translate message and replace arguments.
	 * 
	 * @param context
	 * @param message
	 * @param arguments
	 * @return {@link FacesMessage}
	 */
	protected FacesMessage translate(FacesContext context, String message, Object arguments) {
		String translated = t.setContext(context).translate(message, arguments);
		return newMessage(translated);
	}

	/**
	 * Generate new FacesMessage message.
	 *
	 * @param message
	 * @return {@link FacesMessage}
	 */
	protected FacesMessage newMessage(String message) {
		return new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
	}
}

package edu.msg.ro.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;

/**
 * Translator service.
 * 
 * @author balinc
 */
@Stateless
public class Translator {

	public static final String i18n_BUNDLE = "i18n.messages";

	protected FacesContext context = FacesContext.getCurrentInstance();

	/**
	 * Get FacesContext.
	 * 
	 * @return {@link FacesContext}
	 */
	public FacesContext getContext() {
		return context;
	}

	/**
	 * Set FacesContext and return Translator.
	 * 
	 * @param {@link
	 * 			FacesContext}
	 * @return {@link Translator}
	 */
	public Translator setContext(FacesContext context) {
		this.context = context;
		return this;
	}

	/**
	 * Get ResourceBundle.
	 *
	 * @return {@link ResourceBundle}
	 */
	public ResourceBundle getResourceBundle() {
		FacesContext context = FacesContext.getCurrentInstance();
		Locale locale = context.getViewRoot().getLocale();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		return ResourceBundle.getBundle("i18n.messages", locale, loader);
	}

	/**
	 * Format string.
	 * 
	 * @param message
	 * @param arguments
	 * @return {@link String}
	 */
	public String messageFormat(String message, Object arguments) {
		MessageFormat formatter = new MessageFormat(message);
		formatter.setLocale(context.getViewRoot().getLocale());
		return formatter.format(arguments);
	}

	/**
	 * Translate string.
	 * 
	 * @param message
	 * @return {@link String}
	 */
	public String translate(String message) {
		return getResourceBundle().getString(message);
	}

	/**
	 * Translate string and replace placeholders.
	 * 
	 * @param message
	 * @param arguments
	 * @return {@link String}
	 */
	public String translate(String message, Object arguments) {
		return messageFormat(translate(message), arguments);
	}
}

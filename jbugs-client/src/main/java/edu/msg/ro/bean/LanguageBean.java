package edu.msg.ro.bean;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Class for managing languages.
 * 
 * @author laszll
 *
 */
@ManagedBean
@SessionScoped
public class LanguageBean extends AbstractBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8657090779305459598L;

	/**
	 * Enum for avabil languages.
	 * 
	 * @author laszll
	 *
	 */
	public enum Language {
		DEFAULT("en"), ENGLISH("en"), ROMANIAN("ro");

		/**
		 * Constructor
		 * 
		 * @param key
		 */
		private Language(String key) {
			this.key = key;
		}

		private final String key;
	}

	private Locale locale = new Locale(Language.DEFAULT.key);

	/**
	 * Get for locale.
	 * 
	 * @return
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * Set for locale.
	 * 
	 * @param lang
	 */
	public void setLocale(Locale lang) {
		locale = lang;
	}

	/**
	 * Method for setting language to session.
	 * 
	 * @param lang
	 */
	public void setLanguage(Language lang) {
		locale = new Locale(lang.key);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

}
package edu.msg.ro.bean;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LanguageBean extends AbstractBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8657090779305459598L;

	public enum Language {
		DEFAULT("en"), ENGLISH("en"), ROMANIAN("ro");

		private Language(String key) {
			this.key = key;
		}

		private final String key;
	}

	private Locale locale = new Locale(Language.DEFAULT.key);

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale lang) {
		locale = lang;
	}

	public void setLanguage(Language lang) {
		locale = new Locale(lang.key);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

}
package edu.msg.ro.bean;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class LanguageBean {

	public enum Language {
		DEFAULT("en"), ENGLISH("en"), ROMANIAN("ro");

		private Language(String key) {
			this.key = key;
		}

		private final String key;
	}

	public static void setLanguage(Language lang) {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(lang.key));
	}

}
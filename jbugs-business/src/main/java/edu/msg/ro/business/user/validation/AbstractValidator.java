package edu.msg.ro.business.user.validation;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;

public abstract class AbstractValidator implements Validator {

	protected FacesContext context = FacesContext.getCurrentInstance();

	protected static final String i18n_BUNDLE = "msg";

	protected FacesMessage translateError(String message) {
		ResourceBundle messages = ResourceBundle.getBundle(i18n_BUNDLE, context.getViewRoot().getLocale());
		return new FacesMessage(FacesMessage.SEVERITY_ERROR, messages.getString(message), messages.getString(message));
	}
}

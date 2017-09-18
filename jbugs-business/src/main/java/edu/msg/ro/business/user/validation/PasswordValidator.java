package edu.msg.ro.business.user.validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Class for password validation.
 * 
 * @author balinc
 *
 */
@FacesValidator("passwordValidator")
public class PasswordValidator implements Validator {

	/**
	 * Method for validating password.
	 */
	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
		String stringValue = value.toString();
		if (stringValue.length() < 3) {
			FacesMessage message = new FacesMessage("We have a wrong password!");
			throw new ValidatorException(message);
		}

	}

}

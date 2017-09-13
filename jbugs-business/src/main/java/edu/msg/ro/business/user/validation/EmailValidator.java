package edu.msg.ro.business.user.validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Class for checking email format
 * 
 * @author nemeta
 *
 */
@FacesValidator("emailValidator")
public class EmailValidator implements Validator {
	/**
	 * Check email format with regex
	 */
	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {

		String email = value.toString();

		if (!email.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@+[msggroup.com]{12}$")) {
			FacesMessage message = new FacesMessage("Email format needed: [adress]@msggroup.com");
			throw new ValidatorException(message);
		}

	}

}

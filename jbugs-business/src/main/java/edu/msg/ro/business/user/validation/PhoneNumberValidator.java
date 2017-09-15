package edu.msg.ro.business.user.validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * 
 * @author nagya
 *
 */
@FacesValidator("phoneNumberValidator")
public class PhoneNumberValidator implements Validator {
	/**
	 * Check the phone number
	 */
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		String phoneNumber = value.toString();

		if (!phoneNumber.matches("[0-9]+")) {
			FacesMessage message = new FacesMessage("just numbers");
			throw new ValidatorException(message);
		}
		if (phoneNumber.length() != 13) {
			FacesMessage message = new FacesMessage("Not enough numbers");
			throw new ValidatorException(message);
		}
		if (phoneNumber.startsWith("") == false && phoneNumber.startsWith("") == false) {
			FacesMessage message = new FacesMessage("Phone number must be from Romania or Germany");
			throw new ValidatorException(message);
		}

	}
}

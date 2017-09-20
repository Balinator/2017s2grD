package edu.msg.ro.business.user.validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Class for Validating phone numbers.
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
		final String wrongNumberMessage = "error.phoneNumber";

		if (!phoneNumber.matches("^(\\+|00)(((40|400)[0-9]{9})|((49|490)[0-9]{6,13}))$")) {

			FacesMessage message = new FacesMessage(wrongNumberMessage);
			throw new ValidatorException(message);
		}

	}
}

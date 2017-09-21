package edu.msg.ro.bean.user.validation;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

/**
 * Class for Validating phone numbers.
 * 
 * @author nagya
 *
 */
@FacesValidator("phoneNumberValidator")
public class PhoneNumberValidator extends AbstractValidator {

	/**
	 * Error message key.
	 */
	public static final String I18N_ERROR = "users.phone.error";

	/**
	 * Check the phone number
	 */
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		String phoneNumber = value.toString();
		// Examples 0040123456789 or +49123456
		if (!phoneNumber.matches("^(\\+|00)(((40|400)[0-9]{9})|((49|490)[0-9]{6,13}))$")) {
			throw new ValidatorException(translate(context, I18N_ERROR));
		}
	}
}

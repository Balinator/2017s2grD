package edu.msg.ro.converter;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import edu.msg.ro.bean.roleService;
import edu.msg.ro.business.user.dto.RoleDTO;

/**
 * Converter for Role.
 * 
 * @author laszll
 *
 */
@FacesConverter("roleConverter")
public class RoleConverter implements Converter {

	@EJB
	private roleService service;

	/**
	 * String to Role.
	 */
	@Override
	public RoleDTO getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				roleService service = (roleService) fc.getExternalContext().getRequestMap().get("roleService");
				return service.getRoleItemMap().get(Long.parseLong(value));
			} catch (NumberFormatException e) {
				throw new ConverterException(
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid role."));
			}
		} else {
			return null;
		}
	}

	/**
	 * Role to String.
	 */
	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			return String.valueOf(((RoleDTO) object).getId());
		} else {
			return null;
		}
	}
}
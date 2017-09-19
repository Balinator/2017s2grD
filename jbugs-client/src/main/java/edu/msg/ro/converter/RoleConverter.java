package edu.msg.ro.converter;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import edu.msg.ro.bean.UserRoleService;
import edu.msg.ro.business.user.dto.RoleDTO;

/**
 * Converter for Role.
 * 
 * @author balinc
 *
 */
@ManagedBean
public class RoleConverter implements Converter {

	@ManagedProperty("#{userRoleService}")
	private UserRoleService service;

	/**
	 * String to Role.
	 */
	@Override
	public RoleDTO getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
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

	/**
	 * Set User Role Service.
	 * 
	 * @param service
	 */
	public void setService(UserRoleService service) {
		this.service = service;
	}
}
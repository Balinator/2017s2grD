package edu.msg.ro.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import edu.msg.ro.business.user.boundary.UserFacade;
import edu.msg.ro.business.user.dto.UserDTO;

@ManagedBean
@RequestScoped
public class UserConverter implements Converter {

	@EJB
	private UserFacade userFacade;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return userFacade.getUserByUsername(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return ((UserDTO) value).getUsername();
	}

}

package edu.msg.ro.converter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import edu.msg.ro.business.bug.boundary.BugFacade;
import edu.msg.ro.business.bug.dto.BugDTO;

@ManagedBean
@RequestScoped
public class RealBugConverter implements Converter {

	@EJB
	private BugFacade bugFacade;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		return bugFacade.getBugByTitle(value);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		return ((BugDTO) value).getTitle();
	}
}

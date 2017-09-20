package edu.msg.ro.access;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.msg.ro.business.user.boundary.UserFacade;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.security.PermissionChecker;

@ManagedBean(name = "userAccessService")
@SessionScoped
public class UserAccessService {

	@EJB
	private PermissionChecker permissionChecker;

	@EJB
	private UserFacade userFacade;

	public boolean canAccess(List<Long> permissionIds) {
		if (permissionIds == null) {
			return true;
		}

		UserDTO curentUser = userFacade.getUserByUsername(
				(String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username"));

		return permissionChecker.canAccess(curentUser, permissionIds);
	}

}

package edu.msg.ro.access;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.msg.ro.business.user.boundary.UserFacade;
import edu.msg.ro.business.user.dto.PermissionDTO;
import edu.msg.ro.business.user.dto.RoleDTO;
import edu.msg.ro.business.user.dto.UserDTO;

@ManagedBean
@SessionScoped
public class UserAccessService {

	@EJB
	private UserFacade userFacade;

	public boolean canAccess(PermissionDTO neededPermission) {
		if (neededPermission == null) {
			return true;
		}

		UserDTO curentUser = userFacade.getUserByUsername(
				(String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username"));

		for (RoleDTO roleDTO : curentUser.getRoles()) {
			for (PermissionDTO permissionDTO : roleDTO.getPermissions()) {
				if (neededPermission.getId().equals(permissionDTO.getId())) {
					return true;
				}
			}
		}

		return false;
	}
}

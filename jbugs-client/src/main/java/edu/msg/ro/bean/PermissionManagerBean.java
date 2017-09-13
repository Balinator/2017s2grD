package edu.msg.ro.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.business.user.boundary.PermissionFacade;
import edu.msg.ro.business.user.boundary.RoleFacade;

@ManagedBean
@SessionScoped
public class PermissionManagerBean extends AbstractBean {

	@EJB
	private PermissionFacade permissionFacade;

	@EJB
	private RoleFacade roleFacade;

	public List<PermissionDTO> getAllPermissionss() {
		return permissionFacade.getAll();
	}

	public boolean isChackboxChacked(PermissionDTO permission, RoleDTO role) {
		return role.getPermissions().contains(permission);
	}

	public void permissionRoleChanged(ValueChangeEvent event, PermissionDTO permission, RoleDTO role)
			throws TechnicalExeption {
		Boolean newValue = (Boolean) event.getNewValue();
		Boolean oldValue = (Boolean) event.getOldValue();

		if (newValue == null || oldValue == null) {
			throw new TechnicalExeption();
		}

		if (!newValue.equals(oldValue)) {
			if (newValue) {
				role.getPermissions().add(permission);
				roleFacade.update(role);
			} else {
				role.getPermissions().remove(permission);
				roleFacade.update(role);
			}
		}
	}

}

package edu.msg.ro.bean;

import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.business.user.boundary.PermissionFacade;
import edu.msg.ro.business.user.boundary.RoleFacade;
import edu.msg.ro.business.user.dto.PermissionDTO;
import edu.msg.ro.business.user.dto.RoleDTO;

/**
 * 
 * @author laszll
 *
 */
@ManagedBean
@SessionScoped
public class PermissionManagerBean extends AbstractBean {

	@EJB
	private RoleFacade roleFacade;

	@EJB
	private PermissionFacade permissionFacade;

	private HashMap<Long, RoleDTO> allRoles;
	private HashMap<Long, PermissionDTO> allPermissions;

	public List<RoleDTO> getAllRoles() {
		return roleFacade.getAllRoles();
	}

	public List<PermissionDTO> getAllPermissions() {
		return permissionFacade.getAll();
	}

	public HashMap<Long, RoleDTO> getRoles() {
		if (allRoles == null) {
			allRoles = new HashMap<>();
			for (RoleDTO r : roleFacade.getAllRoles()) {
				allRoles.put(r.getId(), r);
			}
		}
		return allRoles;
	}

	public HashMap<Long, PermissionDTO> getPermissions() {
		if (allPermissions == null) {
			allPermissions = new HashMap<>();
			for (PermissionDTO r : permissionFacade.getAll()) {
				allPermissions.put(r.getId(), r);
			}
		}
		return allPermissions;
	}

	// public boolean isChackboxChacked(PermissionDTO permission, RoleDTO role)
	// {
	// // return role.getPermissions().contains(permission);
	// return false;
	// }

	// public void permissionRoleChangedListener(ValueChangeEvent event,
	// PermissionDTO permission, RoleDTO role)
	// throws TechnicalExeption {
	// Boolean newValue = (Boolean) event.getNewValue();
	// Boolean oldValue = (Boolean) event.getOldValue();
	//
	// if (newValue == null || oldValue == null) {
	// throw new TechnicalExeption();
	// }
	//
	// if (!newValue.equals(oldValue)) {
	// if (newValue) {
	// role.getPermissions().add(permission);
	// roleFacade.update(role);
	// } else {
	// role.getPermissions().remove(permission);
	// roleFacade.update(role);
	// }
	// }
	// }

	public boolean isChackboxChacked(PermissionDTO permission, RoleDTO role) {
		// return role.getPermissions().contains(permission);
		FacesContext context = FacesContext.getCurrentInstance();
		RoleDTO role1 = context.getApplication().evaluateExpressionGet(context, "#{role}", RoleDTO.class);
		PermissionDTO permission1 = context.getApplication().evaluateExpressionGet(context, "#{permission}",
				PermissionDTO.class);

		System.out.println(role + " " + permission);

		return role.getPermissions().contains(permission);
	}

	public void permissionRoleChangedListener(ValueChangeEvent event) throws TechnicalExeption {
		FacesContext context = FacesContext.getCurrentInstance();
		Object role = context.getApplication().evaluateExpressionGet(context, "#{role}", Long.class);
		Object permission = context.getApplication().evaluateExpressionGet(context, "#{permission}", Long.class);

		// Map<String, String> params =
		// FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		// String permission = params.get("permissionId");
		// String role = params.get("roleId");

		System.out.println(role + " " + permission);
	}

}

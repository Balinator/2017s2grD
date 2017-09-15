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

	private Long[] checkboxMap;

	public Long[] getCheckboxMap() {
		return checkboxMap;
	}

	public void setCheckboxMap(Long[] checkboxMap) {
		this.checkboxMap = checkboxMap;
	}

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

	public Long[] isChackboxChacked(RoleDTO role) {
		Long[] list = new Long[role.getPermissions().size()];
		for (int i = 0; i < role.getPermissions().size(); ++i) {
			list[i] = role.getPermissions().get(i).getId();
		}
		return list;
	}

	public void permissionRoleChangedListener(ValueChangeEvent event) throws TechnicalExeption {
		FacesContext context = FacesContext.getCurrentInstance();
		/*
		 * RoleDTO role0 =
		 * context.getApplication().evaluateExpressionGet(context, "#{role0}",
		 * RoleDTO.class); RoleDTO role1 =
		 * context.getApplication().evaluateExpressionGet(context, "#{role1}",
		 * RoleDTO.class); RoleDTO role2 =
		 * context.getApplication().evaluateExpressionGet(context, "#{role2}",
		 * RoleDTO.class); RoleDTO role3 =
		 * context.getApplication().evaluateExpressionGet(context, "#{role3}",
		 * RoleDTO.class); RoleDTO role4 =
		 * context.getApplication().evaluateExpressionGet(context, "#{role4}",
		 * RoleDTO.class);
		 * 
		 * RoleDTO role = null; if (role0 != null) { role = role0; } else if
		 * (role1 != null) { role = role1; } else if (role2 != null) { role =
		 * role2; } else if (role3 != null) { role = role3; } else if (role4 !=
		 * null) { role = role4; }
		 */

		System.out.println(role);
	}

}

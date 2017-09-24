package edu.msg.ro.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;

import edu.msg.ro.business.common.exception.TechnicalException;
import edu.msg.ro.business.user.boundary.PermissionFacade;
import edu.msg.ro.business.user.boundary.RoleFacade;
import edu.msg.ro.business.user.dto.PermissionDTO;
import edu.msg.ro.business.user.dto.RoleDTO;
import edu.msg.ro.persistence.user.entity.Permission;
import edu.msg.ro.persistence.user.entity.Role;

/**
 * 
 * @author laszll
 *
 */
@ManagedBean
@RequestScoped
public class PermissionManagerBean extends AbstractBean {

	private static final String SUCESSFUL_UPDATE = "permissionManager.successfulupdate";

	@EJB
	private RoleFacade roleFacade;

	@EJB
	private PermissionFacade permissionFacade;

	private HashMap<Long, RoleDTO> allRoles;
	private HashMap<Long, PermissionDTO> allPermissions;

	private Long[] checkboxMap;

	/**
	 * Get for checkboxMap
	 * 
	 * @return
	 */
	public Long[] getCheckboxMap() {
		return checkboxMap;
	}

	/**
	 * Set for checkboxMap.
	 * 
	 * @param checkboxMap
	 */
	public void setCheckboxMap(Long[] checkboxMap) {
		this.checkboxMap = checkboxMap;
	}

	/**
	 * Method for get all {@link Role}s.
	 * 
	 * @return
	 */
	public List<RoleDTO> getAllRoles() {
		return roleFacade.getAllRoles();
	}

	/**
	 * Method for get all {@link Permission}s.
	 * 
	 * @return
	 */
	public List<PermissionDTO> getAllPermissions() {
		return permissionFacade.getAll();
	}

	/**
	 * Get for allRoles.
	 * 
	 * @return
	 */
	public HashMap<Long, RoleDTO> getRoles() {
		if (allRoles == null) {
			allRoles = new HashMap<>();
			for (RoleDTO r : roleFacade.getAllRoles()) {
				allRoles.put(r.getId(), r);
			}
		}
		return allRoles;
	}

	/**
	 * Get for allPermissions.
	 * 
	 * @return
	 */
	public HashMap<Long, PermissionDTO> getPermissions() {
		if (allPermissions == null) {
			allPermissions = new HashMap<>();
			for (PermissionDTO r : permissionFacade.getAll()) {
				allPermissions.put(r.getId(), r);
			}
		}
		return allPermissions;
	}

	/**
	 * Method for checking if checkbox needed to be checked.
	 * 
	 * @param role
	 * @return
	 */
	public Long[] isCheckboxChecked(RoleDTO role) {
		Long[] list = new Long[role.getPermissions().size()];
		for (int i = 0; i < role.getPermissions().size(); ++i) {
			list[i] = role.getPermissions().get(i).getId();
		}
		return list;
	}

	/**
	 * Listener method for checkbox has changed its value.
	 * 
	 * @param event
	 * @param role
	 * @throws TechnicalException
	 */
	public void permissionRoleChangedListener(ValueChangeEvent event, RoleDTO role) throws TechnicalException {
		String[] newValueString = (String[]) event.getNewValue();
		Long[] newValue = new Long[newValueString.length];
		Long[] oldValue = (Long[]) event.getOldValue();

		for (int i = 0; i < newValue.length; ++i) {
			newValue[i] = Long.valueOf(newValueString[i]);
		}

		if (oldValue == null) {
			throw new TechnicalException();
		}

		List<PermissionDTO> newPermissions = new ArrayList<>();

		List<PermissionDTO> all = getAllPermissions();

		for (Long l : newValue) {
			for (PermissionDTO p : all) {
				if (l.equals(p.getId())) {
					newPermissions.add(p);
					break;
				}
			}
		}

		role.setPermission(newPermissions);
		roleFacade.update(role);
		addI18nMessage(SUCESSFUL_UPDATE);
	}

	/**
	 * Listener helper for 1 row.
	 * 
	 * @param event
	 * @throws TechnicalException
	 */
	public void permissionRoleChangedListener0(ValueChangeEvent event) throws TechnicalException {
		permissionRoleChangedListener(event, getAllRoles().get(0));
	}

	/**
	 * Listener helper for 2 rows.
	 * 
	 * @param event
	 * @throws TechnicalException
	 */
	public void permissionRoleChangedListener1(ValueChangeEvent event) throws TechnicalException {
		permissionRoleChangedListener(event, getAllRoles().get(1));
	}

	/**
	 * Listener helper for 3 rows.
	 * 
	 * @param event
	 * @throws TechnicalException
	 */
	public void permissionRoleChangedListener2(ValueChangeEvent event) throws TechnicalException {
		permissionRoleChangedListener(event, getAllRoles().get(2));
	}

	/**
	 * Listener helper for 4 rows.
	 * 
	 * @param event
	 * @throws TechnicalException
	 */
	public void permissionRoleChangedListener3(ValueChangeEvent event) throws TechnicalException {
		permissionRoleChangedListener(event, getAllRoles().get(3));
	}

	/**
	 * Listener helper for 5 rows.
	 * 
	 * @param event
	 * @throws TechnicalException
	 */
	public void permissionRoleChangedListener4(ValueChangeEvent event) throws TechnicalException {
		permissionRoleChangedListener(event, getAllRoles().get(4));
	}

}

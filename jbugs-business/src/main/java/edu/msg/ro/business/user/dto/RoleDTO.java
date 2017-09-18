package edu.msg.ro.business.user.dto;

import java.io.Serializable;
import java.util.List;

import edu.msg.ro.business.common.dto.AbstractDTO;

public class RoleDTO extends AbstractDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2888638090462609294L;

	private List<PermissionDTO> permission;

	private String name;

	/**
	 * Getter for name.
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for name.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for permissions.
	 * 
	 * @return
	 */
	public List<PermissionDTO> getPermissions() {
		return permission;
	}

	/**
	 * Setter for permissions.
	 * 
	 * @param permission
	 */
	public void setPermission(List<PermissionDTO> permission) {
		this.permission = permission;
	}

	/**
	 * ToString for {@link RoleDTO}.
	 */
	@Override
	public String toString() {
		return "RoleDTO [getId()=" + getId() + ", permission=" + permission + "]";
	}

}

package edu.msg.ro.business.user.dto;

import java.util.List;

import edu.msg.ro.business.common.dto.AbstractDTO;

public class RoleDTO extends AbstractDTO {

	private List<PermissionDTO> permission;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PermissionDTO> getPermission() {
		return permission;
	}

	public void setPermission(List<PermissionDTO> permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "RoleDTO [getId()=" + getId() + ", permission=" + permission + "]";
	}

}

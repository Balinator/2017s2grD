package edu.msg.ro.business.user.dto;

import java.util.List;

import edu.msg.ro.business.common.dto.AbstractDTO;
import edu.msg.ro.persistence.user.entity.Permission;

/**
 * DTO for {@link Permission} for update
 * 
 * @author varadp
 *
 */
public class PermissionDTO extends AbstractDTO {

	private String name;

	private List<RoleDTO> role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RoleDTO> getRole() {
		return role;
	}

	public void setRole(List<RoleDTO> role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "PermissionDTO [getId()=" + getId() + ", role=" + role + "]";
	}

}

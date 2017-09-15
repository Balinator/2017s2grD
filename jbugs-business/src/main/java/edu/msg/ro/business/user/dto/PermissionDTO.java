package edu.msg.ro.business.user.dto;

import java.io.Serializable;
import java.util.List;

import edu.msg.ro.business.common.dto.AbstractDTO;
import edu.msg.ro.persistence.user.entity.Permission;

/**
 * DTO for {@link Permission} for update
 * 
 * @author varadp
 *
 */
public class PermissionDTO extends AbstractDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8505326630336446137L;

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PermissionDTO other = (PermissionDTO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

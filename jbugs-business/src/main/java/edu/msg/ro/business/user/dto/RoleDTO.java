package edu.msg.ro.business.user.dto;

import edu.msg.ro.business.common.dto.AbstractDTO;

/**
 * 
 * DTO for {@link Role} entity.
 * 
 * @author balinc
 *
 */
public class RoleDTO extends AbstractDTO {
	private String name_EN;

	private String name_RO;

	public String getName_EN() {
		return name_EN;
	}

	public void setName_EN(String name_EN) {
		this.name_EN = name_EN;
	}

	public String getName_RO() {
		return name_RO;
	}

	public void setName_RO(String name_RO) {
		this.name_RO = name_RO;
	}

	@Override
	public String toString() {
		return "RoleDTO [name_EN=" + name_EN + "]";
	}

}

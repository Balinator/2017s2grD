package edu.msg.ro.business.user.dto;

import edu.msg.ro.business.common.dto.AbstractDTO;

/**
 * DTO for {@link Role} entity.
 * 
 * @author laszll
 *
 */
public class RoleDTO extends AbstractDTO {
	private String nameRO;
	private String nameEN;

	public String getNameRO() {
		return nameRO;
	}

	public void setNameRO(String nameRO) {
		this.nameRO = nameRO;
	}

	public String getNameEN() {
		return nameEN;
	}

	public void setNameEN(String nameEN) {
		this.nameEN = nameEN;
	}

	@Override
	public String toString() {
		return "RoleDTO [nameEN=" + nameEN + "]";
	}

}

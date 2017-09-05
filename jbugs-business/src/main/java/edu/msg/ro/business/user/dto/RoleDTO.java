package edu.msg.ro.business.user.dto;

import edu.msg.ro.business.common.dto.AbstractDTO;

/**
 * DTO for {@link Role} entity.
 * 
 * @author fulops
 *
 */

public class RoleDTO extends AbstractDTO {

	private String nameEng;

	private String nameRo;

	public String getNameEng() {
		return nameEng;
	}

	public void setNameEng(String nameEng) {
		this.nameEng = nameEng;
	}

	public String getNameRo() {
		return nameRo;
	}

	public void setNameRo(String nameRo) {
		this.nameRo = nameRo;
	}

	@Override
	public String toString() {
		return "RoleDTO [nameEng=" + nameEng + ", nameRo=" + nameRo + "]";
	}

}

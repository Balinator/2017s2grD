package edu.msg.ro.business.user.dto;

import edu.msg.ro.business.common.dto.AbstractDTO;

/**
 * DTO for {@link Role} entity.
 * 
 * @author nemeta
 *
 */
public class RoleDTO extends AbstractDTO {
	private Long id;

	private String nameRo;
	private String nameEng;

	public String getNameRo() {
		return nameRo;
	}

	public void setNameRo(String nameRo) {
		this.nameRo = nameRo;
	}

	public String getNameEng() {
		return nameEng;
	}

	public void setNameEng(String nameEng) {
		this.nameEng = nameEng;
	}

	@Override
	public String toString() {
		return "RoleDTO [id=" + getId() + ", nameRo=" + nameRo + ", nameEng=" + nameEng + "]";
	}

}

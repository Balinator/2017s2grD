package edu.msg.ro.persistence.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Entity for the Roles
 * 
 * @author nemeta
 *
 */
@NamedQuery(name = Role.FIND_ROLES, query = "SELECT r from Role r")
@Entity
public class Role extends AbstractEntity {

	public static final String FIND_ROLES = "Role.findRoles";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nameRo;
	@Column
	private String nameEng;

	@Override
	public Long getId() {
		return id;
	}

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

}

package edu.msg.ro.persistence.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Entity for the Role.
 * 
 * @author nagya
 *
 */
@NamedQuery(name = Role.FIND_ROLE, query = "SELECT r from Role r WHERE r.id = :id")
@Entity
public class Role extends AbstractEntity {

	public static final String FIND_ROLE = "Role.findRole";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nameEng;

	@Column
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

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {

		return id;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", nameEng=" + nameEng + ", nameRo=" + nameRo + "]";
	}

}

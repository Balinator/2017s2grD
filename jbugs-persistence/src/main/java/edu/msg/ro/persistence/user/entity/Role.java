package edu.msg.ro.persistence.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Entity for Role.
 * 
 * @author laszll
 *
 */
@NamedQueries(value = { @NamedQuery(name = Role.FIND_ALL_ROLE, query = "SELECT r from Role r"),
		@NamedQuery(name = Role.FIND_ROLE_BY_NAME_EN, query = "SELECT r from Role r WHERE r.nameEN = :nameEN") })
@Entity
public class Role extends AbstractEntity {

	public static final String FIND_ALL_ROLE = "Role.findAll";
	public static final String FIND_ROLE_BY_NAME_EN = "Role.findByNameEN";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nameRO;
	@Column
	private String nameEN;

	@Override
	public Long getId() {
		return id;
	}

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
		return "Role [id=" + id + ", nameEN=" + nameEN + "]";
	}

}
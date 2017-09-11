package edu.msg.ro.persistence.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * 
 * Entity for Role.
 * 
 * @author balinc
 *
 */
@NamedQuery(name = Role.FIND_All_ROLES, query = "SELECT r from Role r")
@Entity
public class Role extends AbstractEntity {

	public static final String FIND_All_ROLES = "Role.findAll";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name_EN;

	private String name_RO;

	@Override
	public Long getId() {
		return id;
	}

	public String getName_EN() {
		return name_EN;
	}

	public void setName_EN(String name) {
		this.name_EN = name;
	}

	public String getName_RO() {
		return name_RO;
	}

	public void setName_RO(String name) {
		this.name_RO = name;
	}

	@Override
	public String toString() {
		return "Role [name_EN=" + name_EN + "]";
	}
}

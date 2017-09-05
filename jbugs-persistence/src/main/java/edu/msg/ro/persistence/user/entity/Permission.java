package edu.msg.ro.persistence.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Entity for Permission.
 * 
 * @author laszll
 *
 */
@NamedQueries(value = { @NamedQuery(name = Permission.FIND_ALL_PERMISSION, query = "SELECT p from Permission p") })
@Entity
public class Permission extends AbstractEntity {

	public static final String FIND_ALL_PERMISSION = "Permission.findAll";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String details;

	@Override
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Permission [id=" + id + ", name=" + name + "]";
	}

}

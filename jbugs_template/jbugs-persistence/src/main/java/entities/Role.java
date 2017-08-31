package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

/**
 * Entity implementation class for Entity: Role
 *
 */
@Entity
@NamedQuery(name = "Role.findAll", query = "select r from Role AS r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_role")
	private int idRole;
	@Column(name = "role_name", unique = true)
	private String roleName;
	@ManyToMany(mappedBy = "roles")
	private List<User> users = new ArrayList<User>();
	@ManyToMany(mappedBy = "roles")
	private List<Permission> permissions = new ArrayList<>();

	public Role() {
		super();
	}

	public Role(String mRoleName) {
		super();
		this.roleName = mRoleName;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int mIdRole) {
		this.idRole = mIdRole;
	}

	public String getName() {
		return roleName;
	}

	public void setName(String mRoleName) {
		this.roleName = mRoleName;
	}

	public List<User> getUsers() {
		return users;
	}

}

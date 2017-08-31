package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

/**
 * Entity implementation class for Entity: Permission
 *
 */
@Entity
@NamedQuery(name = "Permission.findAll",query = "select p from Permission AS p")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_permission")
	private int idPermission;
	@Column(name = "permission_name")
	private String permissionName;
	@Column(name = "details")
	private String details;
	@ManyToMany
	@JoinTable(name = "permission_role", joinColumns = @JoinColumn(name = "id_permission"), inverseJoinColumns = {
			@JoinColumn(name = "id_role") })
	private List<Role> roles = new ArrayList<>();
	
	public Permission() {
		super();
	}

	public Permission(String permissionName, String details) {
		super();
		this.permissionName = permissionName;
		this.details = details;
	}

	public int getIdPermission() {
		return idPermission;
	}

	public void setIdPermission(int idPermission) {
		this.idPermission = idPermission;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
   
}

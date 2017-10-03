package edu.msg.ro.business.user.dto;

import java.io.Serializable;
import java.util.List;

import edu.msg.ro.business.common.dto.AbstractDTO;
import edu.msg.ro.persistence.user.entity.User;

/**
 * DTO for {@link User} entity.
 * 
 * @author balinc
 *
 */
public class UserDTO extends AbstractDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1202580493348283198L;

	private String firstname;

	private String lastname;

	private String email;

	private String username;

	private String password;

	private String phoneNumber;

	private boolean active;

	private List<RoleDTO> roles;

	/**
	 * Get for firstname.
	 * 
	 * @return
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Set for firstname.
	 * 
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Get for lastname.
	 * 
	 * @return
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Set for lastname.
	 * 
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Get for email.
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set for email.
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get for username.
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Set for username.
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Get for password.
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set for password.
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get for PhoneNumber.
	 * 
	 * @return
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Set for Phonenumber.
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * get for active.
	 * 
	 * @return
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Set for active.
	 * 
	 * @param active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * ToString for {@link UserDTO}.
	 */
	@Override
	public String toString() {
		return "UserDTO [id=" + getId() + ", username=" + username + "]";
	}

	/**
	 * get for roles.
	 * 
	 * @return
	 */
	public List<RoleDTO> getRoles() {
		return roles;
	}

	/**
	 * Set for roles.
	 * 
	 * @param roles
	 */
	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;

		Long id = getId();
		Long otherId = other.getId();

		if (id == null) {
			if (otherId != null)
				return false;
		} else if (!id.equals(otherId))
			return false;
		return true;
	}

}

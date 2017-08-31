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
 * Entity implementation class for Entity: User
 *
 */
@Entity
@NamedQuery(name = "User.findAll",query = "select u from User AS u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int idUser;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "username", length = 6, unique = true)
	private String username;
	@Column(name = "email")
	private String email;
	@Column(name = "phone_number", length = 14)
	private String phoneNumber;
	@Column(name = "password")
	private String password;
	@Column(name = "status")
	private boolean status;
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = {
			@JoinColumn(name = "id_role") })
	private List<Role> roles = new ArrayList<Role>();

	public User() {
		super();
	}

	public User(String mFirstName, String mLastName, String mUsername, String mEmail, String mPhoneNumber,
			String mPassword, boolean mStatus) {
		super();
		this.firstName = mFirstName;
		this.lastName = mLastName;
		this.username = mUsername;
		this.email = mEmail;
		this.phoneNumber = mPhoneNumber;
		this.password = mPassword;
		this.status = mStatus;
	}


	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int mIdUser) {
		this.idUser = mIdUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String mFirstName) {
		this.firstName = mFirstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String mLastName) {
		this.lastName = mLastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String mEmail) {
		this.email = mEmail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String mPhoneNumber) {
		this.phoneNumber = mPhoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String mPassword) {
		this.password = mPassword;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean mStatus) {
		this.status = mStatus;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String mUsername) {
		this.username = mUsername;
	}

	public List<Role> getRoles() {
		return roles;
	}

}

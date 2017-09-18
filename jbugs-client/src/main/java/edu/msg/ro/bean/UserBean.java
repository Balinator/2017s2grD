package edu.msg.ro.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.common.exception.JBugsExeption;
import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.business.user.boundary.UserFacade;
import edu.msg.ro.business.user.dto.RoleDTO;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.persistence.user.entity.User;

/**
 * Bean for managing {@link User}s.
 * 
 * @author laszll
 *
 */
@ManagedBean
@RequestScoped
public class UserBean extends AbstractBean {

	@EJB
	UserFacade userFacade;

	private UserDTO newUser = new UserDTO();

	private UserDTO selectedUser = new UserDTO();

	private List<RoleDTO> roles;

	private List<RoleDTO> selectedRoles;

	@ManagedProperty("#{roleService}")
	private roleService service;

	/**
	 * Get for newUser.
	 * 
	 * @return
	 */
	public UserDTO getNewUser() {
		return newUser;
	}

	/**
	 * Set for newUser.
	 * 
	 * @param user
	 */
	public void setNewUser(UserDTO user) {
		this.newUser = user;
	}

	/**
	 * get for selectedUser.
	 * 
	 * @return
	 */
	public UserDTO getSelectedUser() {
		return selectedUser;
	}

	/**
	 * Set for selectedUser.
	 * 
	 * @param selectedUser
	 */
	public void setSelectedUser(UserDTO selectedUser) {

		this.selectedUser = selectedUser;
	}

	/**
	 * Method for get all {@link User}s.
	 * 
	 * @return
	 */
	public List<UserDTO> getAllUsers() {
		return userFacade.getAllUsers();
	}

	/**
	 * Method for autocomplete.
	 * 
	 * @param query
	 * @return
	 */
	public List<UserDTO> complete(String query) {
		return userFacade.getAllUserByQuery(query);
	}

	/**
	 * Method for get all usesrnaem for autocomplete.
	 * 
	 * @param usernameQuery
	 * @return
	 */
	public List<String> getAllUserByUsernameQuery(String usernameQuery) {
		List<String> username = new ArrayList<String>();
		List<UserDTO> uDTO = userFacade.getAllUserByQuery(usernameQuery);
		for (UserDTO userDTO : uDTO) {
			username.add(userDTO.getUsername());
		}
		return username;
	}

	/**
	 * Method for creating new {@link User}.
	 * 
	 * @return
	 */
	public String createNewUser() {
		try {
			userFacade.createUser(newUser);
			addMessage("Userul " + newUser.getFirstname() + " a fost creat!");
			newUser = new UserDTO();
		} catch (BusinessException e) {
			Object[] messageArguments = { newUser.toString() };
			addI18nMessage(e.getMessage(), messageArguments);
		}
		return "users";
	}

	/**
	 * Method for deleting(deactivating) {@link User}.
	 * 
	 * @param user
	 * @return
	 */
	public String deleteUser(UserDTO user) {
		try {
			userFacade.deleteUser(user);
			addMessage("Userul " + newUser.getFirstname() + " a fost sters!");
		} catch (JBugsExeption e) {
			handleExeptionI18n(e);
		}
		return "users";
	}

	/**
	 * Method for enter update mode.
	 * 
	 * @param user
	 * @return
	 */
	public String enterUpdateMode(UserDTO user) {
		this.selectedUser = user;
		return "users";
	}

	/**
	 * Method for leaving update mode.
	 * 
	 * @return
	 */
	public String leaveUpdateMode() {
		selectedUser = new UserDTO();
		return "users";
	}

	/**
	 * Method for verifying if element needed to render.
	 * 
	 * @param user
	 * @return
	 */
	public boolean verifyUserRendere(UserDTO user) {
		return selectedUser != null && user.getId().equals(selectedUser.getId());
	}

	/**
	 * Method for editing user.
	 * 
	 * @return
	 * @throws TechnicalExeption
	 */
	public String editUser() throws TechnicalExeption {
		try {
			userFacade.updateUser(selectedUser);
		} catch (JBugsExeption e) {
			handleExeptionI18n(e);
		}
		selectedUser = new UserDTO();
		return "users";
	}

	/**
	 * Init function.
	 */
	@PostConstruct
	public void init() {
		roles = service.getRoles();
	}

	/**
	 * Get for roles.
	 * 
	 * @return
	 */
	public List<RoleDTO> getRoles() {
		return roles;
	}

	/**
	 * Set for roles.
	 * 
	 * @param service
	 */
	public void setService(roleService service) {
		this.service = service;
	}
}

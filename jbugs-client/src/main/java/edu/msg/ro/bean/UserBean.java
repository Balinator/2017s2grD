package edu.msg.ro.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.common.exception.JBugsExeption;
import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.business.user.boundary.UserFacade;
import edu.msg.ro.business.user.dto.UserDTO;

@ManagedBean
@RequestScoped
public class UserBean extends AbstractBean {

	@EJB
	UserFacade userFacade;

	private UserDTO newUser = new UserDTO();

	private UserDTO selectedUser = new UserDTO();

	public List<UserDTO> complete(String query) {

		return userFacade.getAllUserByQuery(query);
	}

	public UserDTO getNewUser() {
		return newUser;
	}

	public void setNewUser(UserDTO user) {
		this.newUser = user;
	}

	public UserDTO getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UserDTO selectedUser) {

		this.selectedUser = selectedUser;
	}

	public List<UserDTO> getAllUsers() {
		return userFacade.getAllUsers();
	}

	// /**
	// * Needed for bug create assigment.
	// *
	// * @return
	// */
	// public List<String> getAllUsersByUsername() {
	// List<String> username = new ArrayList<String>();
	// List<UserDTO> uDTO = userFacade.getAllUsers();
	// for (UserDTO userDTO : uDTO) {
	// username.add(userDTO.getUsername());
	// }
	// return username;
	// }

	public List<String> getAllUserByUsernameQuery(String usernameQuery) {
		List<String> username = new ArrayList<String>();
		List<UserDTO> uDTO = userFacade.getAllUserByQuery(usernameQuery);
		for (UserDTO userDTO : uDTO) {
			username.add(userDTO.getUsername());
		}
		return username;
	}

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

	public String deleteUser(UserDTO user) {
		try {
			userFacade.deleteUser(user);
			addMessage("Userul " + newUser.getFirstname() + " a fost sters!");
		} catch (JBugsExeption e) {
			handleExeptionI18n(e);
		}
		return "users";
	}

	public String enterUpdateMode(UserDTO user) {
		this.selectedUser = user;
		return "users";
	}

	public String leaveUpdateMode() {
		selectedUser = new UserDTO();
		return "users";
	}

	public boolean verifyUserRendere(UserDTO user) {
		return selectedUser != null && user.getId().equals(selectedUser.getId());
	}

	public String editUser() throws TechnicalExeption {
		try {
			userFacade.updateUser(selectedUser);
		} catch (JBugsExeption e) {
			handleExeptionI18n(e);
		}
		selectedUser = new UserDTO();
		return "users";
	}

}

package edu.msg.ro.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.common.exception.JBugsException;
import edu.msg.ro.business.user.boundary.UserFacade;
import edu.msg.ro.business.user.dto.UserDTO;

@ManagedBean
@SessionScoped
public class UserBean extends AbstractBean {
	@EJB
	UserFacade userFacade;

	private UserDTO selectedUser = new UserDTO();

	private UserDTO newUser = new UserDTO();

	/**
	 * @return the user
	 */
	public UserDTO getNewUser() {
		return newUser;
	}

	/**
	 * @param user
	 *            the user to set
	 */

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

	public String createNewUser() throws BusinessException {
		userFacade.createUser(newUser);
		addMessage("Userul " + newUser.getFirstname() + " a fost creat!");
		newUser = new UserDTO();
		return "users";
	}

	public String deleteUser(UserDTO user) {
		try {
			userFacade.deleteUser(user);
			addMessage("Userul " + newUser.getFirstname() + " a fost sters!");
		} catch (JBugsException e) {
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

	public boolean verifyUserRendered(UserDTO user) {

		return selectedUser != null && user.getId().equals(selectedUser.getId());
	}

	public String editUser() {
		try {
			userFacade.updateUser(selectedUser);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		selectedUser = new UserDTO();
		return "users";
	}
}
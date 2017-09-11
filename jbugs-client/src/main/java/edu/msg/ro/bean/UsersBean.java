/**
 * 
 */
package edu.msg.ro.bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.boundary.UserFacade;
import edu.msg.ro.business.user.dto.UserDTO;

/**
 * @author Mihaly Fodor
 */
@ManagedBean
@SessionScoped
public class UsersBean implements Serializable {

	private static final long serialVersionUID = 4860933911207569401L;

	@EJB
	private UserFacade userFacade;

	private UserDTO editedUserDTO;
	private UserDTO newUserDTO = new UserDTO();
	private UserDTO selectedDTO = new UserDTO();

	public UserDTO getNewUserDTO() {
		return newUserDTO;
	}

	public void setNewUserDTO(UserDTO newUserDTO) {
		this.newUserDTO = newUserDTO;
	}

	public String doSaveEditedUser() {
		System.err.println("Editing the User " + editedUserDTO);
		editedUserDTO = null;
		return "users";
	}

	public List<UserDTO> getAllUsers() {
		return userFacade.findAllUser();
	}

	public String createNewUser() {
		try {
			userFacade.createUser(newUserDTO);
			addMessage("New user inserted!", newUserDTO.getUsername());
			newUserDTO = new UserDTO();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return "users";
	}

	public String deleteUser(UserDTO userDTO) {
		userFacade.deleteUser(userDTO);
		addMessage("User deleted!", newUserDTO.getUsername());
		return "users";
	}

	public String selectUser(UserDTO userDTO) {
		selectedDTO = userDTO;
		addMessage("User selected!", selectedDTO.toString());
		return "users";
	}

	public String abortUser() {
		if (selectedDTO.getId() == null) {
			return "users";
		}
		addMessage("User update aborted!", "");
		selectedDTO = new UserDTO();
		return "users";
	}

	public String updateUser() {
		if (selectedDTO.getId() == null) {
			addMessage("User update falied!", "No selected user!");
			return "users";
		}
		userFacade.updateUser(selectedDTO);
		addMessage("User updated!", selectedDTO.toString());
		selectedDTO = new UserDTO();
		return "users";
	}

	public void destroyWorld() {
		addMessage("System Error", "Please try again later.");
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public UserDTO getEditedUserDTO() {
		return editedUserDTO;
	}

	public void setEditedUserDTO(UserDTO editedUserDTO) {
		this.editedUserDTO = editedUserDTO;
	}

	public UserDTO getSelectedDTO() {
		return selectedDTO;
	}

	public void setSelectedDTO(UserDTO selectedDTO) {
		this.selectedDTO = selectedDTO;
	}

}

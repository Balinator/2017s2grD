package edu.msg.ro.bean.user;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.persistence.user.entity.User;

@ManagedBean
@RequestScoped
public class UserListBean extends AbstractUserBean {

	private UserDTO userDTO = new UserDTO();

	/**
	 * Method for verifying if element needed to render.
	 * 
	 * @param user
	 * @return
	 */
	public boolean verifyUserRendere(UserDTO user) {
		return userDTO != null && user.getId().equals(userDTO.getId());
	}

	/**
	 * get for User.
	 * 
	 * @return
	 */
	public UserDTO geUser() {
		return userDTO;
	}

	/**
	 * Method for get all {@link User}s.
	 * 
	 * @return
	 */
	public List<UserDTO> getAllUsers() {
		return userFacade.getAllUsers();
	}

}

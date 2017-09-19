package edu.msg.ro.bean.user;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.persistence.user.entity.User;

/**
 * Add new {@link User} bean.
 * 
 * @author balinc
 *
 */
@ManagedBean
@RequestScoped
public class UserNewBean extends AbstractUserBean {

	private UserDTO newUser = new UserDTO();

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
	public void clearUser() {
		this.newUser = new UserDTO();
		rebuildRoleService();
	}

	/**
	 * Method for creating new {@link User}.
	 * 
	 * @return
	 */
	public void createNewUser() {
		try {
			userFacade.createUser(newUser);
			Object[] messageArguments = { newUser.getUsername() };
			addI18nMessage("user.crud.save.success", messageArguments);
			clearUser();
		} catch (BusinessException e) {
			Object[] messageArguments = { newUser.toString() };
			addI18nMessage(e.getMessage(), messageArguments);
		}
	}
}

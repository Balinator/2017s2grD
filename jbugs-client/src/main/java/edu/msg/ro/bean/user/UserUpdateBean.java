package edu.msg.ro.bean.user;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.msg.ro.business.common.exception.JBugsExeption;
import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.persistence.user.entity.User;

/**
 * Update {@link User} bean.
 * 
 * @author balinc
 *
 */
@ManagedBean
@ViewScoped
public class UserUpdateBean extends AbstractUserBean {

	/**
	 * {@link UserDTO}
	 */
	private UserDTO updatedUser = new UserDTO();

	/**
	 * Get user to update.
	 *
	 * @return
	 */
	public UserDTO getUpdatedUser() {
		return updatedUser;
	}

	/**
	 * Set user update.
	 * 
	 * @param userDTO
	 */
	public void setUpdatedUser(UserDTO userDTO) {
		rebuildRoleService();
		this.updatedUser = userDTO;
	}

	/**
	 * Method for saving edited {@link User}.
	 * 
	 * @return
	 * @throws TechnicalExeption
	 */
	public void editUser() {
		try {
			userFacade.updateUser(updatedUser);
			addI18nMessage(I18N_SAVED, new Object[] { updatedUser.getUsername() });
			rebuildRoleService();
		} catch (JBugsExeption e) {
			handleExeptionI18n(e);
		}
	}

}
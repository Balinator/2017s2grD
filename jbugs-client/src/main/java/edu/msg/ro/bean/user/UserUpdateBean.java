package edu.msg.ro.bean.user;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.msg.ro.business.common.exception.JBugsExeption;
import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.business.user.dto.RoleDTO;
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

	private UserDTO updatedUser = new UserDTO();

	private List<RoleDTO> selectedRoles = new ArrayList<RoleDTO>();

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
		setSelectedRoles(userDTO.getRoles());
		this.updatedUser = userDTO;
	}

	/**
	 * Get selected roles for the current edited {@link User}
	 * 
	 * @return
	 */
	public List<RoleDTO> getSelectedRoles() {
		return selectedRoles;
	}

	/**
	 * Set selected roles for the current edited {@link User}
	 * 
	 * @param selectedRoles
	 */
	public void setSelectedRoles(List<RoleDTO> selectedRoles) {
		this.selectedRoles = selectedRoles;
	}

	/**
	 * Method for saving edited {@link User}.
	 * 
	 * @return
	 * @throws TechnicalExeption
	 */
	public void editUser() throws TechnicalExeption {
		try {
			userFacade.updateUser(updatedUser);
			Object[] messageArguments = { updatedUser.getUsername() };
			// @Todo: Check way is error with ViewScope Beans.
			// addI18nMessage("user.crud.update.success", messageArguments);
			rebuildRoleService();
		} catch (JBugsExeption e) {
			handleExeptionI18n(e);
		}
	}

}
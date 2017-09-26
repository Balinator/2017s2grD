package edu.msg.ro.bean.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.msg.ro.business.common.exception.BusinessException;
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

	private List<RoleDTO> selectedRoles;

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
		setSelectedRoles(userDTO.getRoles());
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

	/**
	 * Method for reseting the password
	 * 
	 * @throws TechnicalExeption
	 */
	public void resetPassword() throws BusinessException {
		try {
			userFacade.resetPassword(updatedUser);
			addI18nMessage(I18N_RESET);
		} catch (JBugsExeption e) {
			handleExeptionI18n(e);
		}
	}

	/**
	 * Return selected roles.
	 * 
	 * @return
	 */
	public List<RoleDTO> getSelectedRoles() {
		return selectedRoles;
	}

	/**
	 * Set the selected roles.
	 * 
	 * @param persistedRoles
	 */
	public void setSelectedRoles(List<RoleDTO> persistedRoles) {
		if (!persistedRoles.isEmpty()) {
			selectedRoles = new ArrayList<RoleDTO>();
			Map<Long, RoleDTO> mappedItems = service.getRoleItemMap();
			for (RoleDTO role : persistedRoles) {
				selectedRoles.add(mappedItems.get(role.getId()));
			}
			this.updatedUser.setRoles(selectedRoles);
		}
	}

}
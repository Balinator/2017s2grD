package edu.msg.ro.bean.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.msg.ro.business.common.exception.JBugsException;
import edu.msg.ro.business.common.exception.TechnicalException;
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
	 * @throws TechnicalException
	 */
	public void editUser() {
		try {
			userFacade.updateUser(updatedUser);
			addI18nMessage(I18N_SAVED, new Object[] { updatedUser.getUsername() });
			rebuildRoleService();
		} catch (JBugsException e) {
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
			List<RoleDTO> selectedRoles = new ArrayList<RoleDTO>();
			Map<Long, RoleDTO> mappedItems = service.getRoleItemMap();
			for (RoleDTO role : persistedRoles) {
				selectedRoles.add(mappedItems.get(role.getId()));
			}
			this.updatedUser.setRoles(selectedRoles);
			this.selectedRoles = selectedRoles;
		}
	}

}
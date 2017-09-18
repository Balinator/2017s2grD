package edu.msg.ro.business.user.security;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.user.dao.UserDAO;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.persistence.user.entity.Permission;
import edu.msg.ro.persistence.user.entity.Role;
import edu.msg.ro.persistence.user.entity.User;

/**
 * Checks if user has permission to perform specific task.
 * 
 * @author nemeta
 *
 */
@Stateless
public class PermissionChecker {
	@EJB
	UserDAO userDAO;

	/**
	 * Checks if user has permission to execute operation
	 * 
	 * @param userDTO
	 * @param permissionId
	 * @return boolean
	 */
	public boolean checkPermission(UserDTO userDTO, int permissionId) {
		String email = userDTO.getEmail();
		User user = userDAO.findUserByEmail(email);
		List<Role> roles = user.getRoles();
		for (Role role : roles) {
			for (Permission permission : role.getPermissions()) {
				if (permission.getId() == permissionId) {
					return true;
				}
			}
		}
		return false;
	}

}

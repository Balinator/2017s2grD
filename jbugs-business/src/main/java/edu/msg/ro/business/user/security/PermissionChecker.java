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
 * Checks if user has permission to perform specific task
 * 
 * @author nemeta
 *
 */
@Stateless
public class PermissionChecker {
	@EJB
	UserDAO userDAO;

	/*
	 * public boolean checkPermission(UserDTO userDTO, Permission permission) {
	 * String email = userDTO.getEmail(); User user = new User();
	 * 
	 * user = userDAO.findUserByEmail(email); List<Role> roles =
	 * user.getRoles(); for (Role role : roles) { for (Permission p :
	 * role.getPermissions()) { System.out.println("TEST:" + p.getName()); } }
	 * return false; }
	 */

	public void checkPermission(UserDTO userDTO) {
		String email = userDTO.getEmail();
		User user = new User();

		user = userDAO.findUserByEmail(email);
		List<Role> roles = user.getRoles();
		for (Role role : roles) {
			for (Permission p : role.getPermissions()) {
				System.out.println("TEST:" + p.getName());
			}
		}
	}
}

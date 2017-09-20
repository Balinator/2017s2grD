package edu.msg.ro.business.user.boundary;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.user.control.UserService;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.util.UserGenerator;

/**
 * Login facade class.
 *
 * @author balinc
 */
@Stateless
public class LoginFacade {

	@EJB
	private UserService userService;

	@EJB
	private UserGenerator userPass;

	/**
	 * Check if user exist.
	 * 
	 * @param userDTO
	 * @return {@link Boolean}
	 */
	public boolean isValidUser(UserDTO userDTO) {
		String passwordHash = userPass.encryptPassword(userDTO);
		return userService.findUserExists(userDTO.getUsername(), passwordHash);
	}
}
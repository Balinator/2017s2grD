package edu.msg.ro.business.user.boundary;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.user.control.UserService;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.util.UserGenerator;

/**
 * @author balinc
 */
@Stateless
public class LoginFacade {

	@EJB
	private UserService userService;

	@EJB
	private UserGenerator userPass;

	public boolean isValidUser(UserDTO userDTO) {
		String passwordHash = null;
		try {
			passwordHash = userPass.encryptPassword(userDTO);
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return userService.findUserExists(userDTO.getUsername(), passwordHash);
	}
}
package edu.msg.ro.business.user.boundary;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.common.exception.TechnicalExeption;
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
	 * @return
	 * @throws TechnicalExeption
	 */
	public boolean isValidUser(UserDTO userDTO) throws TechnicalExeption {
		String passwordHash = null;
		try {
			passwordHash = userPass.encryptPassword(userDTO);
			return userService.findUserExists(userDTO.getUsername(), passwordHash);
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException | TechnicalExeption e) {
			throw new TechnicalExeption();
		}
	}
}
package edu.msg.ro.business.user.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.business.user.dao.UserDAO;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.persistence.user.entity.User;

/**
 * 
 * @author nemeta
 * 
 *         Class for generating username and password for the user.
 */
@Stateless
public class UserGenerator {

	@EJB
	private UserDAO userDao;

	/**
	 * Creates the username
	 * 
	 * @param user
	 * @return
	 * @throws TechnicalExeption
	 */
	public String createUsername(UserDTO user) throws TechnicalExeption {

		String firstName = user.getFirstname();
		String lastName = user.getLastname();
		int lastNameLength = lastName.length();
		int firstNameLength = firstName.length();
		StringBuilder username = new StringBuilder();
		int firstNamePos = 1;

		username.append(lastName.substring(0, Math.min(lastNameLength, 5)));
		username.append(firstName.substring(0, firstNamePos));

		while (checkIfUsernameExists(username.toString()) == true && firstNameLength != 1) {
			username.append(firstName.substring(firstNamePos, firstNamePos + 1));
			firstNamePos++;
			firstNameLength--;
		}
		// TODO if after this it is still not unique create another generator
		// method

		return username.toString();
	}

	/**
	 * Checks if username is already taken.
	 * 
	 * @param username
	 * @return true/false
	 * @throws TechnicalExeption
	 */
	public boolean checkIfUsernameExists(String username) {
		User existingUser = new User();
		try {

			existingUser = userDao.findUserByUsername(username);
		} catch (TechnicalExeption e) {
			return false;
		}
		String existingUsername = existingUser.getUsername();
		if (existingUsername.equals(username)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Creates hash for user password.
	 * 
	 * @param userDTO
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public String encryptPassword(UserDTO userDTO) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] md_password = md.digest(userDTO.getPassword().getBytes("UTF-8"));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < md_password.length; i++) {
			sb.append(Integer.toString((md_password[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

}
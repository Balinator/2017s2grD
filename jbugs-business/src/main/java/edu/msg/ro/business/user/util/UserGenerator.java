package edu.msg.ro.business.user.util;

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
 *         Class for generating username for the user
 */
@Stateless
public class UsernameGenerator {

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
	 * Checks if username is already taken
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

}

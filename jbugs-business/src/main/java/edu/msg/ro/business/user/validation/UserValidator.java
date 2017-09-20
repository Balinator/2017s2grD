package edu.msg.ro.business.user.validation;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.dao.UserDAO;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.persistence.user.entity.User;

/**
 * Validate user.
 * 
 * @author balinc
 *
 */
@Stateless
public class UserValidator {

	@EJB
	private UserDAO userDAO;

	/**
	 * Check for active user tasks.
	 *
	 * @param entity
	 * @return
	 */
	public boolean checkIfUserHasActiveTasks(User user) {
		return userDAO.checkIfUserHasAssignedBugs(user);
	}

	/**
	 * Check if user with email already exist.
	 *
	 * @param email
	 * @return
	 * @throws BusinessException
	 */
	public void validateUserData(UserDTO user) throws BusinessException {
		User existingUserWithSameEmail = userDAO.findUserByEmail(user.getEmail());
		if (existingUserWithSameEmail != null) {
			throw new BusinessException("User already exists with given email " + user.getEmail());
		}
	}

	/**
	 * Check if user with email already exist.
	 *
	 * @param email
	 * @return
	 * @throws BusinessException
	 */
	public boolean validateEmail(String email) throws BusinessException {
		User existingUserWithSameEmail = userDAO.findUserByEmail(email);
		if (existingUserWithSameEmail != null) {
			throw new BusinessException("User already exists with given email " + email);
		}
		return true;
	}
}
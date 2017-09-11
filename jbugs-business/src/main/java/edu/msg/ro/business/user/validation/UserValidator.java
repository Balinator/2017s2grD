package edu.msg.ro.business.user.validation;

import javax.ejb.EJB;
import javax.enterprise.context.Dependent;

import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.dao.UserDAO;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.persistence.user.entity.User;

@Dependent
public class UserValidator {

	@EJB
	private UserDAO userDAO;

	public boolean checkIfUserHasActiveTasks(User entity) {
		// @TODO
		// get list of users bugs
		// if null return false
		// else check for every bug if status not equals CLOSED then return true
		return false;
	}

	public void validateUserData(UserDTO user) throws BusinessException {
		User existingUserWithSameEmail = userDAO.findUserByEmail(user.getEmail());
		if (existingUserWithSameEmail != null) {
			throw new BusinessException("User already exists with given email " + user.getEmail());
		}
	}

	public boolean validateEmail(String email) throws BusinessException {
		User existingUserWithSameEmail = userDAO.findUserByEmail(email);
		if (existingUserWithSameEmail != null) {
			throw new BusinessException("User already exists with given email " + email);
		}
		return true;
	}
}
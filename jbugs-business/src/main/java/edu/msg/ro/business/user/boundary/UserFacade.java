package edu.msg.ro.business.user.boundary;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.control.UserSomething;
import edu.msg.ro.business.user.dto.UserDTO;

/**
 * Boundary for user component.
 * 
 * @author floricea
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class UserFacade {

	@EJB
	private UserSomething userSomething;

	public UserDTO createUser(UserDTO user) throws BusinessException {
		return userSomething.createUser(user);
	}

	public UserDTO deleteUser(UserDTO userDTO) {
		return userSomething.deleteUser(userDTO);

	}

	public UserDTO updateUser(UserDTO userDTO) throws BusinessException {
		return userSomething.updateUser(userDTO);
	}

	public boolean verifyLoggedInUser(UserDTO user) {
		return userSomething.verifyUserExists(user);

	}

	public List<UserDTO> getAllUsers() {
		return userSomething.getAll();
	}

}
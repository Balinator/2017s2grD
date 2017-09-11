package edu.msg.ro.business.user.boundary;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.control.UserService;
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
	private UserService userService;

	public UserDTO createUser(UserDTO user) throws BusinessException {
		return userService.createUser(user);
	}

	public UserDTO deleteUser(UserDTO userDTO) {
		return userService.deleteUser(userDTO);

	}

	public List<UserDTO> getAllUsers() {
		return userService.getAllUsers();
	}
}

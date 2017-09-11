package edu.msg.ro.business.user.boundary;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.control.UserService;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.persistence.user.entity.User;

/**
 * Boundary for {@link User} component.
 * 
 * @author floricea
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class UserFacade {

	@EJB
	private UserService userSomething;

	public UserDTO createUser(UserDTO user) throws BusinessException {
		return userSomething.createUser(user);
	}

	public boolean verifiedLoggedInUser(UserDTO userDTO) {
		return userSomething.findUserToLogin(userDTO.getUsername(), userDTO.getPassword()) != null;
	}

	public List<UserDTO> findAllUser() {
		return userSomething.findAllUser();
	}

	public void deleteUser(UserDTO userDTO) {
		userSomething.delete(userDTO);
	}

	public UserDTO updateUser(UserDTO userDTO) {
		return userSomething.update(userDTO);
	}

}

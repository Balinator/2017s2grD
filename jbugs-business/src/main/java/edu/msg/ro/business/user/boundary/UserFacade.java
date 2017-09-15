package edu.msg.ro.business.user.boundary;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.business.user.control.UserService;
import edu.msg.ro.business.user.dto.UserDTO;

/**
 * Boundary for user component.
 * 
 * @author balinc
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

	public UserDTO updateUser(UserDTO user) throws TechnicalExeption {
		return userService.updateUser(user);
	}

	public UserDTO deleteUser(UserDTO userDTO) throws TechnicalExeption {
		return userService.deleteUser(userDTO);

	}

	public List<UserDTO> getAllUsers() {
		return userService.getAllUsers();
	}

	public List<UserDTO> getAllUserByQuery(String query) {
		List<UserDTO> queried = new ArrayList<UserDTO>();
		for (UserDTO userDTO : userService.getAllUsers()) {
			if (userDTO.getUsername().startsWith(query)) {
				queried.add(userDTO);
			}
		}
		return queried;
		// return bugService.getAllBugs();
	}
}

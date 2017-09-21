package edu.msg.ro.business.user.boundary;

import java.util.ArrayList;
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

	/**
	 * Method for creating an {@link User}.
	 * 
	 * @param user
	 * @return
	 * @throws BusinessException
	 */
	public UserDTO createUser(UserDTO user) throws BusinessException {
		return userService.createUser(user);
	}

	/**
	 * Method for updating an {@link User}.
	 * 
	 * @param user
	 * @return
	 * @throws BusinessException
	 */
	public UserDTO updateUser(UserDTO user) throws BusinessException {
		return userService.updateUser(user);
	}

	/**
	 * Method for deleting(deactivating) an {@link User}.
	 * 
	 * @param userDTO
	 * @return
	 * @throws BusinessException
	 */
	public UserDTO deleteUser(UserDTO userDTO) throws BusinessException {
		return userService.deleteUser(userDTO);

	}

	public UserDTO deleteUserNoCheck(UserDTO userDTO) throws TechnicalExeption {
		return userService.deleteUserNoCheck(userDTO);

	}

	/**
	 * Method for getting back all {@link User}s.
	 * 
	 * @return
	 */
	public List<UserDTO> getAllUsers() {
		return userService.getAllUsers();
	}

	/**
	 * Method for getting back all {@link User}s witch starts with the argument.
	 * 
	 * @param query
	 * @return
	 */
	public List<UserDTO> getAllUserByQuery(String query) {
		List<UserDTO> queried = new ArrayList<UserDTO>();
		for (UserDTO userDTO : userService.getAllUsers()) {
			if (userDTO.getUsername().startsWith(query)) {
				queried.add(userDTO);
			}
		}
		return queried;
	}

	/**
	 * Method for getting back a single {@link User} by username.
	 * 
	 * @param username
	 * @return
	 */
	public UserDTO getUserByUsername(String username) {
		for (UserDTO userDTO : userService.getAllUsers()) {
			if (userDTO.getUsername().equals(username)) {
				return userDTO;
			}
		}
		return null;
	}
}

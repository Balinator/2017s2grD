package edu.msg.ro.business.user.control;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.business.user.dao.UserDAO;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.dto.mapper.UserDTOMapper;
import edu.msg.ro.business.user.util.UserGenerator;
import edu.msg.ro.business.user.validation.UserValidator;
import edu.msg.ro.persistence.user.entity.User;

/**
 * Controller for User component.
 * 
 * @author balinc
 *
 */
@Stateless
public class UserService {

	@EJB
	private UserDTOMapper userDTOMapper;

	@EJB
	private UserDAO userDAO;

	@EJB
	UserValidator userValidator;

	@EJB
	UserGenerator userUtils;

	/**
	 * Method for creating a new {@link User}.
	 * 
	 * @param user
	 * @return
	 * @throws BusinessException
	 */
	public UserDTO createUser(UserDTO user) throws BusinessException {
		try {
			validateUserData(user);

			User userEntity = new User();
			String username = userUtils.createUsername(user);
			user.setUsername(username);
			String password = userUtils.encryptPassword(user);
			user.setPassword(password);
			userDTOMapper.mapToEntity(user, userEntity);
			userEntity.setActive(true);
			userDAO.persistEntity(userEntity);
			User persistedUser = userDAO.findEntity(userEntity.getId());
			return userDTOMapper.mapToDTO(persistedUser);
		} catch (BusinessException e) {
			throw new BusinessException(e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("user.crud.save.error");
		}
	}

	/**
	 * Method for updating an {@link User}.
	 * 
	 * @param user
	 * @return
	 * @throws TechnicalExeption
	 */
	public UserDTO updateUser(UserDTO user) throws TechnicalExeption {
		User persistedUser = userDAO.findEntity(user.getId());
		userDTOMapper.mapToEntity(user, persistedUser);
		return userDTOMapper.mapToDTO(persistedUser);
	}

	/**
	 * Method for deleting(deactivating) an {@link User}.
	 * 
	 * @param userDTO
	 * @return
	 * @throws TechnicalExeption
	 */
	public UserDTO deleteUser(UserDTO userDTO) throws TechnicalExeption {
		User userEntity = userDAO.findUserByUsername(userDTO.getUsername());
		if (userValidator.checkIfUserHasActiveTasks(userEntity) == false) {
			userEntity.setActive(false);
		}
		return userDTOMapper.mapToDTO(userEntity);
	}

	public UserDTO deleteUserNoCheck(UserDTO userDTO) throws TechnicalExeption {
		User userEntity = userDAO.findUserByUsername(userDTO.getUsername());
		userEntity.setActive(false);
		return userDTOMapper.mapToDTO(userEntity);
	}

	/**
	 * Method for validating if an {@link User} exist by his email.
	 * 
	 * @param user
	 * @throws BusinessException
	 */
	private void validateUserData(UserDTO user) throws BusinessException {
		User existingUserWithSameEmail = userDAO.findUserByEmail(user.getEmail());
		if (existingUserWithSameEmail != null) {
			throw new BusinessException("User already exists with given email " + user.getEmail());// TODO:
																									// i18n
		}
	}

	/**
	 * Method for verifying that the user with the given username and password
	 * exist(for login).
	 * 
	 * @param username
	 * @param pass
	 * @return
	 */
	public boolean findUserExists(String username, String pass) {
		return userDAO.verifyUserExist(username, pass);
	}

	/**
	 * Method for getting back all the {@link User}s.
	 * 
	 * @return
	 */
	public List<UserDTO> getAllUsers() {
		return userDTOMapper.mapToDTOs(userDAO.getAll());
	}
}

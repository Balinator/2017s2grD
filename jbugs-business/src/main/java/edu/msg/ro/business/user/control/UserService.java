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

	public UserDTO createUser(UserDTO user) throws TechnicalExeption, BusinessException {
		validateUserData(user);

		User userEntity = new User();
		String username = userUtils.createUsername(user);
		user.setUsername(username);
		try {
			user.setPassword(userUtils.encryptPassword(user));
		} catch (Exception e) {
			throw new TechnicalExeption();
		}

		userDTOMapper.mapToEntity(user, userEntity);

		userEntity.setActive(true);

		userDAO.persistEntity(userEntity);
		User persistedUser = userDAO.findEntity(userEntity.getId());
		return userDTOMapper.mapToDTO(persistedUser);
	}

	public UserDTO updateUser(UserDTO user) throws TechnicalExeption {
		User persistedUser = userDAO.findEntity(user.getId());
		userDTOMapper.mapToEntity(user, persistedUser);
		return userDTOMapper.mapToDTO(persistedUser);
	}

	public UserDTO deleteUser(UserDTO userDTO) throws TechnicalExeption {
		User userEntity = userDAO.findUserByUsername(userDTO.getUsername());
		if (userValidator.checkIfUserHasActiveTasks(userEntity) == false) {
			userEntity.setActive(false);
		}
		return userDTOMapper.mapToDTO(userEntity);
	}

	private void validateUserData(UserDTO user) throws BusinessException {
		User existingUserWithSameEmail = userDAO.findUserByEmail(user.getEmail());
		if (existingUserWithSameEmail != null) {
			throw new BusinessException("User already exists with given email " + user.getEmail());
		}
	}

	public boolean findUserExists(String username, String pass) {
		return userDAO.verifyUserExist(username, pass);
	}

	public List<UserDTO> getAllUsers() {
		return userDTOMapper.mapToDTOs(userDAO.getAll());
	}
}

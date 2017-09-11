package edu.msg.ro.business.user.control;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.dao.UserDAO;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.dto.mapper.UserDTOMapper;
import edu.msg.ro.persistence.user.entity.User;

/**
 * Controller for User component.
 * 
 * @author Andrei Floricel, msg systems ag
 *
 */
@Stateless
public class UserSomething {

	@EJB
	private UserDTOMapper userDTOMapper;

	@EJB
	private UserDAO userDAO;

	public UserDTO createUser(UserDTO user) throws BusinessException {
		validateUserData(user);

		User userEntity = new User();
		userDTOMapper.mapToEntity(user, userEntity);

		userEntity.setActive(true);

		userDAO.persistEntity(userEntity);
		User persistedUser = userDAO.findEntity(userEntity.getId());
		return userDTOMapper.mapToDTO(persistedUser);
	}

	private void validateUserData(UserDTO user) throws BusinessException {
		User existingUserWithSameEmail = userDAO.findUserByEmail(user.getEmail());
		if (existingUserWithSameEmail != null) {
			throw new BusinessException("User already exists with given email " + user.getEmail());
		}
	}

	public UserDTO deleteUser(UserDTO user) {
		User userEntity = userDAO.findEntity(user.getId());
		userDTOMapper.mapToEntity(user, userEntity);

		// delete means to make the user inactiv
		userEntity.setActive(false);

		User persisted = userDAO.findEntity(user.getId());
		return userDTOMapper.mapToDTO(persisted);
	}

	public UserDTO findById(Long id) throws BusinessException {
		return userDTOMapper.mapToDTO(userDAO.findEntity(id));
	}

	public UserDTO updateUser(UserDTO user) throws BusinessException {
		User userEntity = userDAO.findEntity(user.getId());
		userDTOMapper.mapToEntity(user, userEntity);
		User persisted = userDAO.findEntity(user.getId());

		return userDTOMapper.mapToDTO(persisted);
	}

	public boolean verifyUserExists(UserDTO user) {
		return userDAO.verifyUserExists(user.getUsername(), user.getPassword());
	}

	public List<UserDTO> getAll() {
		List<User> users = userDAO.getAll();
		List<UserDTO> listUserDTO = new ArrayList<>();
		for (User u : users) {
			listUserDTO.add(userDTOMapper.mapToDTO(u));
		}
		return listUserDTO;

	}
}

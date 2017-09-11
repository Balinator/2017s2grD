package edu.msg.ro.business.user.control;

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
public class UserService {

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

	public UserDTO findUserById(Long id) {
		return userDTOMapper.mapToDTO(userDAO.findEntity(id));
	}

	public UserDTO findUserByUsername(String username) {
		return userDTOMapper.mapToDTO(userDAO.findUserByUsername(username));
	}

	public List<UserDTO> findAllUser() {
		return userDTOMapper.mapToDTOs(userDAO.findAllUser());
	}

	public UserDTO findUserToLogin(String username, String password) {
		return userDTOMapper.mapToDTO(userDAO.findUserToLogin(username, password));
	}

	public void delete(UserDTO userDTO) {
		// User u = new User();
		// userDTOMapper.mapToEntity(userDTO, u);
		// userDAO.deleteEntity(u);

		User userEntity = userDAO.findUserByUsername(userDTO.getUsername());
		// if (!userValidator.checkIfUserHasActiveTasks(userEntity)) {
		userEntity.setActive(false);
		// }
	}

	public UserDTO update(UserDTO userDTO) {
		User userEntity = userDAO.findEntity(userDTO.getId());
		userDTOMapper.mapToEntity(userDTO, userEntity);
		User persisted = userDAO.findEntity(userEntity.getId());
		return userDTOMapper.mapToDTO(persisted);
	}

}

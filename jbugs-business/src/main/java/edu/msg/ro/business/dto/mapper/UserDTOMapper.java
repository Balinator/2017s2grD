package edu.msg.ro.business.dto.mapper;

import edu.msg.ro.business.dto.UserDTO;
import edu.msg.ro.persistence.user.entity.User;

public class UserDTOMapper {

	public UserDTO mapToDTO(User userEntity) {
		UserDTO userDTO = new UserDTO();

		userDTO.setId(userEntity.getId());
		userDTO.setLastName(userEntity.getLastName());
		userDTO.setFirstName(userEntity.getFirstName());
		userDTO.setEmail(userEntity.getEmail());
		userDTO.setPhoneNumber(userEntity.getPhoneNumber());
		userDTO.setStatus(userEntity.isStatus());

		return userDTO;
	}

	public void mapToEntity(UserDTO userDTO, User userEntity) {

		userEntity.setId(userDTO.getId());
		userEntity.setFirstName(userDTO.getFirstName());
		userEntity.setLastName(userDTO.getLastName());
		userEntity.setEmail(userDTO.getEmail());
		userEntity.setPhoneNumber(userDTO.getPhoneNumber());
		userEntity.setStatus(userDTO.isStatus());
	}
}

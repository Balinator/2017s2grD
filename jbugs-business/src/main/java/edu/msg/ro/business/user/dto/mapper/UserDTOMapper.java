package edu.msg.ro.business.user.dto.mapper;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.common.dto.mapper.AbstractDTOMapper;
import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.business.user.dao.RoleDAO;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.util.UserGenerator;
import edu.msg.ro.persistence.user.entity.User;

/**
 * Mapper for {@link User} and {@link UserDTO}.
 * 
 * @author balinc
 *
 */
@Stateless
public class UserDTOMapper extends AbstractDTOMapper<User, UserDTO> {

	@EJB
	UserGenerator userGenerator;

	@EJB
	RoleDTOMapper roleDTOMapper;

	@EJB
	RoleDAO roleDAO;

	@Override
	public UserDTO getDTOInstance() {
		return new UserDTO();
	}

	@Override
	protected void mapEntityToDTOFields(User entity, UserDTO dto) {
		dto.setEmail(entity.getEmail());
		dto.setFirstname(entity.getFirstname());
		dto.setLastname(entity.getLastname());
		dto.setPassword(entity.getPassword());
		dto.setPhoneNumber(entity.getPhoneNumber());
		dto.setUsername(entity.getUsername());
		dto.setActive(entity.isActive());
		// dto.setRoles(entity.getRoles());
	}

	@Override
	protected void mapDTOToEntityFields(UserDTO dto, User entity) {
		entity.setEmail(dto.getEmail());
		entity.setFirstname(dto.getFirstname());
		entity.setLastname(dto.getLastname());
		entity.setPassword(dto.getPassword());
		entity.setLockVersion(dto.getLockVersion());
		entity.setPhoneNumber(dto.getPhoneNumber());
		entity.setUsername(dto.getUsername());
		entity.setActive(dto.isActive());
		try {
			entity.setRoles(roleDTOMapper.mapToEntities(dto.getRoles(), roleDAO));
		} catch (TechnicalExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

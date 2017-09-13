package edu.msg.ro.business.user.dto.mapper;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.enterprise.context.Dependent;

import edu.msg.ro.business.common.dto.mapper.AbstractDTOMapper;
import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.util.UserPassword;
import edu.msg.ro.persistence.user.entity.User;

/**
 * Mapper for {@link User} and {@link UserDTO}.
 * 
 * @author Andrei Floricel, msg systems ag
 *
 */
@Dependent
public class UserDTOMapper extends AbstractDTOMapper<User, UserDTO> {
	@EJB
	private UserPassword userPass;

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
	}

	@Override
	protected void mapDTOToEntityFields(UserDTO dto, User entity) throws TechnicalExeption {
		entity.setEmail(dto.getEmail());
		entity.setFirstname(dto.getFirstname());
		entity.setLastname(dto.getLastname());
		try {
			entity.setPassword(userPass.encryptPassword(dto));
		} catch (NoSuchAlgorithmException e) {
			throw new TechnicalExeption();
		} catch (UnsupportedEncodingException e) {
			throw new TechnicalExeption();
		}
		entity.setLockVersion(dto.getLockVersion());
		entity.setPhoneNumber(dto.getPhoneNumber());
		entity.setUsername(dto.getUsername());
		entity.setActive(dto.isActive());
	}

}

package edu.msg.ro.business.user.dto.mapper;

import javax.enterprise.context.Dependent;

import edu.msg.ro.business.common.dto.mapper.AbstractDTOMapper;
import edu.msg.ro.business.user.dto.RoleDTO;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.persistence.user.entity.Role;
import edu.msg.ro.persistence.user.entity.User;

/**
 * Mapper for {@link Role} and {@link RoleDTO}.
 * @author nagya
 *
 */
@Dependent
public class RoleDTOMapper extends AbstractDTOMapper<Role, RoleDTO> {

	@Override
	public RoleDTO getDTOInstance() {
		return new RoleDTO();
	}

	@Override
	protected void mapEntityToDTOFields(Role entity, RoleDTO dto) {
		dto.setNameEng(entity.getNameEng());
		dto.setNameRo(entity.getNameRo());

	}

	@Override
	protected void mapDTOToEntityFields(RoleDTO dto, Role entity) {
		entity.setNameEng(dto.getNameEng());
		entity.setNameRo(dto.getNameRo());
	}
}

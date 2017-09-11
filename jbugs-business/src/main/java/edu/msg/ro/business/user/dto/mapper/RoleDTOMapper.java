package edu.msg.ro.business.user.dto.mapper;

import javax.ejb.Stateless;

import edu.msg.ro.business.common.dto.mapper.AbstractDTOMapper;
import edu.msg.ro.business.user.dto.RoleDTO;
import edu.msg.ro.persistence.user.entity.Role;

/**
 * Mapper for {@link Role} and {@link RoleDTO}.
 * 
 * @author balinc
 *
 */
@Stateless
public class RoleDTOMapper extends AbstractDTOMapper<Role, RoleDTO> {

	@Override
	public RoleDTO getDTOInstance() {
		return new RoleDTO();
	}

	@Override
	protected void mapEntityToDTOFields(Role entity, RoleDTO dto) {
		dto.setName_EN(entity.getName_EN());
		dto.setName_RO(entity.getName_RO());
	}

	@Override
	protected void mapDTOToEntityFields(RoleDTO dto, Role entity) {
		entity.setName_EN(dto.getName_EN());
		entity.setName_RO(dto.getName_RO());

	}
}

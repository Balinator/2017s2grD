package edu.msg.ro.business.user.dto.mapper;

import javax.enterprise.context.Dependent;

import edu.msg.ro.business.common.dto.mapper.AbstractDTOMapper;
import edu.msg.ro.business.user.dto.PermissionDTO;
import edu.msg.ro.persistence.user.entity.Permission;

/**
 * Mapper for {@link Permission} and {@link PermissionDTO}.
 * 
 * @author laszll
 *
 */
@Dependent
public class PermissionDTOMapper extends AbstractDTOMapper<Permission, PermissionDTO> {

	@Override
	public PermissionDTO getDTOInstance() {
		return new PermissionDTO();
	}

	@Override
	protected void mapEntityToDTOFields(Permission entity, PermissionDTO dto) {
		dto.setName(entity.getName());
		dto.setDetails(entity.getDetails());
	}

	@Override
	protected void mapDTOToEntityFields(PermissionDTO dto, Permission entity) {
		entity.setName(dto.getName());
		entity.setDetails(dto.getDetails());
	}

}

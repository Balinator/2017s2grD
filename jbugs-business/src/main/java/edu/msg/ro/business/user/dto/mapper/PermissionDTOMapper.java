package edu.msg.ro.business.user.dto.mapper;

import javax.ejb.Stateless;

import edu.msg.ro.business.common.dto.mapper.AbstractDTOMapper;
import edu.msg.ro.business.user.dto.PermissionDTO;
import edu.msg.ro.persistence.user.entity.Permission;

/**
 * Mapper for {@link Permission} and {@link PermissionDTO}
 * 
 * @author varadp
 *
 */
@Stateless
public class PermissionDTOMapper extends AbstractDTOMapper<Permission, PermissionDTO> {

	/**
	 * Method for instantiating a {@link PermissionDTO}.
	 */
	@Override
	public PermissionDTO getDTOInstance() {
		return new PermissionDTO();
	}

	/**
	 * Method for filling up the {@link PermissionDTO}.
	 */
	@Override
	protected void mapEntityToDTOFields(Permission entity, PermissionDTO dto) {
		dto.setName(entity.getName());
	}

	/**
	 * Method for filling up the {@link Permission}.
	 */
	@Override
	protected void mapDTOToEntityFields(PermissionDTO dto, Permission entity) {
		entity.setName(dto.getName());

	}

}

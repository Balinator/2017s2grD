package edu.msg.ro.business.user.dto.mapper;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.common.dto.mapper.AbstractDTOMapper;
import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.business.user.dao.PermissionDAO;
import edu.msg.ro.business.user.dto.RoleDTO;
import edu.msg.ro.persistence.user.entity.Role;

/**
 * Mapper for {@link Role} and {@link RoleDTO}
 * 
 * @author varadp
 *
 */
@Stateless
public class RoleDTOMapper extends AbstractDTOMapper<Role, RoleDTO> {

	@EJB
	private PermissionDTOMapper pdm;

	@EJB
	private PermissionDAO pd;

	@Override
	public RoleDTO getDTOInstance() {
		return new RoleDTO();
	}

	@Override
	protected void mapEntityToDTOFields(Role entity, RoleDTO dto) {
		dto.setPermission(pdm.mapToDTOs(entity.getPermissions()));
		dto.setName(entity.getName());

	}

	@Override
	protected void mapDTOToEntityFields(RoleDTO dto, Role entity) throws TechnicalExeption {
		entity.setPermissions(pdm.mapToEntities(dto.getPermission(), pd));
		entity.setName(dto.getName());
	}
}

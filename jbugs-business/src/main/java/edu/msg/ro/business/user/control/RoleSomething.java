package edu.msg.ro.business.user.control;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.dao.RoleDAO;
import edu.msg.ro.business.user.dto.RoleDTO;
import edu.msg.ro.business.user.dto.mapper.RoleDTOMapper;
import edu.msg.ro.persistence.user.entity.Role;

/**
 * Controller for Role component.
 * 
 * @author fulops
 *
 */
@Stateless
public class RoleSomething {

	@Inject
	private RoleDTOMapper roleDTOMapper;

	@EJB
	private RoleDAO roleDAO;

	public RoleDTO createRole(RoleDTO role) throws BusinessException {

		Role roleEntity = new Role();
		roleDTOMapper.mapToEntity(role, roleEntity);
		roleDAO.persistEntity(roleEntity);
		Role persistedRole = roleDAO.findEntity(roleEntity.getId());
		return roleDTOMapper.mapToDTO(persistedRole);
	}

}

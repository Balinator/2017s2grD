package edu.msg.ro.business.user.control;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.dao.RoleDAO;
import edu.msg.ro.business.user.dto.RoleDTO;
import edu.msg.ro.business.user.dto.mapper.RoleDTOMapper;
import edu.msg.ro.persistence.user.entity.Role;

/**
 * Controller for {@link Role} component.
 * 
 * @author laszll
 *
 */
@Stateless
public class RoleService {

	@EJB
	private RoleDTOMapper roleDTOMapper;

	@EJB
	private RoleDAO roleDAO;

	public RoleDTO createRole(RoleDTO role) throws BusinessException {
		Role roleEntity = new Role();
		roleDTOMapper.mapToEntity(role, roleEntity);
		roleDAO.persistEntity(roleEntity);
		Role persisted = roleDAO.findEntity(roleEntity.getId());
		return roleDTOMapper.mapToDTO(persisted);
	}

	public RoleDTO updateRole(RoleDTO role) throws BusinessException {
		Role roleEntity = roleDAO.findEntity(role.getId());
		roleDTOMapper.mapToEntity(role, roleEntity);
		Role persisted = roleDAO.findEntity(roleEntity.getId());
		return roleDTOMapper.mapToDTO(persisted);
	}

	public void deleteRole(RoleDTO role) {
		Role roleEntity = roleDAO.findEntity(role.getId());
		roleDTOMapper.mapToEntity(role, roleEntity);

		roleDAO.deleteEntity(roleEntity);
	}

	public RoleDTO findById(Long id) throws BusinessException {
		return roleDTOMapper.mapToDTO(roleDAO.findEntity(id));
	}

}

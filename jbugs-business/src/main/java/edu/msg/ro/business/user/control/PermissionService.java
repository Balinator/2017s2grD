package edu.msg.ro.business.user.control;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.dao.PermissionDAO;
import edu.msg.ro.business.user.dto.PermissionDTO;
import edu.msg.ro.business.user.dto.mapper.PermissionDTOMapper;
import edu.msg.ro.persistence.user.entity.Permission;

/**
 * Controller for {@link Permission} component.
 * 
 * @author laszll
 *
 */
@Stateless
public class PermissionService {

	@EJB
	private PermissionDTOMapper permissionDTOMapper;

	@EJB
	private PermissionDAO permissionDAO;

	public PermissionDTO createPermission(PermissionDTO permission) throws BusinessException {
		Permission permissionEntity = new Permission();
		permissionDTOMapper.mapToEntity(permission, permissionEntity);
		permissionDAO.persistEntity(permissionEntity);
		Permission persisted = permissionDAO.findEntity(permissionEntity.getId());
		return permissionDTOMapper.mapToDTO(persisted);
	}

	public PermissionDTO updatePermission(PermissionDTO permission) throws BusinessException {
		Permission permissionEntity = permissionDAO.findEntity(permission.getId());
		permissionDTOMapper.mapToEntity(permission, permissionEntity);
		Permission persisted = permissionDAO.findEntity(permissionEntity.getId());
		return permissionDTOMapper.mapToDTO(persisted);
	}

	public void deletePermission(PermissionDTO permission) {
		Permission permissionEntity = permissionDAO.findEntity(permission.getId());
		permissionDTOMapper.mapToEntity(permission, permissionEntity);

		permissionDAO.deleteEntity(permissionEntity);
	}

	public PermissionDTO findById(Long id) throws BusinessException {
		return permissionDTOMapper.mapToDTO(permissionDAO.findEntity(id));
	}
}

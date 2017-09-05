package edu.msg.ro.business.user.boundary;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.control.PermissionService;
import edu.msg.ro.business.user.dto.PermissionDTO;
import edu.msg.ro.persistence.user.entity.Permission;

/**
 * Boundary for {@link Permission} component.
 * 
 * @author laszll
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PermissionFacede {

	@EJB
	private PermissionService permissionSomething;

	public PermissionDTO createPermission(PermissionDTO permission) throws BusinessException {
		return permissionSomething.createPermission(permission);
	}

	public void deletePermission(PermissionDTO permission) throws BusinessException {
		permissionSomething.deletePermission(permission);
	}

	public PermissionDTO updatePermission(PermissionDTO permission) throws BusinessException {
		return permissionSomething.updatePermission(permission);
	}

	public PermissionDTO findPermissionById(Long id) throws BusinessException {
		return permissionSomething.findById(id);
	}
}

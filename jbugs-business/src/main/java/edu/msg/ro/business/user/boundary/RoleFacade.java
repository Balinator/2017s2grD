package edu.msg.ro.business.user.boundary;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.control.RoleService;
import edu.msg.ro.business.user.dto.RoleDTO;
import edu.msg.ro.persistence.user.entity.Role;

/**
 * Boundary for {@link Role} component.
 * 
 * @author laszll
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class RoleFacade {
	@EJB
	private RoleService roleSomething;

	public RoleDTO createRole(RoleDTO role) throws BusinessException {
		return roleSomething.createRole(role);
	}

	public void deleteRole(RoleDTO role) throws BusinessException {
		roleSomething.deleteRole(role);
	}

	public RoleDTO updateRole(RoleDTO role) throws BusinessException {
		return roleSomething.updateRole(role);
	}

	public RoleDTO findRoleById(Long id) throws BusinessException {
		return roleSomething.findById(id);
	}
}

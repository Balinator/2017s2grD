package edu.msg.ro.business.user.boundary;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import edu.msg.ro.business.user.control.RoleService;
import edu.msg.ro.business.user.dto.RoleDTO;

/**
 * Boundary for role component.
 * 
 * @author laszll
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class RoleFacade {

	@EJB
	private RoleService roleService;

	public RoleDTO createRole(RoleDTO role) {
		return roleService.createRole(role);
	}

	public RoleDTO updateRole(RoleDTO role) {
		return roleService.updateRole(role);
	}

	public void deleteRole(RoleDTO role) {
		roleService.deleteRole(role);
	}

	public RoleDTO findRoleById(Long id) {
		return roleService.findById(id);
	}
}

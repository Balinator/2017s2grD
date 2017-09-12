package edu.msg.ro.business.user.boundary;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import edu.msg.ro.business.user.control.RoleService;
import edu.msg.ro.persistence.user.entity.Role;

/**
 * Boundary for role component.
 * 
 * @author balinc
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class RoleFacade {

	@EJB
	private RoleService roleService;

	public List<Role> getAllUsers() {
		return roleService.getAllRoles();
	}
}

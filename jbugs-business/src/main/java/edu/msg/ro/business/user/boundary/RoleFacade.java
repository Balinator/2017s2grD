package edu.msg.ro.business.user.boundary;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.business.user.control.RoleService;
import edu.msg.ro.business.user.dto.RoleDTO;

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

	public List<RoleDTO> getAllRoles() {
		return roleService.getAllRoles();
	}

	public RoleDTO update(RoleDTO roleDTO) throws TechnicalExeption {
		RoleDTO ret = roleService.update(roleDTO);
		return ret;
	}
}

package edu.msg.ro.business.user.boundary;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.control.RoleSomething;
import edu.msg.ro.business.user.dto.RoleDTO;

/**
 * Boundary for role component.
 * 
 * @author fulops
 *
 */

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class RoleFacade {

	@EJB
	private RoleSomething roleSomething;

	public RoleDTO createRole(RoleDTO role) throws BusinessException {
		return roleSomething.createRole(role);
	}

}

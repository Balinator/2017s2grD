package edu.msg.ro.business.user.control;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.user.dao.PermissionDAO;
import edu.msg.ro.persistence.user.entity.Permission;

/**
 * Controller for Permission component.
 * 
 * @author varadp
 *
 */
@Stateless
public class PermissionService {

	@EJB
	private PermissionDAO permissionDAO;

	public List<Permission> getAllPermissions() {
		return permissionDAO.getAll();
	}

}

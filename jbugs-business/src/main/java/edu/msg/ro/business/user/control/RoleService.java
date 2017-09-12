package edu.msg.ro.business.user.control;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.user.dao.RoleDAO;
import edu.msg.ro.persistence.user.entity.Role;

/**
 * Controller for Role component.
 * 
 * @author balinc
 *
 */
@Stateless
public class RoleService {

	@EJB
	private RoleDAO roleDAO;

	public List<Role> getAllRoles() {
		return roleDAO.findAll();
	}
}

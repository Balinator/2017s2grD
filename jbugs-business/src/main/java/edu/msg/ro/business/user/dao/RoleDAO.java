package edu.msg.ro.business.user.dao;

import java.util.List;

import javax.ejb.Stateless;

import edu.msg.ro.business.common.dao.AbstractDao;
import edu.msg.ro.persistence.user.entity.Role;

/**
 * DAO for {@link Role} entity.
 * 
 * @author nagya
 *
 */
@Stateless
public class RoleDAO extends AbstractDao<Role> {

	@Override
	public Class<Role> getEntityClass() {
		return Role.class;
	}

	public List<Role> findRole(int id) {
		List<Role> roles;
		roles = this.em.createNamedQuery(Role.FIND_ROLE, Role.class).getResultList();

		return roles;
	}
}

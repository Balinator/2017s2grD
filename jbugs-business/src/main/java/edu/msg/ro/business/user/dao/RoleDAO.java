package edu.msg.ro.business.user.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import edu.msg.ro.business.common.dao.AbstractDao;
import edu.msg.ro.persistence.user.entity.Role;

/**
 * DAO for {@link Role} entity.
 * 
 * @author fulops
 *
 */
@Stateless
public class RoleDAO extends AbstractDao<Role> {

	public List<Role> findAllRoles(Long id) {
		List<Role> roles;

		roles = this.em.createNamedQuery(Role.FIND_ROLE_BY_ID, Role.class).getResultList();
		return roles;
	}

	public Role findRoleById(Long id) {
		TypedQuery<Role> query = this.em.createNamedQuery(Role.FIND_ROLE_BY_ID, Role.class);
		query.setParameter("Id", id);

		return getSingleResult(query);
	}

	@Override
	public Class<Role> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

}

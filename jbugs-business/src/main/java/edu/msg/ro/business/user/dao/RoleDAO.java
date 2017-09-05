package edu.msg.ro.business.user.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import edu.msg.ro.business.common.dao.AbstractDao;
import edu.msg.ro.persistence.user.entity.Role;

/**
 * DAO for {@link Role} entity.
 * 
 * @author laszll
 *
 */
@Stateless
public class RoleDAO extends AbstractDao<Role> {

	@Override
	public Class<Role> getEntityClass() {
		return Role.class;
	}

	public List<Role> findAllRoles() {
		TypedQuery<Role> query = this.em.createNamedQuery(Role.FIND_ALL_ROLE, Role.class);
		return query.getResultList();
	}

	public Role findRoleByNameEN(String nameEN) {
		TypedQuery<Role> query = this.em.createNamedQuery(Role.FIND_ROLE_BY_NAME_EN, Role.class);
		query.setParameter("nameEN", nameEN);

		return getSingleResult(query);
	}

}

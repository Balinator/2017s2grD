package edu.msg.ro.business.user.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import edu.msg.ro.business.common.dao.AbstractDao;
import edu.msg.ro.persistence.user.entity.Role;

/**
 * DAO for {@link Role} entity.
 * 
 * @author balinc
 *
 */
@Stateless
public class RoleDAO extends AbstractDao<Role> {

	@Override
	public Class<Role> getEntityClass() {
		return Role.class;
	}

	public List<Role> findAll() {
		TypedQuery<Role> query = this.em.createNamedQuery(Role.FIND_All_ROLES, Role.class);
		return query.getResultList();
	}
}

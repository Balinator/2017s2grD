package edu.msg.ro.business.user.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import edu.msg.ro.business.common.dao.AbstractDao;
import edu.msg.ro.persistence.user.entity.Permission;

/**
 * DAO for {@link Permission} entity for select all
 * 
 * @author varadp
 *
 */
@Stateless
public class PermissionDAO extends AbstractDao<Permission> {

	@Override
	public Class<Permission> getEntityClass() {
		return Permission.class;
	}

	public List<Permission> getAll() {
		TypedQuery<Permission> query = this.em.createNamedQuery(Permission.FIND_ALL, Permission.class);
		return query.getResultList();
	}
}

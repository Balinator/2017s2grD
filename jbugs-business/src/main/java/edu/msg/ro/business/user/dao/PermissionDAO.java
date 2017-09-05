package edu.msg.ro.business.user.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import edu.msg.ro.business.common.dao.AbstractDao;
import edu.msg.ro.persistence.user.entity.Permission;

/**
 * DAO for {@link Permission} entity.
 * 
 * @author laszll
 *
 */
@Stateless
public class PermissionDAO extends AbstractDao<Permission> {

	@Override
	public Class<Permission> getEntityClass() {
		return Permission.class;
	}

	public List<Permission> findAllRoles() {
		TypedQuery<Permission> query = this.em.createNamedQuery(Permission.FIND_ALL_PERMISSION, Permission.class);
		return query.getResultList();
	}

}

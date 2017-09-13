package edu.msg.ro.business.bug.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import edu.msg.ro.business.common.dao.AbstractDao;
import edu.msg.ro.persistence.bug.entity.Bug;

/**
 * DAO for {@link Bug} entity.
 *
 * @author balinc
 *
 */
public class BugDAO extends AbstractDao<Bug> {

	@Override
	public Class<Bug> getEntityClass() {
		return Bug.class;
	}

	public List<Bug> getAll() {
		TypedQuery<Bug> query = this.em.createNamedQuery(Bug.FIND_ALL, Bug.class);
		return query.getResultList();
	}

	public Bug getBug(Long id) {
		return this.findEntity(id);
	}
}

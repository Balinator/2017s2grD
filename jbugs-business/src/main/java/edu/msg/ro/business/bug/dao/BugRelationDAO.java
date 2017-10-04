package edu.msg.ro.business.bug.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import edu.msg.ro.business.common.dao.AbstractDao;
import edu.msg.ro.persistence.bug.entity.BugRelation;

@Stateless
public class BugRelationDAO extends AbstractDao<BugRelation> {

	@Override
	public Class<BugRelation> getEntityClass() {
		return BugRelation.class;
	}

	public List<BugRelation> getBugRelation(Long id) {
		Query query = this.em.createQuery("SELECT br FROM BugRelation br WHERE br.bug1.id = :id");
		query.setParameter("id", id);
		return query.getResultList();
	}

}

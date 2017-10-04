package edu.msg.ro.business.bug.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import edu.msg.ro.business.common.dao.AbstractDao;
import edu.msg.ro.persistence.bug.entity.History;

@Stateless
public class HistoryDAO extends AbstractDao<History> {

	@Override
	public Class<History> getEntityClass() {
		return History.class;
	}

	public List<History> getAllHistory() {
		Query query = this.em.createQuery("SELECT h FROM History h", History.class);
		return query.getResultList();
	}

}

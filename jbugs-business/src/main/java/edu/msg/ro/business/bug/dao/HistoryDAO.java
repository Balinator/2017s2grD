package edu.msg.ro.business.bug.dao;

import javax.ejb.Stateless;

import edu.msg.ro.business.common.dao.AbstractDao;
import edu.msg.ro.persistence.bug.entity.History;

@Stateless
public class HistoryDAO extends AbstractDao<History> {

	@Override
	public Class<History> getEntityClass() {
		return History.class;
	}

}

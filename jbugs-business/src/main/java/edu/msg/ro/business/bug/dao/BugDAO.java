package edu.msg.ro.business.bug.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.common.dao.AbstractDao;
import edu.msg.ro.persistence.bug.entity.Bug;

/**
 * DAO for {@link Bug} entity.
 *
 * @author balinc
 *
 */
@Stateless
public class BugDAO extends AbstractDao<Bug> {

	/**
	 * Method for getting class.
	 */
	@Override
	public Class<Bug> getEntityClass() {
		return Bug.class;
	}

	/**
	 * Method for getting back all {@link Bug}s.
	 * 
	 * @return
	 */
	public List<Bug> getAll() {
		TypedQuery<Bug> query = this.em.createNamedQuery(Bug.FIND_ALL, Bug.class);
		return query.getResultList();
	}

	/**
	 * Method for delete attachment
	 * 
	 * @param id
	 */
	public void deleteAttachemtn(Long id) {
		TypedQuery<Bug> query = this.em.createNamedQuery(Bug.DELETE_ATTACHMENT, Bug.class);
		query.setParameter("id", id);
	}

	/**
	 * Method for finding {@link Bug} by id.
	 * 
	 * @param id
	 * @return
	 */
	public Bug getBug(Long id) {
		return this.findEntity(id);
	}

	public int getStatisticsBug1Option(int key) {
		Query query = this.em.createQuery("SELECT b FROM Bug b WHERE b.status = :key", Integer.class);
		query.setParameter("key", key);
		return query.getResultList().size();
	}

	public int getStatisticsBug2Option(int key) {
		Query query = this.em.createQuery("SELECT b FROM Bug b WHERE b.severity = :key", Integer.class);
		query.setParameter("key", key);
		return query.getResultList().size();
	}

	public List<Bug> getAllBugsByQuery(String title) {
		Query query = this.em.createQuery("SELECT b FROM Bug b WHERE b.title like :title", BugDTO.class);
		query.setParameter("title", title + "%");
		return query.getResultList();
	}

	public Bug findBugByTitle(String title) {
		Query query = this.em.createQuery("SELECT b FROM Bug b WHERE b.title = :title", BugDTO.class);
		query.setParameter("title", title);
		return (Bug) query.getResultList().get(0);
	}

}

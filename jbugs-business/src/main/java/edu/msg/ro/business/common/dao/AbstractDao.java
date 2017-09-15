package edu.msg.ro.business.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.msg.ro.persistence.common.entity.AbstractEntity;

/**
 * Abstract DAO class.
 * 
 * @author balinc
 *
 * @param <E>
 */
public abstract class AbstractDao<E extends AbstractEntity> {

	@PersistenceContext(unitName = "jbugs-persistence")
	protected EntityManager em;

	public abstract Class<E> getEntityClass();

	public void persistEntity(E entity) {
		em.persist(entity);
		em.flush();
	}

	public void deleteEntity(E entity) {
		em.remove(entity);
	}

	public E findEntity(Long id) {
		return em.find(getEntityClass(), id);
	}

	public E getSingleResult(TypedQuery<E> query) {
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

}

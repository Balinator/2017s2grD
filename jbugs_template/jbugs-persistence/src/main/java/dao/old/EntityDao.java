package dao.old;

import java.util.List;

import javax.persistence.EntityManager;

public abstract class EntityDao<T> implements DataAccessObject<T> {// jbugs-persistence

	protected EntityManager entityManager;

	// private T entity;

	// public EntityDao(EntityManagerFactory entityManagerFactory) {
	// super();
	// entityManager = entityManagerFactory.createEntityManager();
	// entityTransaction = entityManager.getTransaction();
	// }

	// protected void init(Class<T> aClass) {
	// try {
	// entity = aClass.newInstance();
	// } catch (InstantiationException | IllegalAccessException e) {
	// e.printStackTrace();
	// }
	// }

	@Override
	public void persist(T entity) {
		entityManager.persist(entity);
	}

	@Override
	public void delete(T entity) {
		entityManager.remove(entity);
	}

	@Override
	public void update(T entity) {
		entityManager.merge(entity);
	}

	@Override
	public T find(int entityId) {
		return null;
		// @SuppressWarnings("unchecked")
		// T entity = (T) entityManager.find(this.entity.getClass(), entityId);
		//
		// return entity;
	}

	@Override
	public List<T> findAll() {
		return null;
		// @SuppressWarnings("unchecked")
		// List<T> entities =
		// entityManager.createNamedQuery(entity.getClass().getSimpleName() +
		// ".findAll")
		// .getResultList();
		//
		// return entities;
	}

}

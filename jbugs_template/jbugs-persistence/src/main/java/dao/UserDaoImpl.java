package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.User;

@Stateless(mappedName = "UserDaoImpl")
public class UserDaoImpl implements UserDaoInterface {

	@PersistenceContext(unitName = "jbugs-persistence")
	public EntityManager entityManager;

	@Override
	public void persist(User entity) {
		entityManager.persist(entity);
	}

	@Override
	public void delete(User entity) {
		entityManager.remove(entity);
	}

	@Override
	public void update(User entity) {
		entityManager.merge(entity);
	}

	@Override
	public User find(int entityId) {
		User entity = (User) entityManager.find(User.class, entityId);

		return entity;
	}

	@Override
	public List<User> findAll() {
		@SuppressWarnings("unchecked")
		List<User> entities = entityManager.createNamedQuery(User.class.getSimpleName() + ".findAll").getResultList();
		return entities;
	}

}

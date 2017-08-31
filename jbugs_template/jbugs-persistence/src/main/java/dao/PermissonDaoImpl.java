package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Permission;

@Stateless(mappedName = "PermissionDaoImpl")
public class PermissonDaoImpl implements PermissionDaoInterface {

	@PersistenceContext(unitName = "jbugs-persistence")
	public EntityManager entityManager;

	@Override
	public void persist(Permission entity) {
		entityManager.persist(entity);
	}

	@Override
	public void delete(Permission entity) {
		entityManager.remove(entity);
	}

	@Override
	public void update(Permission entity) {
		entityManager.merge(entity);
	}

	@Override
	public Permission find(int entityId) {
		Permission entity = (Permission) entityManager.find(Permission.class, entityId);

		return entity;
	}

	@Override
	public List<Permission> findAll() {
		@SuppressWarnings("unchecked")
		List<Permission> entities = entityManager.createNamedQuery(Permission.class.getSimpleName() + ".findAll")
				.getResultList();
		return entities;
	}

}

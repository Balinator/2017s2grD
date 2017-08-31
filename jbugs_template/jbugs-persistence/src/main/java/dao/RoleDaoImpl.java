package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Role;

@Stateless(mappedName = "RoleDaoImpl")
public class RoleDaoImpl implements RoleDaoInterface {

	@PersistenceContext(unitName = "jbugs-persistence")
	public EntityManager entityManager;

	@Override
	public void persist(Role entity) {
		entityManager.persist(entity);
	}

	@Override
	public void delete(Role entity) {
		entityManager.remove(entity);
	}

	@Override
	public void update(Role entity) {
		entityManager.merge(entity);
	}

	@Override
	public Role find(int entityId) {
		Role entity = (Role) entityManager.find(Role.class, entityId);

		return entity;
	}

	@Override
	public List<Role> findAll() {
		@SuppressWarnings("unchecked")
		List<Role> entities = entityManager.createNamedQuery(Role.class.getSimpleName() + ".findAll").getResultList();
		return entities;
	}

}

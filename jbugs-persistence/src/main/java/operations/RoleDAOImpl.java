package operations;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Role;

@Stateless(name = "RoleDAOImpl")
public class RoleDAOImpl implements RoleDAO {

	@PersistenceContext(unitName = "jbugs-persistence")
	private EntityManager em;

	@Override
	public void persistRole(Role role) {
		em.persist(role);
	}

	@Override
	public void deleteRole(Role role) {
		em.remove(role);

	}

	@Override
	public void updateRole(Role role) {
		em.merge(role);
	}

	@Override
	public Role findRole(int roleId) {
		Role role = em.find(Role.class, roleId);
		return role;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> listAllRoles() {
		List<Role> roles;
		Query query = em.createQuery("Select r From Role r");
		roles = query.getResultList();

		return roles;
	}

}

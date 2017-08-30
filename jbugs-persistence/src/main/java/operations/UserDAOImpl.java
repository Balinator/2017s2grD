package operations;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.User;

@Stateless(name = "UserDAOImpl", mappedName = "UserDAOImpl")

public class UserDAOImpl implements UserDAO {

	@PersistenceContext(unitName = "jbugs-persistence")
	private EntityManager em;

	@Override
	public void persistUser(User user) {
		em.persist(user);
	}

	@Override
	public void deleteUser(User user) {
		em.remove(user);
	}

	@Override
	public void updateUser(User user) {
		em.merge(user);
	}

	@Override
	public User findUser(int userId) {
		User user = em.find(User.class, userId);
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listAllUsers() {
		List<User> users;
		users = em.createNamedQuery("listAllUser").getResultList();
		return users;
	}

}

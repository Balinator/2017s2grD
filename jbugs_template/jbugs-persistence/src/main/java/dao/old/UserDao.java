package dao.old;

import javax.persistence.EntityManager;

import entities.User;

//@Stateless(mappedName = "UserDao")
//@Remote(DataAccessObject.class)
public class UserDao extends EntityDao<User> {

	// public UserDao(EntityManagerFactory entityManagerFactory) {
	// super(entityManagerFactory);
	// init(User.class);
	// }

	// @PersistenceContext(unitName = "jbugs-persistence")
	protected EntityManager entityManager;

	// @PostConstruct
	// private void init() {
	// super.entityManager = this.entityManager;
	// super.init(User.class);
	// }

}

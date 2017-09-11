package edu.msg.ro.business.user.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import edu.msg.ro.business.common.dao.AbstractDao;
import edu.msg.ro.persistence.user.entity.User;

/**
 * DAO for {@link User} entity.
 * 
 * @author Andrei Floricel, msg systems ag
 *
 */
@Stateless
public class UserDAO extends AbstractDao<User> {

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}

	public User findUserByEmail(String email) {
		TypedQuery<User> query = this.em.createNamedQuery(User.FIND_USER_BY_EMAIL, User.class);
		query.setParameter("email", email);

		return getSingleResult(query);
	}

	public boolean verifyUserExists(String username, String password) {

		Query query = em.createQuery("SELECT u FROM User u WHERE u.password = :password and u.username =:username");

		query.setParameter("username", username);
		query.setParameter("password", password);

		List<User> userList = query.getResultList();

		return userList.isEmpty() == false;

	}

	public List<User> getAll() {
		Query query = em.createQuery("SELECT u FROM User u");
		List<User> users = query.getResultList();
		return users;
	}
}

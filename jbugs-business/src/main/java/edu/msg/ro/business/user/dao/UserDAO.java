package edu.msg.ro.business.user.dao;

import java.util.List;

import javax.ejb.Stateless;
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

	public User findUserById(Long id) {
		TypedQuery<User> query = this.em.createNamedQuery(User.FIND_USER_BY_ID, User.class);
		query.setParameter("id", id);

		return getSingleResult(query);
	}

	public List<User> findAllUser() {
		TypedQuery<User> query = this.em.createNamedQuery(User.FIND_ALL, User.class);

		return query.getResultList();
	}

	public User findUserByUsername(String username) {
		TypedQuery<User> query = this.em.createNamedQuery(User.FIND_USER_BY_USERNAME, User.class);
		query.setParameter("username", username);

		return getSingleResult(query);
	}

	public User findUserToLogin(String username, String password) {
		TypedQuery<User> query = this.em.createNamedQuery(User.FIND_USER_TO_LOGIN, User.class);
		query.setParameter("username", username);
		query.setParameter("password", password);

		return getSingleResult(query);
	}

}

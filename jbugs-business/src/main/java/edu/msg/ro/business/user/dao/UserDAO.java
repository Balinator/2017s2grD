package edu.msg.ro.business.user.dao;

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

	public User findUserByUsernameAndPass(String username, String password) {
		TypedQuery<User> query = this.em.createNamedQuery(User.FIND_USER_BY_USERNAME_PASS, User.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		return getSingleResult(query);
	}

}

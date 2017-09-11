package edu.msg.ro.business.user.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import edu.msg.ro.business.common.dao.AbstractDao;
import edu.msg.ro.business.common.exception.TechnicalException;
import edu.msg.ro.persistence.user.entity.User;

/**
 * DAO for {@link User} entity.
 * 
 * @author balinc
 *
 */
@Stateless
public class UserDAO extends AbstractDao<User> {

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}

	public User findUserByUsername(String username) throws TechnicalException {
		Query query = em.createQuery("SELECT u FROM User u WHERE u.username = :username");
		query.setParameter("username", username);
		try {
			return (User) query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			throw new TechnicalException(e.getCause());
		}

	}

	public User findUserByEmail(String email) {
		TypedQuery<User> query = this.em.createNamedQuery(User.FIND_USER_BY_EMAIL, User.class);
		query.setParameter("email", email);
		return getSingleResult(query);
	}

	public boolean verifyUserExist(String username, String password) {
		TypedQuery<User> query = this.em.createNamedQuery(User.FIND_USER_BY_USERNAME_PASS, User.class);
		query.setParameter("username", username);
		query.setParameter("password", password);

		List<User> userList = query.getResultList();
		return userList.isEmpty() == false;
	}

	public List<User> getAll() {
		TypedQuery<User> query = this.em.createNamedQuery(User.FIND_ALL, User.class);
		return query.getResultList();
	}

}

package edu.msg.ro.business.user.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import edu.msg.ro.business.common.dao.AbstractDao;
import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.persistence.user.entity.User;

/**
 * DAO for {@link User} entity.
 * 
 * @author balinc
 *
 */
@Stateless
public class UserDAO extends AbstractDao<User> {

	/**
	 * Method for getting the class.
	 */
	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}

	/**
	 * Method for finding {@link User} by given username.
	 * 
	 * @param username
	 * @return
	 * @throws TechnicalExeption
	 */
	public User findUserByUsername(String username) throws TechnicalExeption {
		Query query = em.createQuery("SELECT u FROM User u WHERE u.username = :username");
		query.setParameter("username", username);
		try {
			return (User) query.getSingleResult();
		} catch (Exception e) {
			throw new TechnicalExeption(e.getCause());
		}
	}

	/**
	 * Method for finding {@link User} by given email.
	 * 
	 * @param email
	 * @return
	 */
	public User findUserByEmail(String email) {
		TypedQuery<User> query = this.em.createNamedQuery(User.FIND_USER_BY_EMAIL, User.class);
		query.setParameter("email", email);
		return getSingleResult(query);
	}

	/**
	 * Method for verifying that an {@link User} exist with the given username
	 * and password.
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean verifyUserExist(String username, String password) {
		TypedQuery<User> query = this.em.createNamedQuery(User.FIND_USER_BY_USERNAME_PASS, User.class);
		query.setParameter("username", username);
		query.setParameter("password", password);

		List<User> userList = query.getResultList();
		return userList.isEmpty() == false;
	}

	/**
	 * Method for getting back all the {@link User}s.
	 * 
	 * @return
	 */
	public List<User> getAll() {
		TypedQuery<User> query = this.em.createNamedQuery(User.FIND_ALL, User.class);
		return query.getResultList();
	}

}

package edu.msg.ro.business.user.boundary;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import edu.msg.ro.business.user.dao.UserDAO;
import edu.msg.ro.business.user.util.UserPassword;
import edu.msg.ro.persistence.user.entity.User;

/**
 * @author balinc
 */
@RequestScoped
public class LoginFacade {

	@Inject
	private UserDAO userDao;

	@Inject
	private UserPassword userPass;

	public boolean isValidUser(User user) {
		String passwordHash = null;
		try {
			passwordHash = userPass.encryptPassword(user);
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		User savedUser = userDao.findUserByUsernameAndPass(user.getUsername(), passwordHash);
		if (savedUser == null) {
			return false;
		}
		return true;
	}
}
package edu.msg.ro.business.user.dao;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.common.exception.BusinessException;

/**
 * 
 * @author nagya
 *
 */
public class UserDAOTest extends AbstractIntegrationTest {

	@EJB
	private UserDAO dao;

	/**
	 * Check if list is returned for roles.
	 *
	 * @throws BusinessException
	 */
	@Test
	public void getUsers_succesfull() {
		Assert.assertNotEquals("getUsers is not working", dao.getAll(), null);
	}
}

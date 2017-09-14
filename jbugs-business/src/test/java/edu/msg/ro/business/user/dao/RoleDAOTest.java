package edu.msg.ro.business.user.dao;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.common.exception.BusinessException;

/**
 * Role DAO {@link RoleDAO} test.
 *
 * @author balinc
 *
 */
public class RoleDAOTest extends AbstractIntegrationTest {

	@EJB
	private RoleDAO dao;

	/**
	 * Check if list is returned for roles.
	 *
	 * @throws BusinessException
	 */
	@Test
	public void getRole_succesfull() {
		Assert.assertNotEquals("RoleDAO is not working", dao.getAll(), null);

	}
}
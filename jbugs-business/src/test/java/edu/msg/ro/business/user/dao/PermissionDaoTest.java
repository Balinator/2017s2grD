package edu.msg.ro.business.user.dao;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.common.exception.BusinessException;

/**
 * Permission DAO {@link PermissionDAO} tests.
 *
 * @author balinc
 *
 */
public class PermissionDaoTest extends AbstractIntegrationTest {

	@EJB
	private PermissionDAO sut;

	/**
	 * Check if list is returned for permissions.
	 *
	 * @throws BusinessException
	 */
	@Test
	public void getPermission_succesfull() throws BusinessException {
		Assert.assertNotEquals("PermissionDAO is not working", sut.getAll(), null);

	}
}

package edu.msg.ro.business.user.boundary;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.common.exception.BusinessException;

/**
 * Test for {@link PermissionFacade}
 *
 * @author balinc
 *
 */
public class PermissionFacadeTest extends AbstractIntegrationTest {

	@EJB
	private PermissionFacade sut;

	/**
	 * Check if permission LIST is returned from the database.
	 *
	 * @throws BusinessException
	 */
	@Test
	public void getPermission_succesfull() throws BusinessException {
		Assert.assertNotNull("PermissionFacade is not working", sut.getAll());
	}
}

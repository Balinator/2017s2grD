package edu.msg.ro.business.user.boundary;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.common.exception.BusinessException;

public class PermissionFacadeTest extends AbstractIntegrationTest {

	@EJB
	private PermissionFacade sut;

	@Test
	public void getPermission_succesfull() throws BusinessException {

		Assert.assertNotEquals("PermissionFacade is not working", sut.getAll(), null);
	}
}

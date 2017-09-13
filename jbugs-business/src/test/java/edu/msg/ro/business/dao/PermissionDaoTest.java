package edu.msg.ro.business.dao;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.dao.PermissionDAO;

public class PermissionDaoTest extends AbstractIntegrationTest {

	@EJB
	private PermissionDAO sut;

	@Test
	public void getPermission_succesfull() throws BusinessException {
		Assert.assertNotEquals("PermissionDAO is not working", sut.getAll(), null);

	}
}

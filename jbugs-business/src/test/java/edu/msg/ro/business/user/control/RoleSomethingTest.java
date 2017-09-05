package edu.msg.ro.business.user.control;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.dto.RoleDTO;

public class RoleSomethingTest extends AbstractIntegrationTest {

	@EJB
	private RoleSomething sut;

	@Test
	public void createRole_succesfull() throws BusinessException {
		RoleDTO testRole = new RoleDTO();
		testRole.setNameEng("Admin");
		testRole.setNameRo("Admin");
		RoleDTO createdRole = sut.createRole(testRole);

		Assert.assertNotNull("The newly persisted role should have an id!", createdRole.getId());

		Assert.assertNotNull("The newly persisted role should have an id!", createdRole.getId());

	}

}

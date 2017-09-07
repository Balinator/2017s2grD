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
	public void createRole() throws BusinessException {
		RoleDTO testRole = new RoleDTO();
		testRole.setNameRo("Tester");
		testRole.setNameEng("Tester");
		RoleDTO createdRole = sut.createRole(testRole);
		sut.deleteRole(createdRole);
		Assert.assertNotNull("Id should be not NULL!", createdRole.getId());
	}

}

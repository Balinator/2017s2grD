package edu.msg.ro.business.user.boundary;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.dto.RoleDTO;

public class RoleFacadeTest extends AbstractIntegrationTest {

	@EJB
	private RoleFacade sut;

	@Test
	public void createRole_succesfull() throws BusinessException {
		RoleDTO testRole = new RoleDTO();
		testRole.setNameEng("Tester");
		testRole.setNameRo("Tester");
		RoleDTO createdRole = sut.createRole(testRole);
		Assert.assertNotNull("The newly persisted role should have an id!", createdRole.getNameEng());
	}
}

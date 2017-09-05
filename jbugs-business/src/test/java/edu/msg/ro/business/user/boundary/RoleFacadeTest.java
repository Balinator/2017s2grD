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
		RoleDTO test = new RoleDTO();
		test.setNameEN("John");
		test.setNameRO("Doe");

		RoleDTO created = sut.createRole(test);

		Assert.assertNotNull("The newly persisted role should have an id!", created.getId());
	}

	@Test
	public void updateRole_works() throws BusinessException {
		RoleDTO test = new RoleDTO();
		test.setNameEN("asd2");
		test.setNameRO("qwe2");

		RoleDTO created = sut.createRole(test);

		created.setNameEN("asd3");

		RoleDTO find = sut.updateRole(created);// no set id

		Assert.assertEquals("After update should match!", "asd3", find.getNameEN());
	}

	@Test
	public void deleteRole_works() throws BusinessException {
		RoleDTO test = new RoleDTO();
		test.setNameEN("asd5");
		test.setNameRO("qwe5");

		RoleDTO created = sut.createRole(test);

		Long id = created.getId();

		sut.deleteRole(created);

		RoleDTO find = sut.findRoleById(id);

		Assert.assertNull("After delete should find nothing!", find);
	}
}

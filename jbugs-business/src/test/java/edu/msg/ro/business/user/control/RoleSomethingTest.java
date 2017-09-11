package edu.msg.ro.business.user.control;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.dto.RoleDTO;

public class RoleSomethingTest extends AbstractIntegrationTest {
	@EJB
	private RoleService sut;

	@Test
	public void createRole_works() throws BusinessException {
		RoleDTO test = new RoleDTO();
		test.setNameEN("asd");
		test.setNameRO("qwe");

		RoleDTO created = sut.createRole(test);
		Assert.assertEquals("The names did not match!", created.getNameEN(), test.getNameEN());
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

		RoleDTO find = sut.findById(id);

		Assert.assertNull("After delete should find nothing!", find);
	}
}

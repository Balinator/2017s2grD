package edu.msg.ro.business.user.control;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.dto.PermissionDTO;

public class PermissionSomethingTest extends AbstractIntegrationTest {
	@EJB
	private PermissionService sut;

	@Test
	public void createpermission_works() throws BusinessException {
		PermissionDTO test = new PermissionDTO();
		test.setName("asd");
		test.setDetails("qwe");

		PermissionDTO created = sut.createPermission(test);
		Assert.assertEquals("The names did not match!", created.getName(), test.getName());
	}

	@Test
	public void updatepermission_works() throws BusinessException {
		PermissionDTO test = new PermissionDTO();
		test.setName("asd");
		test.setDetails("qwe");

		PermissionDTO created = sut.createPermission(test);

		created.setName("asd3");

		PermissionDTO find = sut.updatePermission(created);// no set id

		Assert.assertEquals("After update should match!", "asd3", find.getName());
	}

	@Test
	public void deletepermission_works() throws BusinessException {
		PermissionDTO test = new PermissionDTO();
		test.setName("asd");
		test.setDetails("qwe");

		PermissionDTO created = sut.createPermission(test);

		Long id = created.getId();

		sut.deletePermission(created);

		PermissionDTO find = sut.findById(id);

		Assert.assertNull("After delete should find nothing!", find);
	}
}

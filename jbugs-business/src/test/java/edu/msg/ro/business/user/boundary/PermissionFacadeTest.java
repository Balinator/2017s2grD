package edu.msg.ro.business.user.boundary;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.dto.PermissionDTO;

public class PermissionFacadeTest extends AbstractIntegrationTest {
	@EJB
	private PermissionFacede sut;

	@Test
	public void createpermission_succesfull() throws BusinessException {
		PermissionDTO test = new PermissionDTO();
		test.setName("John");
		test.setDetails("Doe");

		PermissionDTO created = sut.createPermission(test);

		Assert.assertNotNull("The newly persisted permission should have an id!", created.getId());
	}

	@Test
	public void updatepermission_works() throws BusinessException {
		PermissionDTO test = new PermissionDTO();
		test.setName("asd2");
		test.setDetails("qwe2");

		PermissionDTO created = sut.createPermission(test);

		created.setName("asd3");

		PermissionDTO find = sut.updatePermission(created);// no set id

		Assert.assertEquals("After update should match!", "asd3", find.getName());
	}

	@Test
	public void deletepermission_works() throws BusinessException {
		PermissionDTO test = new PermissionDTO();
		test.setName("asd5");
		test.setDetails("qwe5");

		PermissionDTO created = sut.createPermission(test);

		Long id = created.getId();

		sut.deletePermission(created);

		PermissionDTO find = sut.findPermissionById(id);

		Assert.assertNull("After delete should find nothing!", find);
	}
}

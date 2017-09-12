package edu.msg.ro.business.user.boundary;

import javax.ejb.EJB;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.user.dao.RoleDAO;

public class RoleFacadeTest extends AbstractIntegrationTest {

	@EJB
	private RoleFacade srt;

	@EJB
	private RoleDAO dao;
	//
	// @Test
	// public void getAllRolesTest() {
	// List<RoleDAO>=dao.findAll();
	// Assert.assertThat(actual, matcher);
	// }

	// @Test
	// @InSequence(1)
	// public void createRole_succesfull() {
	// RoleDTO testRole = new RoleDTO();
	// testRole.setName_EN("Admin");
	// testRole.setName_RO("User");
	// RoleDTO createdRole = srt.createRole(testRole);
	// Assert.assertNotNull("The newly persisted role should have an id!",
	// createdRole.getId());
	// }

}

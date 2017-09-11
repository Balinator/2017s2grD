package edu.msg.ro.business.user.boundary;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.jboss.arquillian.junit.InSequence;
import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.user.dao.RoleDAO;
import edu.msg.ro.business.user.dto.RoleDTO;
import edu.msg.ro.business.user.dto.mapper.RoleDTOMapper;
import edu.msg.ro.persistence.user.entity.Role;

public class RoleFacadeTest extends AbstractIntegrationTest {

	@EJB
	private RoleFacade srt;

	@EJB
	private RoleDAO dao;

	@Inject
	private RoleDTOMapper mapper;

	@Test
	@InSequence(1)
	public void createRole_succesfull() {
		RoleDTO testRole = new RoleDTO();
		testRole.setName_EN("Admin");
		testRole.setName_RO("User");
		RoleDTO createdRole = srt.createRole(testRole);
		Assert.assertNotNull("The newly persisted role should have an id!", createdRole.getId());
	}

	@Test
	@InSequence(2)
	public void updateRole_succesfull() {
		Role role = dao.findEntity(1L);
		Assert.assertNotNull("The role with id 1 should be in the database!", role.getId());
		role.setName_EN("New Admin");
		srt.updateRole(mapper.mapToDTO(role));
		Role updatedRole = dao.findEntity(1L);
		Assert.assertEquals(role.getName_EN(), updatedRole.getName_EN());
	}

	@Test
	@InSequence(3)
	public void deleteRole_succesfull() {
		Role role = dao.findEntity(1L);
		Assert.assertNotNull("The role with id 1 should be in the database!", role.getId());
		srt.deleteRole(mapper.mapToDTO(role));
		Role deletedRole = dao.findEntity(1L);
		Assert.assertNotNull("The role with id 1 should not be in the database!", deletedRole.getId());
	}
}

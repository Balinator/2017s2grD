package edu.msg.ro.business.user.dto.mapper;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.user.dto.RoleDTO;
import edu.msg.ro.persistence.user.entity.Role;

public class RoleDTOMapperTest extends AbstractIntegrationTest {

	@EJB
	RoleDTOMapper sut;

	@Test
	public void mapToDTO_validEntity() {

		Role entity = new Role();
		entity.setLockVersion(1L);
		entity.setName_EN("Name EN");
		entity.setName_RO("Name RO");

		RoleDTO roleDTO = sut.mapToDTO(entity);
		Assert.assertEquals("English name failed.", entity.getName_EN(), roleDTO.getName_EN());
		Assert.assertEquals("Romanian name failed.", entity.getName_RO(), roleDTO.getName_RO());
		Assert.assertEquals("Lock Version failed.", entity.getLockVersion(), roleDTO.getLockVersion());
	}

	@Test
	public void mapToDTO_NullEntity() {
		RoleDTO roleDTO = sut.mapToDTO(null);
		Assert.assertNull("Return value of an NULL input should be also NULL", roleDTO);
	}
}

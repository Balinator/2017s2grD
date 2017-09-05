package edu.msg.ro.business.user.dto.mapper;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.user.dto.RoleDTO;
import edu.msg.ro.persistence.user.entity.Role;

public class RoleDTOMapperTest extends AbstractIntegrationTest {
	@Inject
	RoleDTOMapper sut;

	@Test
	public void mapToDTO_validEntity() {
		// arrange
		Role entity = new Role();
		entity.setNameEN("asd");
		entity.setNameRO("qwe");

		// act

		RoleDTO dto = sut.mapToDTO(entity);

		// assert

		Assert.assertEquals("NameEN mapping failed", entity.getNameEN(), dto.getNameEN());

	}

	@Test
	public void mapToDTO_NullEntity() {
		RoleDTO dto = sut.mapToDTO(null);
		Assert.assertNull("Return value of an NULL input should be also NULL", dto);
	}
}

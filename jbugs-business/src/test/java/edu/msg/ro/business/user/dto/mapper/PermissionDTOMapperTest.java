package edu.msg.ro.business.user.dto.mapper;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.user.dto.PermissionDTO;
import edu.msg.ro.persistence.user.entity.Permission;

public class PermissionDTOMapperTest extends AbstractIntegrationTest {
	@Inject
	PermissionDTOMapper sut;

	@Test
	public void mapToDTO_validEntity() {
		// arrange
		Permission entity = new Permission();
		entity.setName("asd");
		entity.setDetails("qwe");

		// act

		PermissionDTO dto = sut.mapToDTO(entity);

		// assert

		Assert.assertEquals("NameEN mapping failed", entity.getName(), dto.getName());

	}

	@Test
	public void mapToDTO_NullEntity() {
		PermissionDTO dto = sut.mapToDTO(null);
		Assert.assertNull("Return value of an NULL input should be also NULL", dto);
	}
}

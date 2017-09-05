package edu.msg.ro.business.user.dto.mapper;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.persistence.user.entity.User;

public class UserDTOMapperTest extends AbstractIntegrationTest {

	@Inject
	UserDTOMapper sut;

	@Test
	public void mapToDTO_validEntity() {
		// arrange
		User entity = new User();
		entity.setEmail("varadi@msg.com");
		entity.setFirstname("Petger");
		entity.setLastname("Varadi");
		entity.setPassword("msg");
		entity.setLockVersion(1L);
		entity.setPhoneNumber("0729565415");
		entity.setUsername("varadp");
		entity.setActive(true);

		// act

		UserDTO userDTO = sut.mapToDTO(entity);

		// assert

		Assert.assertEquals("Email mapping failed", entity.getEmail(), userDTO.getEmail());
		Assert.assertEquals("FirstName mapping failed", entity.getFirstname(), userDTO.getFirstname());
		Assert.assertEquals("LastName mapping failed", entity.getLastname(), userDTO.getLastname());
		Assert.assertEquals("Password mapping failed", entity.getPassword(), userDTO.getPassword());
		Assert.assertEquals("LockVersion mapping failed", entity.getLockVersion(), userDTO.getLockVersion());
		Assert.assertEquals("PhoneNumbver mapping failed", entity.getPhoneNumber(), userDTO.getPhoneNumber());
		Assert.assertEquals("Username mapping failed", entity.getUsername(), userDTO.getUsername());
		Assert.assertEquals("Active mapping failed", entity.isActive(), userDTO.isActive());

	}

	@Test
	public void mapToDTO_NullEntity() {
		UserDTO userDTO = sut.mapToDTO(null);
		Assert.assertNull("Return value of an NULL input should be also NULL", userDTO);
	}

}

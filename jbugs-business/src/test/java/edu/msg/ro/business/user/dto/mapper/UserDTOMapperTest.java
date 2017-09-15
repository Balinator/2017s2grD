package edu.msg.ro.business.user.dto.mapper;

import java.util.ArrayList;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.persistence.user.entity.User;

public class UserDTOMapperTest extends AbstractIntegrationTest {

	@EJB
	UserDTOMapper sut;

	@Test
	public void mapToDTO_validEntity() {

		User entity = new User();
		entity.setEmail("test@msg.com");
		entity.setFirstname("Ale");
		entity.setLastname("Mihai");
		entity.setPassword("msg");
		entity.setLockVersion(1L);
		entity.setPhoneNumber("54545");
		entity.setUsername("msg");
		entity.setActive(true);
		entity.setRoles(new ArrayList<>());

		UserDTO userDTO = sut.mapToDTO(entity);

		Assert.assertEquals("Email mapping failed", entity.getEmail(), userDTO.getEmail());
		Assert.assertEquals("First name mapping failed", entity.getFirstname(), userDTO.getFirstname());
		Assert.assertEquals("Last name mapping failed", entity.getLastname(), userDTO.getLastname());
		Assert.assertEquals("Password mapping failed", entity.getPassword(), userDTO.getPassword());
		Assert.assertEquals("LockVersion mapping failed", entity.getLockVersion(), userDTO.getLockVersion());
		Assert.assertEquals("Phone Number mapping failed", entity.getPhoneNumber(), userDTO.getPhoneNumber());
		Assert.assertEquals("Username mapping failed", entity.getUsername(), userDTO.getUsername());

		// @Todo check for roles to when implemented the rols.
		// Assert.assertEquals("Active mapping failed", entity.get,
		// userDTO.get);
		Assert.assertEquals("Roles mapping failed", entity.isActive(), userDTO.isActive());

	}

	/**
	 * Check for null entity.
	 */
	@Test
	public void mapToDTO_NullEntity() {
		UserDTO userDTO = sut.mapToDTO(null);
		Assert.assertNull("Return value of an NULL input should be also NULL", userDTO);
	}

}

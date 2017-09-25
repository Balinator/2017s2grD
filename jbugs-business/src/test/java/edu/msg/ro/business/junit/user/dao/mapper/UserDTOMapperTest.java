package edu.msg.ro.business.junit.user.dao.mapper;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.dto.mapper.RoleDTOMapper;
import edu.msg.ro.business.user.dto.mapper.UserDTOMapper;
import edu.msg.ro.persistence.user.entity.User;

@RunWith(MockitoJUnitRunner.class)
public class UserDTOMapperTest {

	@InjectMocks
	UserDTOMapper sut;

	@Mock
	RoleDTOMapper roleDTOMapper;

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
		sut.mapEntityToDTOFields(entity, userDTO);

		Assert.assertEquals("Email mapping failed", entity.getEmail(), userDTO.getEmail());
		Assert.assertEquals("First name mapping failed", entity.getFirstname(), userDTO.getFirstname());
		Assert.assertEquals("Last name mapping failed", entity.getLastname(), userDTO.getLastname());
		Assert.assertEquals("Password mapping failed", entity.getPassword(), userDTO.getPassword());
		Assert.assertEquals("LockVersion mapping failed", entity.getLockVersion(), userDTO.getLockVersion());
		Assert.assertEquals("Phone Number mapping failed", entity.getPhoneNumber(), userDTO.getPhoneNumber());
		Assert.assertEquals("Username mapping failed", entity.getUsername(), userDTO.getUsername());

		Assert.assertEquals("Active mapping failed", entity.getRoles(), userDTO.getRoles());
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

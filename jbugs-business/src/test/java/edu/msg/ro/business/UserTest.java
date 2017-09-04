package edu.msg.ro.business;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.dto.UserDTO;
import edu.msg.ro.business.ejbs.UserEjb;

public class UserTest extends AbstractIntegrationTest {

	@EJB
	private UserEjb sut;

	@Test
	public void testUserEjb_createUser() {
		// arrange
		UserDTO user = new UserDTO();
		user.setFirstName("Peter");
		user.setLastName("Varadi");
		UserDTO createdUser = sut.createUser(user);

		Assert.assertNotNull(createdUser.getId());
		Assert.assertEquals("Varadi", user.getLastName());
		Assert.assertEquals("Peter", user.getFirstName());
	}

}

package edu.msg.ro.business.user.boundary;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.business.user.dto.UserDTO;

/**
 * Test for {@link UserFacade} facede.
 *
 * @author balinc
 *
 */
public class UserFacadeTest extends AbstractIntegrationTest {

	@EJB
	private UserFacade sut;

	/**
	 * Check if user insert is working.
	 *
	 * @throws BusinessException
	 * @throws TechnicalExeption
	 */
	@Test
	public void createUser_succesfull() throws BusinessException, TechnicalExeption {
		UserDTO testUser = new UserDTO();
		testUser.setFirstname("John");
		testUser.setLastname("Doe");

		UserDTO createdUser = sut.createUser(testUser);

		Assert.assertNotNull("The newly persisted user should have an id!", createdUser.getId());
	}

	/**
	 * 
	 * Check if the user is active by default.
	 *
	 * @throws BusinessException
	 * @throws TechnicalExeption
	 */
	@Test
	public void createUser_ActiveByDefault() throws BusinessException, TechnicalExeption {
		UserDTO testUser = new UserDTO();
		testUser.setFirstname("John");
		testUser.setLastname("Doe");
		testUser.setEmail("test@msggroup.com");
		UserDTO createdUser = sut.createUser(testUser);
		Assert.assertTrue("The newly persisted user should be active!", createdUser.isActive());
	}

	/**
	 * Test if username is not NULL
	 * 
	 * @throws BusinessException
	 * @throws TechnicalExeption
	 */
	@Test
	public void createUserWithUsername() throws BusinessException, TechnicalExeption {
		UserDTO user = new UserDTO();
		user.setFirstname("Mihai");
		user.setLastname("Popescu");
		UserDTO createdUser = sut.createUser(user);
		Assert.assertNotNull("The created user should have username!", createdUser.getUsername());
	}

	/**
	 * Check if username is correct
	 * 
	 * @throws TechnicalExeption
	 * @throws BusinessException
	 */
	public void createUserWithCorrectUsername() throws BusinessException, TechnicalExeption {
		UserDTO user = new UserDTO();
		user.setFirstname("Nemeth");
		user.setLastname("Attila");
		UserDTO createdUser = sut.createUser(user);
		Assert.assertEquals("The created username should match the exrpesssion !", "AttilaN",
				createdUser.getUsername());
	}

	/**
	 * Check if username generator works correctly when username already exists
	 * 
	 * @throws BusinessException
	 * @throws TechnicalExeption
	 */
	public void createUserWithExistingUsername() throws BusinessException, TechnicalExeption {
		UserDTO user = new UserDTO();
		user.setFirstname("Nemeth");
		user.setLastname("Attila");
		UserDTO createdUser = sut.createUser(user);
		UserDTO user2 = new UserDTO();
		user2.setFirstname("Nemeth");
		user2.setLastname("Attila");
		UserDTO createdUser2 = sut.createUser(user2);
		Assert.assertEquals("The created username should match the exrpesssion !", "AttilaNe",
				createdUser.getUsername());
	}

}

package edu.msg.ro.business.user.control;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.business.user.dto.UserDTO;

/**
 * 
 * Test for {@link UserService}
 *
 * @author balinc
 *
 */
public class UserServiceTest extends AbstractIntegrationTest {

	@EJB
	private UserService uService;

	/**
	 * Test if email not containing the required format.
	 *
	 * @throws BusinessException
	 * @throws TechnicalExeption
	 */
	@Test
	public void createUser_EmailValidationFail() throws BusinessException, TechnicalExeption {
		UserDTO testUser = new UserDTO();
		testUser.setFirstname("John");
		testUser.setLastname("Doe");

		// Invalid email, needts to be @msggroup.com
		testUser.setEmail("unique@mail.com");

		try {
			UserDTO createdUser = uService.createUser(testUser);
		} catch (EJBTransactionRolledbackException e) {
			Assert.assertEquals("Exception thrown from bean", e.getCause().getMessage());
			return;
		}

		Assert.fail("Email validation should fail!");
	}

	/**
	 * Test if fail the user insert with same email address.
	 *
	 * @throws BusinessException
	 * @throws TechnicalExeption
	 */
	@Test
	public void createUser_UniqueEmailFail() throws BusinessException, TechnicalExeption {
		UserDTO testUser = new UserDTO();
		testUser.setFirstname("John");
		testUser.setLastname("Doe");
		testUser.setEmail("unique@msggroup.com");

		UserDTO createdUser = uService.createUser(testUser);

		UserDTO testUser2 = new UserDTO();
		testUser2.setFirstname("Mary");
		testUser2.setLastname("Jane");
		testUser2.setEmail("unique@msggroup.com");

		try {
			UserDTO createdUser2 = uService.createUser(testUser2);
		} catch (BusinessException e) {
			Assert.assertEquals("User already exists with given email unique@msggroup.com", e.getMessage());
			return;
		}
		Assert.fail("Email validation should fail!");
	}

}
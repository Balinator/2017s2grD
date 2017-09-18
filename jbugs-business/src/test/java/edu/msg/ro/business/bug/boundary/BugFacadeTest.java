package edu.msg.ro.business.bug.boundary;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.business.user.boundary.UserFacade;
import edu.msg.ro.business.user.dto.UserDTO;

/**
 * 
 * @author nagya
 *
 */

public class BugFacadeTest extends AbstractIntegrationTest {

	@EJB
	private BugFacade sut;

	@EJB
	private UserFacade uf;

	/**
	 * Check if bug insert is working.
	 *
	 * @throws BusinessException
	 * @throws TechnicalExeption
	 */
	@Test
	public void createBug_succesfull() throws BusinessException, TechnicalExeption {
		UserDTO testUser = new UserDTO();
		testUser.setId(2L);
		testUser.setFirstname("Mary");
		testUser.setLastname("Jane");
		testUser.setEmail("asd@msggroup.com");
		testUser.setPassword("asd");
		testUser.setRoles(new ArrayList<>());
		uf.createUser(testUser);

		Assert.assertNotNull("The user should have an id", testUser.getId());

		Date date = new Date();

		BugDTO testBug = new BugDTO();
		testBug.setTitle("Bug title");
		testBug.setDescription("Description");
		testBug.setAssigned(testUser);
		testBug.setAuthor(testUser);
		testBug.setVersion("v2.0");
		testBug.setFixedIn("v2.2");
		testBug.setTargetDate(date);
		testBug.setSeverity("bug");
		testBug.setStatus("Open");

		BugDTO createdBug = sut.createBug(testBug);

		Assert.assertNotNull("The newly persisted Bug should have an id!", createdBug.getId());
	}
}

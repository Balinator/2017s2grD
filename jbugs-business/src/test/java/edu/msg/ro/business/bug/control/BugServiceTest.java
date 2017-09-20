package edu.msg.ro.business.bug.control;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.bug.boundary.BugFacade;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.business.user.boundary.UserFacade;
import edu.msg.ro.business.user.control.UserService;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.dto.mapper.UserDTOMapper;

/**
 * Test for BugService
 * 
 * @author fulops
 *
 */
public class BugServiceTest extends AbstractIntegrationTest {

	@EJB
	private BugFacade bf;

	@EJB
	private UserFacade uf;

	@EJB
	private UserDTOMapper userDTOMapper;

	@EJB
	private UserService userService;

	@Test
	public void createBug_CreatedID() throws BusinessException {
		BugDTO testBug = new BugDTO();

		testBug.setTitle("title test bug");
		testBug.setDescription("Bug test description!");
		testBug.setSeverity("Bug test severity!");
		testBug.setVersion("v1.0");
		testBug.setFixedIn("Fixed bug test");

		Date newDate = new Date();
		newDate.getDate();
		testBug.setTargetDate(newDate);

		testBug.setStatus("Bug status test");
		testBug.setVersion("Version!");

		UserDTO testUser = new UserDTO();
		testUser.setFirstname("Bsdfds");
		testUser.setLastname("dsfsd");
		testUser.setEmail("dsfsd@msggroup.com");
		testUser.setPassword("asd");
		testUser.setRoles(new ArrayList<>());

		UserDTO testUser1 = new UserDTO();
		testUser1.setFirstname("Bsfddfds");
		testUser1.setLastname("dssdfsdfsd");
		testUser1.setEmail("dsdsffsd@msggroup.com");
		testUser1.setPassword("assadd");
		testUser1.setRoles(new ArrayList<>());

		try {
			uf.createUser(testUser);
			uf.createUser(testUser1);
		} catch (Exception e) {
			e.getCause();
			System.err.println(e.getCause().getMessage());
			System.err.println(testUser.getId());
		}

		Assert.assertNotNull("User ID: ", testUser.getId());
		Assert.assertNotNull("User1 ID: ", testUser1.getId());

		System.err.println(testUser.getId());
		System.err.println(testUser.getId());

		testBug.setAuthor(testUser);
		testBug.setAssigned(testUser1);

		BugDTO createdBug = null;
		try {
			createdBug = bf.createBug(testBug);
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (TechnicalExeption e) {
			e.printStackTrace();
		}

		Assert.assertNotNull("Shold have id: ", createdBug.getId());
	}

	@Test
	public void updateBug_UpdatedTestBug() throws BusinessException {
		BugDTO testBug = new BugDTO();

		testBug.setTitle("title test bug");
		testBug.setDescription("Bug test description!");
		testBug.setSeverity("Bug test severity!");
		testBug.setVersion("v1.0");
		testBug.setFixedIn("Fixed bug test");
		Date newDate = new Date();
		newDate.getDate();
		testBug.setTargetDate(newDate);
		testBug.setStatus("Bug status test updated");
		testBug.setVersion("Version updated!");

		BugDTO newBug = new BugDTO();

		newBug.setTitle("title test bug updated");
		newBug.setDescription("Bug test description updated!");
		newBug.setSeverity("Bug test severity updated!");
		newBug.setVersion("v1.0 updated");
		newBug.setFixedIn("Fixed bug test updated");

		Date newDate1 = new Date();
		newDate1.getDate();
		testBug.setTargetDate(newDate1);

		newBug.setStatus("Bug status test updated");
		newBug.setVersion("Version updated!");

		UserDTO testUser = new UserDTO();
		testUser.setUsername("sadas");
		testUser.setRoles(new ArrayList<>());

		UserDTO testUser1 = new UserDTO();
		testUser1.setUsername("AssignedMan");
		testUser1.setRoles(new ArrayList<>());

		Assert.assertNotNull("User ID: ", testUser.getId());
		Assert.assertNotNull("User1 ID: ", testUser1.getId());

		try {
			uf.createUser(testUser);
			uf.createUser(testUser1);
		} catch (BusinessException e1) {
			e1.printStackTrace();
		}

		Assert.assertNotNull("User ID: ", testUser.getId());
		Assert.assertNotNull("User1 ID: ", testUser1.getId());

		BugDTO createdBug = null;
		try {
			createdBug = bf.createBug(testBug);
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (TechnicalExeption e) {
			e.printStackTrace();
		}

		BugDTO bugUpdate = null;
		try {
			bugUpdate = bf.updateBug(newBug);
		} catch (TechnicalExeption e) {
			e.printStackTrace();
		}

		Assert.assertEquals("Update bug issue!", bugUpdate.getTitle());
	}

	@Test
	public void deleteBug_deleteBugTest() throws TechnicalExeption {
		BugDTO testBug = new BugDTO();

		testBug.setTitle("title test bug");
		testBug.setDescription("Bug test description!");
		testBug.setSeverity("Bug test severity!");
		testBug.setVersion("v1.0");
		testBug.setFixedIn("Fixed bug test");
		Date newDate = new Date();
		newDate.getDate();
		testBug.setTargetDate(newDate);
		testBug.setStatus("Bug status test updated");
		testBug.setVersion("Version updated!");

		UserDTO testUser = new UserDTO();
		testUser.setUsername("sadas");
		testUser.setRoles(new ArrayList<>());

		UserDTO testUser1 = new UserDTO();
		testUser1.setUsername("AssignedMan");
		testUser1.setRoles(new ArrayList<>());

		Assert.assertNotNull("User ID: ", testUser.getId());
		Assert.assertNotNull("User1 ID: ", testUser1.getId());

		testBug.setAuthor(testUser);
		testBug.setAuthor(testUser1);

		try {
			uf.createUser(testUser);
			uf.createUser(testUser1);
		} catch (BusinessException e1) {
			e1.printStackTrace();
		}

		Assert.assertNotNull("User ID: ", testUser.getId());
		Assert.assertNotNull("User1 ID: ", testUser1.getId());

		BugDTO deletedBug = null;
		deletedBug = bf.deleteBug(testBug);

		Assert.assertNotNull("Deleted bug is not null!", deletedBug);
	}

	@Test
	public void getAllBug_test() {
		Assert.assertNotNull("Get all bugs issue:", bf.getAllbugs());
	}

}

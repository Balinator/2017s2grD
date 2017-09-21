package edu.msg.ro.business.bug.control;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.business.user.control.UserService;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.dto.mapper.UserDTOMapper;
import edu.msg.ro.business.util.TestHelper;
import edu.msg.ro.persistence.bug.entity.StatusEnum;

/**
 * Test for BugService
 * 
 * @author fulops
 *
 */
public class BugServiceTest extends AbstractIntegrationTest {

	@EJB
	private BugService bf;

	@EJB
	private UserService uf;

	@EJB
	private UserDTOMapper userDTOMapper;

	@EJB
	private UserService userService;

	@EJB
	private TestHelper th;

	@Test
	public void createBug_CreatedID() throws BusinessException, TechnicalExeption {
		UserDTO testUser = th.initializUser(5L, "Mary", "Jane", "asd@msggroup.com", "asd", "0756748395");
		UserDTO testUser1 = th.initializUser(6L, "Marsdy", "Jasdne", "asdsd@msggroup.com", "asdsd", "0756748395");

		uf.createUser(testUser);
		uf.createUser(testUser1);

		BugDTO testBug = th.initializingBug(1L, "Bug title", "Description", "v2.2", "Open", "bug",
				StatusEnum.INPROGRESS, testUser);
		Assert.assertNotNull("Bug should have an id", testBug.getId());

		BugDTO createdBug = bf.createBug(testBug);
		Assert.assertNotNull("The newly persisted Bug should have an id!", createdBug.getId());

		testBug.setAuthor(testUser);
		testBug.setAssigned(testUser1);

		Assert.assertNotNull("Shold have id: ", createdBug.getId());
	}

	// /**
	// * if update is not working
	// *
	// * @throws BusinessException
	// * @throws TechnicalExeption
	// */
	// @Test
	// public void updateBug_UpdatedTestBug() throws BusinessException,
	// TechnicalExeption {
	//
	// UserDTO testUser = th.initializUser(5L, "Mary", "Jane",
	// "asd@msggroup.com", "asd", "0756748395");
	// UserDTO testUser1 = th.initializUser(6L, "Marsdy", "Jasdne",
	// "asdsd@msggroup.com", "asdsd", "0756748395");
	//
	// uf.createUser(testUser);
	// uf.createUser(testUser1);
	//
	// Assert.assertNotNull("User ID: ", testUser.getId());
	// Assert.assertNotNull("User1 ID: ", testUser1.getId());
	//
	// BugDTO testBug = th.initializingBug(1L, "Bug title", "Description",
	// "v2.0", "v2.2", "bug", "Open", testUser);
	// Assert.assertNotNull("Bug should have an id", testBug.getId());
	//
	// BugDTO newBug = th.initializingBug(1L, "Bug title updated", "Description
	// updated", "v2.0 updated",
	// "v2.2 updated", "bug updated", "Open updated", testUser);
	//
	// testBug.setAuthor(testUser);
	// testBug.setAssigned(testUser1);
	// newBug.setAuthor(testUser);
	// newBug.setAssigned(testUser1);
	//
	// BugDTO createdBug = null;
	// createdBug = bf.createBug(testBug);
	// Assert.assertNotNull("Bug ID: ", createdBug.getId());
	// String createdBugTitle = createdBug.getTitle();
	//
	// createdBug = bf.updateBug(newBug);
	//
	// Assert.assertNotEquals("Update bug issue!", createdBugTitle,
	// createdBug.getTitle());
	// }

	/**
	 * If deleted bug is not null
	 *
	 * @throws TechnicalExeption
	 * @throws BusinessException
	 */
	@Test
	public void deleteBug_deleteBugTest() throws TechnicalExeption, BusinessException {

		UserDTO testUser = th.initializUser(5L, "Mary", "Jane", "asd@msggroup.com", "asd", "0756748395");
		UserDTO testUser1 = th.initializUser(6L, "Marsdy", "Jasdne", "asdsd@msggroup.com", "asdsd", "0756748395");

		uf.createUser(testUser);
		uf.createUser(testUser1);

		Assert.assertNotNull("User ID: ", testUser.getId());
		Assert.assertNotNull("User1 ID: ", testUser1.getId());

		BugDTO testBug = th.initializingBug(1L, "Bug title", "Description", "v2.0", "v2.2", "bug",
				StatusEnum.INPROGRESS, testUser);
		Assert.assertNotNull("Bug should have an id", testBug.getId());

		testBug.setAuthor(testUser);
		testBug.setAuthor(testUser1);

		BugDTO deleteBug = null;
		deleteBug = bf.createBug(testBug);
		Assert.assertNotNull("Shold have id: ", deleteBug.getId());

		deleteBug = bf.deleteBug(testBug);

		Assert.assertEquals("Closed bug!", "CLOSED", deleteBug.getStatus());
	}

	/**
	 * if bugs null
	 * 
	 * @throws TechnicalExeption
	 * @throws BusinessException
	 */
	@Test
	public void getAllBug_test() throws BusinessException, TechnicalExeption {
		Assert.assertNotNull("Get all bugs issue:", bf.getAllBugs());
	}

}

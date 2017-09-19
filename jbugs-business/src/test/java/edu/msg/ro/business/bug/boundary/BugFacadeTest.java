package edu.msg.ro.business.bug.boundary;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.business.user.boundary.UserFacade;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.util.TestHelper;

/**
 * 
 * @author nagya
 *
 */

public class BugFacadeTest extends AbstractIntegrationTest {

	@EJB
	private BugFacade sut;

	@EJB
	private TestHelper th;

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
		UserDTO testUser = th.initializUser(5L, "Mary", "Jane", "asd@msggroup.com", "asd", "0756748395");
		uf.createUser(testUser);
		Assert.assertNotNull("The user should have an id", testUser.getId());
		BugDTO testBug = th.initializingBug(1L, "Bug title", "Description", "v2.0", "v2.2", "bug", "Open", testUser);
		Assert.assertNotNull("Bug should have an id", testBug.getId());
		BugDTO createdBug = sut.createBug(testBug);
		Assert.assertNotNull("The newly persisted Bug should have an id!", createdBug.getId());
	}

	@Test
	public void updateBug_UpdatedTestBug() throws BusinessException, TechnicalExeption {

		UserDTO testUser = th.initializUser(4L, "Mary", "Jane", "asd@msggroup.com", "asd", "0756748395");
		UserDTO testUser2 = th.initializUser(6L, "Mary2", "Jane2", "assd@msggroup.com", "asd2", "0756748395");
		BugDTO testBug = th.initializingBug(123L, "Bug title", "Description", "v2.0", "v2.2", "bug", "Open", testUser);
		BugDTO createdBug = sut.createBug(testBug);

		BugDTO newBug = th.initializingBug(245L, "Bug title2", "Description2", "v2.2", "v2.2.2", "bug2", "Closed",
				testUser2);

		String createdBugTitle = createdBug.getTitle();

		createdBug = sut.updateBug(newBug);

		Assert.assertEquals("Update bug issue!", createdBugTitle, newBug.getTitle());
	}

	@Test
	public void deleteBug_deleteBugTest() throws TechnicalExeption, BusinessException {
		UserDTO testUser = th.initializUser(8L, "Mary", "Jane", "asd@msggroup.com", "asd", "0756748395");
		uf.createUser(testUser);
		BugDTO testBug = th.initializingBug(2L, "Bug title", "Description", "v2.0", "v2.2", "bug", "Open", testUser);
		sut.createBug(testBug);
		BugDTO deletedBug = null;
		deletedBug = sut.deleteBug(testBug);
		Assert.assertNull(deletedBug.toString(), deletedBug.getId());
	}

	@Test
	public void getAllbugs_succesfull() {
		Assert.assertNotNull("getAllbugs not working", sut.getAllbugs());
	}

}

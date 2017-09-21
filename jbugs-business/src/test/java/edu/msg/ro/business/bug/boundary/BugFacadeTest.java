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
import edu.msg.ro.persistence.bug.entity.StatusEnum;

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
<<<<<<< HEAD
		UserDTO testUser = th.initializUser(5L, "Mary", "Jane", "asd@msggroup.com", "asd", "0756748395");
		uf.createUser(testUser);
		Assert.assertNotNull("The user should have an id", testUser.getId());
		BugDTO testBug = th.initializingBug(1L, "Bug title", "Description", "v2.0", "Open", "bug",
				StatusEnum.INPROGRESS, testUser);
		Assert.assertNotNull("Bug should have an id", testBug.getId());
=======
		UserDTO testUser = th.initializUser("Mary", "Jane", "asd@msggroup.com", "asd", "0756748395");
		UserDTO createdUser = uf.createUser(testUser);

		BugDTO testBug = th.initializingBug("Bug title", "Description", "v2.0", "v2.2", "bug", "Open", createdUser);
>>>>>>> 2ef23f6584259f31d7e5e0988482955eee5c24e1
		BugDTO createdBug = sut.createBug(testBug);
		Assert.assertNotNull("The newly persisted Bug should have an id!", createdBug.getId());
	}

	@Test
	public void deleteBug_deleteBugTest() throws TechnicalExeption, BusinessException {
<<<<<<< HEAD
		UserDTO testUser = th.initializUser(8L, "Mary", "Jane", "asd@msggroup.com", "asd", "0756748395");
		uf.createUser(testUser);
		BugDTO testBug = th.initializingBug(2L, "Bug title", "Description", "v2.0", "v2.2", "bug",
				StatusEnum.INPROGRESS, testUser);
		sut.createBug(testBug);
		BugDTO deletedBug = null;
		deletedBug = sut.deleteBug(testBug);
		Assert.assertNull(deletedBug.toString(), deletedBug.getId());
=======
		UserDTO createdUser = uf.createUser(th.initializUser("Mary", "Jane", "asd@msggroup.com", "asd", "0756748395"));
		BugDTO createdBug = sut
				.createBug(th.initializingBug("Bug title", "Description", "v2.0", "v2.2", "bug", "Open", createdUser));
		BugDTO deletedBug = sut.deleteBug(createdBug);
		Assert.assertNull("Bug should be null", deletedBug);
>>>>>>> 2ef23f6584259f31d7e5e0988482955eee5c24e1
	}

	@Test
	public void getAllbugs_succesfull() {
		Assert.assertNotNull("getAllbugs not working", sut.getAllbugs());
	}

}

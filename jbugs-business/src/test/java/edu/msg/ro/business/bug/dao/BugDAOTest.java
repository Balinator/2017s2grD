package edu.msg.ro.business.bug.dao;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.util.TestHelper;

/**
 * 
 * @author nagya
 *
 */

public class BugDAOTest extends AbstractIntegrationTest {

	@EJB
	private BugDAO bdao;

	@EJB
	private TestHelper th;

	/**
	 * Check if list is returned for bugs.
	 */
	@Test
	public void getallBug_succesfull() {
		Assert.assertNotEquals("BugDAO is not working", bdao.getAll(), null);

	}

	/**
	 * Check if a bug is returned by the id.
	 * 
	 * @throws BusinessException
	 */
	@Test
	public void getBugbyId_succesfull() throws BusinessException {
		UserDTO testUser = th.initializUser(4L, "Mary", "Jane", "asd@msggroup.com", "asd", "0756748395");
		BugDTO testBug = th.initializingBug(1L, "Bug title", "Description", "v2.0", "v2.2", "bug", "Open", testUser);
		Assert.assertNotEquals("GetBug by Id is not working", bdao.getBug(1L), null);

	}

}

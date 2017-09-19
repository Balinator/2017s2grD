package edu.msg.ro.business.bug.dao;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;

/**
 * 
 * @author nagya
 *
 */

public class BugDAOTest extends AbstractIntegrationTest {

	@EJB
	private BugDAO bdao;

	/**
	 * Check if list is returned for bugs.
	 */
	@Test
	public void getallBug_succesfull() {
		Assert.assertNotEquals("BugDAO is not working", bdao.getAll(), null);

	}

	/**
	 * Check if a bug is returned by the id.
	 */
	@Test
	public void getBugbyId_succesfull() {
		Assert.assertNotEquals("GetBug by Id is not working", bdao.getBug(1L), null);

	}

}

package edu.msg.ro.business.bug.boundary;

import javax.ejb.EJB;

import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.boundary.UserFacade;

/**
 * 
 * @author nagya
 *
 */

class BugFacadeTest extends AbstractIntegrationTest {

	@EJB
	private UserFacade sut;

	/**
	 * Check if bug insert is working.
	 *
	 * @throws BusinessException
	 */
	@Test
	public void createBug_succesfull() throws BusinessException {
	}
}

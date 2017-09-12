package edu.msg.ro.business.user.boundary;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;

public class RoleFacadeTest extends AbstractIntegrationTest {

	@EJB
	private RoleFacade srt;

	@Test
	public void RoleFacade_test() {
		Assert.assertNotEquals("RoleFacade is not working", srt.getAllUsers(), null);

	}

}

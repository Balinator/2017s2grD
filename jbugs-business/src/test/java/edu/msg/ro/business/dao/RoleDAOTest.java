package edu.msg.ro.business.dao;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.user.dao.RoleDAO;

public class RoleDAOTest extends AbstractIntegrationTest {

	@EJB
	private RoleDAO dao;

	@Test
	public void RoleDAO_test() {
		Assert.assertNotEquals("RoleDAO is not working", dao.findAll(), null);

	}
}

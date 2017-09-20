package edu.msg.ro.business.user.dao;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.bug.boundary.BugFacade;
import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.common.exception.TechnicalExeption;
import edu.msg.ro.business.user.boundary.UserFacade;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.dto.mapper.UserDTOMapper;
import edu.msg.ro.business.util.TestHelper;
import edu.msg.ro.persistence.user.entity.User;

/**
 * 
 * @author nagya
 *
 */
public class UserDAOTest extends AbstractIntegrationTest {

	@EJB
	private UserDAO dao;

	@EJB
	private UserFacade uf;

	@EJB
	private BugFacade bf;

	@EJB
	private TestHelper th;

	@EJB
	private UserDTOMapper udm;

	/**
	 * Check if list is returned for roles.
	 *
	 * @throws BusinessException
	 */
	@Test
	public void getUsers_succesfull() {

		Assert.assertNotEquals("getUsers is not working", dao.getAll(), null);
	}

	/**
	 * Check if user is returned for an username.
	 *
	 * @throws BusinessException
	 * @throws TechnicalExeption
	 */
	@Test
	public void findUserByUsername_succesfull() throws BusinessException, TechnicalExeption {
		UserDTO user = th.initializUser("Mary", "Jane", "asd@msggroup.com", "asd", "0756748395");
		uf.createUser(user);

		Assert.assertEquals("Should have an user with JanosF username",
				dao.findUserByUsername(user.getUsername()).getUsername(), user.getUsername());

	}

	/**
	 * Check if user is returned for an email.
	 *
	 * @throws BusinessException
	 * @throws TechnicalExeption
	 */
	@Test
	public void findUserByEmail_succesfull() throws TechnicalExeption, BusinessException {
		UserDTO user = th.initializUser("Fulop", "Lajos", "lajoska2@msggroup.com", "asd", "0756748395");
		uf.createUser(user);
		Assert.assertEquals("Should have an user with lajoska2@msggroup.com email ",
				dao.findUserByEmail(user.getEmail()).getEmail(), user.getEmail());
	}

	/**
	 * Check if the user exist.
	 *
	 * @throws BusinessException
	 * @throws TechnicalExeption
	 */
	@Test
	public void verifyUserExist_succesfull() throws BusinessException {
		UserDTO user = th.initializUser("Fulop", "Gabor", "gabika@msggroup.com", "asd", "0756748395");
		uf.createUser(user);
		Assert.assertEquals("User should exist  ", dao.verifyUserExist(user.getUsername(), user.getPassword()), true);
	}

	/**
	 * Checks if user does not have bugs assigned
	 * 
	 * @throws BusinessException
	 */
	@Test
	public void checkIfUserHasNoAssignedBugs() throws BusinessException {
		UserDTO user = th.initializUser(null, "Denis", "Vasile", "denis@msggroup.com", "123456", "0040743189869");
		UserDTO userDTO = uf.createUser(user);
		User userEntity = new User();
		udm.mapToEntity(userDTO, userEntity);
		boolean hasAssignedBug = dao.checkIfUserHasAssignedBugs(userEntity);
		Assert.assertEquals("User should not have assigned bug(s)!", false, hasAssignedBug);
	}

	/*
	 * public void checkIfUserHasAssignedBugs() throws BusinessException,
	 * TechnicalExeption { serDTO user = th.initializUser(null, "Denis",
	 * "Viorel", "denisV@msggroup.com", "123456", "0040743188876"); UserDTO
	 * userDTO = uf.createUser(user); User userEntity = new User();
	 * udm.mapToEntity(userDTO, userEntity); BugDTO bug =
	 * th.initializingBug(null, "Title", "Description", "LOW", "v1", "fixed",
	 * "Closed", userDTO); BugDTO bugDTO = bf.createBug(bug); boolean
	 * hasAssignedBug = dao.checkIfUserHasAssignedBugs(userEntity);
	 * Assert.assertEquals("User should have assigned bug(s)!", true,
	 * hasAssignedBug); }
	 */

}

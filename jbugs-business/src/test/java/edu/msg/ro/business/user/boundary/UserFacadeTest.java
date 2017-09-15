package edu.msg.ro.business.user.boundary;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.dao.PermissionDAO;
import edu.msg.ro.business.user.dao.RoleDAO;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.security.PermissionChecker;
import edu.msg.ro.persistence.user.entity.Permission;
import edu.msg.ro.persistence.user.entity.Role;

/**
 * Test for {@link UserFacade} facede.
 *
 * @author balinc
 *
 */
public class UserFacadeTest extends AbstractIntegrationTest {

	@EJB
	private UserFacade sut;
	@EJB
	private PermissionChecker permCheck;

	/**
	 * Check if user insert is working.
	 *
	 * @throws BusinessException
	 */
	@Test
	public void createUser_succesfull() throws BusinessException {
		UserDTO testUser = new UserDTO();
		testUser.setFirstname("John");
		testUser.setLastname("Doe");
		testUser.setPassword("123456");

		UserDTO createdUser = sut.createUser(testUser);

		Assert.assertNotNull("The newly persisted user should have an id!", createdUser.getId());
	}

	/**
	 * 
	 * Check if the user is active by default.
	 *
	 * @throws BusinessException
	 */
	@Test
	public void createUser_ActiveByDefault() throws BusinessException {
		UserDTO testUser = new UserDTO();
		testUser.setFirstname("John");
		testUser.setLastname("Doe");
		testUser.setEmail("test@msggroup.com");
		testUser.setPassword("123456");
		UserDTO createdUser = sut.createUser(testUser);
		Assert.assertTrue("The newly persisted user should be active!", createdUser.isActive());
	}

	/**
	 * Test if username is not NULL
	 * 
	 * @throws BusinessException
	 */
	@Test
	public void createUserWithUsername() throws BusinessException {
		UserDTO user = new UserDTO();
		user.setFirstname("Mihai");
		user.setLastname("Popescu");
		user.setPassword("123456");
		UserDTO createdUser = sut.createUser(user);
		Assert.assertNotNull("The created user should have username!", createdUser.getUsername());
	}

	/**
	 * Check if username is correct
	 * 
	 * @throws BusinessException
	 */
	@Test
	public void createUserWithCorrectUsername() throws BusinessException {
		UserDTO user = new UserDTO();
		user.setFirstname("Nemeth");
		user.setLastname("Attila");
		user.setPassword("123456");
		UserDTO createdUser = sut.createUser(user);
		Assert.assertEquals("The created username should match the exrpesssion !", "AttilN", createdUser.getUsername());
	}

	/**
	 * Check if username generator works correctly when username already exists
	 * 
	 * @throws BusinessException
	 */
	@Test
	public void createUserWithExistingUsername() throws BusinessException {
		UserDTO user = new UserDTO();
		user.setFirstname("Fulop");
		user.setLastname("Szabi");
		user.setPassword("123456");
		UserDTO createdUser = sut.createUser(user);
		UserDTO user2 = new UserDTO();
		user2.setFirstname("Fulop");
		user2.setLastname("Szabi");
		user2.setPassword("123456");
		UserDTO createdUser2 = sut.createUser(user2);
		Assert.assertEquals("The created username should match the exrpesssion !", "SzabiFu",
				createdUser2.getUsername());
	}

	/**
	 * Check if user with current role has specific permission
	 * 
	 * @throws BusinessException
	 */

	@EJB
	private PermissionDAO permDAO;
	@EJB
	private RoleDAO roleDAO;

	@Test
	public void checkPermission() throws BusinessException {
		List<Role> roles = new ArrayList();
		List<Permission> permissions = new ArrayList();

		Permission managementPerm = permDAO.findEntity(1L);
		permissions.add(managementPerm);
		Permission bugClosePerm = permDAO.findEntity(4L);
		permissions.add(bugClosePerm);

		Role adminRole = roleDAO.findEntity(1L);
		roles.add(adminRole);

		UserDTO user = new UserDTO();
		user.setFirstname("Thierry");
		user.setLastname("Henry");
		user.setPassword("12345");
		user.setRoles(roles);
		try {
			user.setEmail("henry@msggroup.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
		UserDTO createdUser = sut.createUser(user);
		// boolean hasPermission = permCheck.checkPermission(createdUser,
		// PermissionConstants.PM);
		Assert.assertEquals("email", managementPerm.getId(), createdUser.getRoles().get(0));
		// Assert.assertEquals("PERMISSION: ", true, hasPermission);
	}

}

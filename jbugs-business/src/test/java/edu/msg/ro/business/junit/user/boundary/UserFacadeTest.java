package edu.msg.ro.business.junit.user.boundary;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.boundary.UserFacade;
import edu.msg.ro.business.user.control.UserService;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.util.TestHelper;

@RunWith(MockitoJUnitRunner.class)
public class UserFacadeTest {

	@InjectMocks
	UserFacade userFacade;

	@Mock
	UserService userService;

	TestHelper th = new TestHelper();

	public UserDTO getUser() throws BusinessException {
		return th.initializUser("firstname", "lastname", "email@msggroup.com", "password", "0748102601");
	}

	@Test
	public void testCreateUser() throws BusinessException {
		UserDTO toTest = getUser();
		userFacade.createUser(toTest);
		verify(userService, times(1)).createUser(eq(toTest));
	}

	@Test
	public void testUpdateUser() throws BusinessException {
		UserDTO toTest = getUser();
		userFacade.updateUser(toTest);
		verify(userService, times(1)).updateUser(eq(toTest));
	}

	@Test
	public void testDeleteUser() throws BusinessException {
		UserDTO toTest = getUser();
		userFacade.deleteUser(toTest);
		verify(userService, times(1)).deleteUser(eq(toTest));
	}

	@Test
	public void testDeleteUserNoCheck() throws BusinessException {
		UserDTO toTest = getUser();
		userFacade.deleteUserNoCheck(toTest);
		verify(userService, times(1)).deleteUserNoCheck(eq(toTest));
	}

	@Test
	public void testGetAllUserByQuery() throws BusinessException {
		userFacade.getAllUserByQuery("username");
		verify(userService, times(1)).getAllUsers();
	}

	@Test
	public void testGetUserByUsername() throws BusinessException {
		userFacade.getUserByUsername("username");
		verify(userService, times(1)).findUserByUsername(any(String.class));
	}
}

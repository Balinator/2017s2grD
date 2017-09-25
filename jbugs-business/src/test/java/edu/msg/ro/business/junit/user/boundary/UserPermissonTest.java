package edu.msg.ro.business.junit.user.boundary;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.user.boundary.PermissionFacade;
import edu.msg.ro.business.user.control.PermissionService;
import edu.msg.ro.business.user.dto.PermissionDTO;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.util.TestHelper;

@RunWith(MockitoJUnitRunner.class)
public class UserPermissonTest {

	@InjectMocks
	PermissionFacade permissionFacede;

	@Mock
	PermissionService permissionService;

	TestHelper th = new TestHelper();

	@Test
	public void UserPermissonTest() throws BusinessException {
		UserDTO toTest = th.initializUser("firstname", "lastname", "email@msggroup.com", "password", "0748102601");
		List<PermissionDTO> result = permissionFacede.getAll();

		verify(permissionService, times(1)).getAllPermissions();

	}
}

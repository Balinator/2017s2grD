package edu.msg.ro.business.util;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import edu.msg.ro.business.junit.bug.bundary.BugFacadeTest;
import edu.msg.ro.business.junit.bug.control.BugServiceTest;
import edu.msg.ro.business.junit.bug.dto.mapper.BugDTOMapperTest;
import edu.msg.ro.business.junit.user.boundary.RoleFacadeTest;
import edu.msg.ro.business.junit.user.boundary.UserFacadeTest;
import edu.msg.ro.business.junit.user.boundary.UserLoginTest;
import edu.msg.ro.business.junit.user.boundary.UserPermissonTest;
import edu.msg.ro.business.junit.user.control.PermissionServiceTest;
import edu.msg.ro.business.junit.user.control.RoleServiceTest;
import edu.msg.ro.business.junit.user.dto.mapper.UserDTOMapperTest;

/**
 * SuitClass for JUnit test
 * 
 * @author varadp
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ BugFacadeTest.class, BugServiceTest.class, RoleFacadeTest.class, UserFacadeTest.class,
		UserLoginTest.class, UserPermissonTest.class, PermissionServiceTest.class, RoleServiceTest.class,
		UserDTOMapperTest.class, BugDTOMapperTest.class

})
public class Alltest {

}

// package edu.msg.ro.business.user.control;
//
// import java.util.ArrayList;
//
// import javax.ejb.EJB;
//
// import org.junit.Assert;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.mockito.InjectMocks;
// import org.mockito.runners.MockitoJUnitRunner;
//
// import edu.msg.ro.business.common.exception.BusinessException;
// import edu.msg.ro.business.user.dto.RoleDTO;
// import edu.msg.ro.business.user.dto.UserDTO;
// import edu.msg.ro.business.util.TestHelper;
//
/// ****
// * Test for{
// *
// * @link UserService}**@author balinc
// **/
// @RunWith(MockitoJUnitRunner.class)
// public class UserServiceTest {
//
// @InjectMocks
// private UserService uService;
//
// @EJB
// private TestHelper th;
//
// /**
// * Test if email not containing the required format.
// * @throws BusinessException
// */
// @Test
// public void createUser_EmailValidationFail() throws BusinessException {
// UserDTO testUser = th.initializUser("Test", "Name", "ad23sd@msggroup.com",
// "adsd", "0756748495");
// testUser.setRoles(new ArrayList<RoleDTO>());
//
// // Invalid email, needts to be @msggroup.com
// testUser.setEmail("unique@mail.com");
//
// try {
// UserDTO createdUser = uService.createUser(testUser);
// } catch (BusinessException e) {
// Assert.assertEquals("user.crud.save.error", e.getMessage());
// return;
// }
//
// Assert.fail("Email validation should fail!");
// }
//
// /**
// * Test if fail the user insert with same email address.
// *
// * @throws BusinessException
// */
// @Test
// public void createUser_UniqueEmailFail() throws BusinessException {
// UserDTO testUser = new UserDTO();
// testUser.setFirstname("John1");
// testUser.setLastname("Doe1");
// testUser.setEmail("unique@msggroup.com");
// testUser.setPassword("123456");
//
// UserDTO createdUser = uService.createUser(testUser);
//
// UserDTO testUser2 = new UserDTO();
// testUser2.setFirstname("Mary");
// testUser2.setLastname("Jane");
// testUser2.setEmail("unique@msggroup.com");
//
// try {
// UserDTO createdUser2 = uService.createUser(testUser2);
// } catch (BusinessException e) {
// Assert.assertEquals("User already exists with given email
// unique@msggroup.com", e.getMessage());
// return;
// }
// Assert.fail("Email validation should fail!");
// }
//
// }
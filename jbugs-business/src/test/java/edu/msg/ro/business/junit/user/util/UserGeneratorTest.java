package edu.msg.ro.business.junit.user.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import edu.msg.ro.business.user.dao.UserDAO;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.business.user.util.UserGenerator;

@RunWith(MockitoJUnitRunner.class)
public class UserGeneratorTest {

	@InjectMocks
	public UserGenerator userGenerator;

	@Mock
	private UserDAO userDao;

	@Test
	public void createUsernameTest() {
		UserDTO user = new UserDTO();
		user.setFirstname("qwerty");
		user.setLastname("asdfg");
		userGenerator.createUsername(user);
	}

	@Test
	public void encryptPasswordTest() {
		UserDTO user = new UserDTO();
		user.setFirstname("qwerty");
		user.setLastname("asdfg");
		user.setPassword("asdfg");
		userGenerator.encryptPassword(user);
	}
}

package edu.msg.ro.business.junit.user.validator;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import edu.msg.ro.business.user.dao.UserDAO;
import edu.msg.ro.business.user.validation.UserValidator;
import edu.msg.ro.persistence.user.entity.User;

@RunWith(MockitoJUnitRunner.class)
public class UserValidatorTest {

	@InjectMocks
	UserValidator userValidator;

	@Mock
	UserDAO userDAO;

	/**
	 * check if User has active tasks
	 */
	@Test
	public void checkIfUserHasActiveTasksTest() {
		User user = new User();
		userValidator.checkIfUserHasActiveTasks(user);
		verify(userDAO, times(1)).checkIfUserHasAssignedBugs(any(User.class));
	}
}

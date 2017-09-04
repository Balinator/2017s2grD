package edu.msg.ro.persistence.user.operation;

import java.util.List;

import edu.msg.ro.persistence.user.entity.User;

public interface UserDao {

	public void persistUser(User user);

	public void deleteUser(User user);

	public void updateUser(User user);

	public User findUser(int userID);

	public List<User> listAllUsers();

}

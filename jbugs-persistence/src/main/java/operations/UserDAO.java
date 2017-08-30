package operations;

import java.util.List;
import javax.ejb.Remote;
import entities.User;

@Remote
public interface UserDAO {

	public void persistUser(User user);

	public void deleteUser(User user);

	public void updateUser(User user);

	public User findUser(int userID);

	public List<User> listAllUsers();

}

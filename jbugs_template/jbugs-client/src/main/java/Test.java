
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import dao.UserDaoImpl;
import dao.UserDaoInterface;

public class Test {

	public static void main(String[] args) {
		try {
			doSomething();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static void doSomething() throws NamingException {
		System.out.println("Strat");

		Properties jndiProps = new Properties();
		jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.impl.SerialInitContextFactory");

		Context context = new InitialContext(jndiProps);

		Object o = context.lookup("UserDaoImpl");// implemented class

		UserDaoImpl dao = (UserDaoImpl) PortableRemoteObject.narrow(o, UserDaoInterface.class);
		// implemented class = ...(o,interface)

		// Dao dao = new Dao();

		// UserDao userDao = dao.getUserDao();
		// doUser(userDao);
		//
		// RoleDao roleDao = dao.getRoleDao();
		// doRole(roleDao);
		//
		// PermissionDao permissionDao = dao.getPermissionDao();
		// doPermission(permissionDao);

		System.out.println("Done");
	}

	/*
	 * private static void doPermission(PermissionDao permissionDao) {
	 * Permission permission = new Permission("Name", "details"); Permission
	 * permission2 = new Permission("Name2", "details2");
	 * 
	 * permissionDao.persist(permission); permissionDao.persist(permission2);
	 * permissionDao.delete(permission);
	 * 
	 * permission2.setDetails("asdfgh");
	 * 
	 * permissionDao.update(permission2);
	 * 
	 * System.out.println("Permission2: " + permissionDao.find(2));
	 * System.out.println("All Permission: " + permissionDao.findAll()); }
	 * 
	 * private static void doRole(RoleDao roleDao) { Role role = new
	 * Role("asd"); Role role2 = new Role("asdfg");
	 * 
	 * roleDao.persist(role); roleDao.persist(role2); roleDao.delete(role);
	 * 
	 * System.out.println("Role2: " + roleDao.find(2));
	 * System.out.println("All Role: " + roleDao.findAll()); }
	 * 
	 * private static void doUser(UserDao userDao) { User user = new
	 * User("Sanyi", "Nagy", "NagyS", "a@a.aa", "074123456", "asd", true); User
	 * user2 = new User("Sanyi", "Nagy", "NagyF", "a@a.aa", "074654321",
	 * "asdfgh", true);
	 * 
	 * userDao.persist(user); userDao.persist(user2); userDao.delete(user);
	 * 
	 * user2.setEmail("b@b.bb");
	 * 
	 * userDao.update(user2);
	 * 
	 * System.out.println("User2: " + userDao.find(2));
	 * System.out.println("All User: " + userDao.findAll()); }
	 */

}

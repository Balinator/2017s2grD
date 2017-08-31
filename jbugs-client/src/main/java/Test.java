import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import entities.User;
import operations.UserDAO;

public class Test {

	public static void main(String[] args) throws Exception {
		getRemote();
	}

	public static void getRemote() throws NamingException {
		Properties jndiProps = new Properties();
		jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.impl.SerialInitContextFactory");
		// create a context passing these properties
		Context ctx = new InitialContext(jndiProps);

		// name is whatever JNDI name you gave it
		Object o = ctx.lookup("UserDAOImpl");
		UserDAO ejbHome = (UserDAO) PortableRemoteObject.narrow(o, UserDAO.class);
		// This is userID should be the one passed.
		User user = new User("John", "Smith", "usern", "john@gmail.com", "pas1", "07295655411", true);
		ejbHome.persistUser(user);
		System.out.println("User inserted");
	}
} 
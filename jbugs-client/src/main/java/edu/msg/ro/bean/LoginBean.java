package edu.msg.ro.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import edu.msg.ro.business.common.exception.JBugsExeption;
import edu.msg.ro.business.user.boundary.LoginFacade;
import edu.msg.ro.business.user.boundary.UserFacade;
import edu.msg.ro.business.user.dto.UserDTO;

/**
 * Login Bean class.
 * 
 * @author balinc
 */
@ManagedBean
@RequestScoped
public class LoginBean extends AbstractBean implements Serializable {

	private static int FAILEDATTEMPS;
	private static String OLDUSERNAME = null;
	private static final String LOGIN = "login";
	private transient HttpSession session = (HttpSession) context.getExternalContext().getSession(false);

	private static final long serialVersionUID = -2617767540112561117L;

	private UserDTO user = new UserDTO();

	@EJB
	private LoginFacade loginFacade;

	@EJB
	private UserFacade userFacade;

	/**
	 * @return the user
	 */
	public UserDTO getUser() {
		return user;
	}

	/**
	 * The user to set
	 * 
	 * @param user
	 */
	public void setUser(UserDTO userDTO) {
		this.user = userDTO;
	}

	/**
	 * If the password is wrong five times consecutively the user is deactivated
	 */
	private void toManyFailedPassword() {
		String loggingUser = user.getUsername();
		if (loggingUser.equals(session.getAttribute("OLDUSERNAME"))) {
			int failedlogins = Integer.parseInt(session.getAttribute("FAILEDATTEMPS").toString());
			failedlogins++;
			session.setAttribute("FAILEDATTEMPS", failedlogins);
			if (failedlogins == 4) {
				userFacade.deleteUserNoCheck(user);
				// session.setAttribute("FAILEDATTEMPS", 0);
			}
		} else {
			FAILEDATTEMPS = 0;
			session.setAttribute("FAILEDATTEMPS", 0);
			session.setAttribute("OLDUSERNAME", user.getUsername());
		}
		if ((Integer.parseInt(session.getAttribute("FAILEDATTEMPS").toString()) < 4)) {
			addI18nMessage("loginForm:username", "login.error");
		} else {
			addI18nMessage("loginForm:username", "login.wrongpassword");
		}
	}

	/**
	 * Login action listener.
	 *
	 * @param event
	 */
	public void loginActionListener(ActionEvent event) {
		// TODO: useless function or need logger
	}

	/**
	 * Loggin for the User.
	 *
	 * @return
	 */
	public String processLogin() {
		try {
			if (loginFacade.isValidUser(user)) {
				UserDTO persistedUser = userFacade.getUserByUsername(user.getUsername());
				session.setAttribute("username", persistedUser.getUsername());
				session.setAttribute("loggedUser", persistedUser);
				addI18nMessage("login.welcome");
				session.setAttribute("FAILEDATTEMPS", 0);
				return "bugManagment";
			} else {
				toManyFailedPassword();
			}
		} catch (JBugsExeption e) {
			handleExeptionI18n(e);
		}
		return LOGIN;

	}

	/**
	 * Log out the User.
	 *
	 * @return
	 */
	public String processLogout() {
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		session.invalidate();
		return LOGIN;
	}
}
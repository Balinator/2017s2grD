package edu.msg.ro.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

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
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		if (loginFacade.isValidUser(user)) {
			session.setAttribute("username", user.getUsername());
			addI18nMessage("login.welcome");
			FAILEDATTEMPS = 0;
			session.setAttribute("FAILEDATTEMPS", FAILEDATTEMPS);
			return "bugManagment";
		} else {
			String loggingUser = user.getUsername();
			if (loggingUser.equals(session.getAttribute("OLDUSERNAME"))) {

				int x = Integer.parseInt(session.getAttribute("FAILEDATTEMPS").toString());
				x++;
				session.setAttribute("FAILEDATTEMPS", x);
				if (x >= 4) {
					userFacade.deleteUserNoCheck(user);
					addI18nMessage("login.wrongpassword");
					FAILEDATTEMPS = 0;
					session.setAttribute("FAILEDATTEMPS", FAILEDATTEMPS);
				}
			} else {
				FAILEDATTEMPS = 0;
				session.setAttribute("FAILEDATTEMPS", FAILEDATTEMPS);
				OLDUSERNAME = user.getUsername();
				session.setAttribute("OLDUSERNAME", OLDUSERNAME);
			}
			addI18nMessage("loginForm:username", "login.error");
			return LOGIN;
		}
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
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
		if (loginFacade.isValidUser(user)) {
			HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
			session.setAttribute("username", user.getUsername());
			addI18nMessage("login.welcome");
			FAILEDATTEMPS = 0;
			return "bugManagment";
		} else {
			String loggingUser = user.getUsername();
			if (loggingUser.equals(OLDUSERNAME)) {
				FAILEDATTEMPS++;
				if (FAILEDATTEMPS >= 5) {
					userFacade.deleteUserNoCheck(user);
					FAILEDATTEMPS = 0;
				}
			} else {
				FAILEDATTEMPS = 0;
				OLDUSERNAME = user.getUsername();
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
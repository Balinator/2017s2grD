package edu.msg.ro.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import edu.msg.ro.business.user.boundary.LoginFacade;
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
	private static final String LOGIN = "login";

	private static final long serialVersionUID = -2617767540112561117L;

	private UserDTO user = new UserDTO();

	@EJB
	private LoginFacade loginFacade;

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
		try {
			String loggingUser = user.getUsername();
			if (loginFacade.isValidUser(user)) {
				HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
				session.setAttribute("username", user.getUsername());
				addI18nMessage("login.welcome");
				return "bugManagment";
			} else {
				// @Todo - WHAT THE FUCK IS THIS? ..... SHIT
				// Refactor based on session since is @RequestScoped the
				// FAILEDATTEMPS will be destroyed after the request. IS working
				// now because the client and the server is at the same machine
				// and if you make loggin in resonable time the EJB POOL will
				// return the same object before the Garbage
				// Collactor will destroye it.
				String loggingUser2 = user.getUsername();
				if (loggingUser.equals(loggingUser2)) {
					FAILEDATTEMPS++;
					if (FAILEDATTEMPS >= 5) {
						user.setActive(false);
						user.getEmail();
					}
				} else {
					FAILEDATTEMPS = 0;
				}
				addI18nMessage("loginForm:username", "login.error");
				return LOGIN;
			}
		} catch (Exception e) {
			addI18nMessage("login.unexpected");
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
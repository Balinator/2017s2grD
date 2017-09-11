package edu.msg.ro.bean;

import java.io.Serializable;
import java.util.Locale;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import edu.msg.ro.business.user.boundary.LoginFacade;
import edu.msg.ro.business.user.dto.UserDTO;

/**
 * @author balinc
 */
@ManagedBean
@RequestScoped
public class LoginBean implements Serializable {

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
	 * @param user
	 *            the user to set
	 */
	public void setUser(UserDTO userDTO) {
		this.user = userDTO;
	}

	public void loginActionListener(ActionEvent event) {
		System.err.println("something something event from " + event.getComponent().getClientId());
	}

	public String processLogin() {
		if (loginFacade.isValidUser(user)) {
			HttpSession session = (HttpSession) getFacesContext().getExternalContext().getSession(false);
			session.setAttribute("username", user.getUsername());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Welcome!"));
			// todo DYNAMIC
			FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("de"));
			return "users";
		} else {
			FacesContext.getCurrentInstance().addMessage("loginForm:username",
					new FacesMessage("Password or Username wrong!"));
			return "login";
		}
	}

	public String processLogout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		return "login";
	}

	/**
	 * Sadly FacesContext is not injectable. For Consistency's sake the
	 * recommended way of getting it is with a producer.
	 * 
	 * @return {@link FacesContext}
	 */
	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
}
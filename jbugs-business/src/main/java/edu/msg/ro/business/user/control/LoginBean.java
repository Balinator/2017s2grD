package edu.msg.ro.business.user.control;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import edu.msg.ro.business.user.boundary.LoginFacade;
import edu.msg.ro.persistence.user.entity.User;

/**
 * @author Mihaly Fodor
 */
@Named
@RequestScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = -2617767540112561117L;

	private User user = new User();

	private Date date = new Date();

	@Inject
	private LoginFacade loginFacade;

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	public void loginActionListener(ActionEvent event) {
		System.err.println("something something event from " + event.getComponent().getClientId());
	}

	public String processLogin() {
		if (loginFacade.isValidUser(user)) {
			// facesContext.addMessage(null, new FacesMessage("We logged in,
			// yey"));

			getFacesContext().addMessage(null, new FacesMessage("We logged in, yey"));

			HttpSession session = (HttpSession) getFacesContext().getExternalContext().getSession(false);

			// HttpSession session = (HttpSession)
			// facesContext.getExternalContext().getSession(false);

			// sessionMap.put("username", user.getUserName());

			session.setAttribute("username", user.getUsername());
			return "user";
			// Here we need to return the dashbord after login.
			// return "loginSuccess";
		} else {
			FacesContext.getCurrentInstance().addMessage("loginForm:username",
					new FacesMessage("Password or Username wrong!"));
			return "login";
			// return "loginFailed";
		}
	}

	public String processLogout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		// facesContext.getExternalContext().invalidateSession();
		return "login";
	}

	/**
	 * Sadly FacesContext is not injectable. For Consistency's sake the
	 * recommended way of getting it is with a producer.
	 * 
	 * @return {@link FacesContext}
	 */
	@Produces
	@RequestScoped
	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
package edu.msg.ro.bean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import edu.msg.ro.business.user.boundary.UserFacade;
import edu.msg.ro.business.user.dto.UserDTO;

@ManagedBean
@RequestScoped
public class LoginBean {

	@EJB
	private UserFacade userFacade;

	private UserDTO userDTO = new UserDTO();

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void loginActionListener(ActionEvent event) {
		System.err.println("something something event from " + event.getComponent().getClientId());
	}

	public String processLogin() {
		if (userFacade.verifiedLoggedInUser(userDTO)) {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("We logged in, yey"));

			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
					.getSession(false);

			session.setAttribute("username", userDTO.getUsername());
			return "loginSuccess";
		} else {
			FacesContext.getCurrentInstance().addMessage("loginForm:username",
					new FacesMessage("Password or Username wrong!"));
			return "loginFailed";
		}
	}

	public String processLogout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		return "login";
	}
}

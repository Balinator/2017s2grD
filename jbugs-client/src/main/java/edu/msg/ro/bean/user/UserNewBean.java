package edu.msg.ro.bean.user;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import edu.msg.ro.bean.notification.NotificationCreator;
import edu.msg.ro.business.common.exception.JBugsExeption;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.persistence.user.entity.User;

/**
 * Add new {@link User} bean.
 * 
 * @author balinc
 *
 */
@ManagedBean
@RequestScoped
public class UserNewBean extends AbstractUserBean {

	@EJB
	private NotificationCreator notificationCreator;

	/**
	 * {@link UserDTO}
	 */
	private UserDTO newUser = new UserDTO();

	/**
	 * Get for newUser.
	 * 
	 * @return
	 */
	public UserDTO getNewUser() {
		return newUser;
	}

	/**
	 * Set for newUser.
	 * 
	 * @param user
	 */
	public void clearUser() {
		this.newUser = new UserDTO();
		rebuildRoleService();
	}

	/**
	 * Method for creating new {@link User}.
	 */
	public void createNewUser() {
		try {
			userFacade.createUser(newUser);
			notificationCreator.createWellcomeNotification(newUser);
			addI18nMessage(I18N_SAVED, new Object[] { newUser.getUsername() });
			clearUser();
		} catch (JBugsExeption e) {
			handleExeptionI18n(e);
		}
	}
}

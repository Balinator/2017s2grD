package edu.msg.ro.business.notification.control;

import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;

import edu.msg.ro.business.notification.dao.NotificationDAO;
import edu.msg.ro.business.notification.dto.mapper.NotificationDTOMapper;
import edu.msg.ro.business.notification.util.NotificationType;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.persistence.notification.entity.Notification;
import edu.msg.ro.persistence.user.entity.User;

/**
 * Controller for {@link Notification} component.
 * 
 * @author balinc
 *
 */
@Stateless
public class NotificationService {

	@EJB
	private NotificationDTOMapper noDTOMapper;

	@EJB
	private NotificationDAO noDAO;

	protected FacesContext context = FacesContext.getCurrentInstance();

	/**
	 * Insert new {@link Notification} for all {@link User} from the list.
	 * 
	 * @param type
	 * @param userDTO
	 */
	public void newNotification(NotificationType type, List<UserDTO> users) {
		for (UserDTO user : users) {
			newNotification(type, user);
		}
	}

	/**
	 * Insert new {@link Notification} for {@link User}.
	 * 
	 * @param type
	 * @param userDTO
	 */
	public void newNotification(NotificationType type, UserDTO user) {

	}

	public void test() {
		ResourceBundle messages = ResourceBundle.getBundle("NotificationBundle", context.getViewRoot().getLocale());
		messages.getString("");
	}
}

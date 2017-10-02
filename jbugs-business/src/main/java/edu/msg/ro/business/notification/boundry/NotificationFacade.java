package edu.msg.ro.business.notification.boundry;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import edu.msg.ro.business.notification.control.NotificationService;
import edu.msg.ro.business.notification.dto.NotificationDTO;
import edu.msg.ro.business.user.dto.UserDTO;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class NotificationFacade {

	@EJB
	private NotificationService notificationService;

	public NotificationDTO createNotification(NotificationDTO dto) {
		return notificationService.createNotification(dto);
	}

	public List<NotificationDTO> getAllNotificationForUser(UserDTO user) {
		return notificationService.getAllNotificationForUser(user.getId());
	}

	public List<NotificationDTO> getSomeNotificationForUser(UserDTO user, int limit) {
		return notificationService.getSomeNotificationForUser(user.getId(), limit);
	}
}

package edu.msg.ro.business.notification.control;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

import edu.msg.ro.business.notification.dao.NotificationDAO;
import edu.msg.ro.business.notification.dao.NotificationOptionDAO;
import edu.msg.ro.business.notification.dto.NotificationDTO;
import edu.msg.ro.business.notification.dto.mapper.NotificationDTOMapper;
import edu.msg.ro.persistence.notification.entity.Notification;
import edu.msg.ro.persistence.notification.entity.NotificationOption;

@Stateless
public class NotificationService {

	@EJB
	private NotificationDAO notificationDAO;

	@EJB
	private NotificationDTOMapper notificationDTOMapper;

	@EJB
	private NotificationOptionDAO notificationOptionDAO;

	public NotificationDTO createNotification(NotificationDTO dto) {
		Notification notification = new Notification();
		notificationDTOMapper.mapToEntity(dto, notification);

		notification.setOptions(notification.getOptions());
		notification.setCreated(new Date());

		notificationDAO.persistEntity(notification);
		notification = notificationDAO.findEntity(notification.getId());

		for (NotificationOption o : notification.getOptions()) {
			o.setNotification(notification);
		}

		return notificationDTOMapper.mapToDTO(notification);
	}

	public List<NotificationDTO> getAllNotificationForUser(Long userId) {
		return notificationDTOMapper.mapToDTOs(notificationDAO.getAllNotificationForUser(userId));
	}

	@Schedule(second = "0", minute = "0", hour = "*")
	private void deleteNotificationIfIsOldEnough() {
		for (Notification entity : notificationDAO.getOldNotifications()) {
			for (int i = 0; i < entity.getOptions().size(); ++i) {
				notificationOptionDAO.deleteEntity(entity.getOptions().get(i));
			}
			notificationDAO.deleteEntity(entity);
		}
	}

}

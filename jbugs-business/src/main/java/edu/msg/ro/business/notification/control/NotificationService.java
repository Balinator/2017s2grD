package edu.msg.ro.business.notification.control;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
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

		List<NotificationOption> notificationoptionList = notification.getOptions();
		List<NotificationOption> newNotificationoptionList = new ArrayList<>();
		for (int i = 0; i < notificationoptionList.size(); ++i) {
			NotificationOption option = notificationoptionList.get(i);
			notificationOptionDAO.persistEntity(option);
			newNotificationoptionList.add(notificationOptionDAO.findEntity(option.getId()));
		}
		notification.setOptions(newNotificationoptionList);

		notificationDAO.persistEntity(notification);
		return notificationDTOMapper.mapToDTO(notificationDAO.findEntity(notification.getId()));
	}

	public void deleteNotification(NotificationDTO dto) {
		notificationDAO.deleteQuery(dto.getId());
	}

	public List<NotificationDTO> getAllNotificationForUser(Long userId) {
		return notificationDTOMapper.mapToDTOs(notificationDAO.getAllNotificationForUser(userId));
	}
}

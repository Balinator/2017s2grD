package edu.msg.ro.business.junit.notification.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import edu.msg.ro.business.notification.control.NotificationService;
import edu.msg.ro.business.notification.dao.NotificationDAO;
import edu.msg.ro.business.notification.dao.NotificationOptionDAO;
import edu.msg.ro.business.notification.dto.NotificationDTO;
import edu.msg.ro.business.notification.dto.mapper.NotificationDTOMapper;
import edu.msg.ro.persistence.notification.entity.Notification;
import edu.msg.ro.persistence.notification.entity.NotificationOption;

@RunWith(MockitoJUnitRunner.class)
public class NotificationServiceTest {

	@InjectMocks
	NotificationService notificationService;

	@Mock
	private NotificationDAO notificationDAO;

	@Mock
	private NotificationDTOMapper notificationDTOMapper;

	@Mock
	private NotificationOptionDAO notificationOptionDAO;

	@Test
	public void createNotificationTest() {
		Notification entity = new Notification();
		entity.setOptions(new ArrayList<>());
		entity.getOptions().add(new NotificationOption());

		Mockito.doReturn(entity).when(notificationDAO).findEntity(Mockito.any(Long.class));

		notificationService.createNotification(new NotificationDTO());
		Mockito.verify(notificationDTOMapper, Mockito.times(1)).mapToEntity(Mockito.any(NotificationDTO.class),
				Mockito.any(Notification.class));
		Mockito.verify(notificationDAO, Mockito.times(1)).persistEntity(Mockito.any(Notification.class));
		Mockito.verify(notificationDAO, Mockito.times(1)).findEntity(Mockito.any(Long.class));
		Mockito.verify(notificationDTOMapper, Mockito.times(1)).mapToDTO(Mockito.any(Notification.class));
	}

	@Test
	public void getAllNotificationForUserTest() {
		notificationService.getAllNotificationForUser(Mockito.any(Long.class));
		Mockito.verify(notificationDAO, Mockito.times(1)).getAllNotificationForUser(Mockito.any(Long.class));
		Mockito.verify(notificationDTOMapper, Mockito.times(1)).mapToDTOs((List<Notification>) Mockito.any(List.class));
	}

	@Test
	public void getSomeNotificationForUserTest() {
		notificationService.getSomeNotificationForUser(Mockito.any(Long.class), Mockito.anyInt());
		Mockito.verify(notificationDAO, Mockito.times(1)).getSomeNotificationForUser(Mockito.any(Long.class),
				Mockito.anyInt());
		Mockito.verify(notificationDTOMapper, Mockito.times(1)).mapToDTOs((List<Notification>) Mockito.any(List.class));
	}

}

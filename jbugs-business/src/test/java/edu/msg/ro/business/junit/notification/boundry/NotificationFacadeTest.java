package edu.msg.ro.business.junit.notification.boundry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import edu.msg.ro.business.notification.boundry.NotificationFacade;
import edu.msg.ro.business.notification.control.NotificationService;
import edu.msg.ro.business.notification.dto.NotificationDTO;
import edu.msg.ro.business.user.dto.UserDTO;

@RunWith(MockitoJUnitRunner.class)
public class NotificationFacadeTest {

	@InjectMocks
	NotificationFacade notificationFacade;

	@Mock
	private NotificationService notificationService;

	@Test
	public void createNotificationTest() {
		notificationFacade.createNotification(new NotificationDTO());
		Mockito.verify(notificationService, Mockito.times(1)).createNotification(Mockito.any(NotificationDTO.class));
	}

	@Test
	public void getAllNotificationForUserTest() {
		notificationFacade.getAllNotificationForUser(new UserDTO());
		Mockito.verify(notificationService, Mockito.times(1)).getAllNotificationForUser(Mockito.any(Long.class));
	}

	@Test
	public void getSomeNotificationForUserTest() {
		notificationFacade.getSomeNotificationForUser(new UserDTO(), 5);
		Mockito.verify(notificationService, Mockito.times(1)).getSomeNotificationForUser(Mockito.any(long.class),
				Mockito.anyInt());
	}
}

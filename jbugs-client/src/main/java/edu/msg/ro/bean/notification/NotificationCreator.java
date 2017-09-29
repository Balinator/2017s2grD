package edu.msg.ro.bean.notification;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.bug.boundary.BugFacade;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.business.notification.boundry.NotificationFacade;
import edu.msg.ro.business.notification.dto.NotificationDTO;
import edu.msg.ro.business.notification.enums.NotificationEnum;
import edu.msg.ro.business.user.boundary.UserFacade;
import edu.msg.ro.business.user.dto.UserDTO;

@Stateless
public class NotificationCreator {

	@EJB
	private NotificationFacade notificationFacade;

	@EJB
	private UserFacade userFacade;

	@EJB
	private BugFacade bugFacade;

	public void createWellcomeNotification(UserDTO user) {
		user = userFacade.getUserByUsername(user.getUsername());

		NotificationDTO notification = new NotificationDTO();
		notification.setType(NotificationEnum.WELLCOME_NEW_USER);

		List<UserDTO> users = new ArrayList<>();
		users.add(user);
		notification.setUsers(users);

		List<String> options = new ArrayList<>();
		options.add(user.getUsername());
		notification.setOptions(options);

		notificationFacade.createNotification(notification);
	}

	public void createUserUpdateNotification(UserDTO curentUser, UserDTO selected) {
		curentUser = userFacade.getUserByUsername(curentUser.getUsername());
		selected = userFacade.getUserByUsername(selected.getUsername());

		NotificationDTO notification = new NotificationDTO();
		notification.setType(NotificationEnum.USER_UPDATED);

		List<UserDTO> users = new ArrayList<>();
		users.add(curentUser);
		if (!curentUser.getId().equals(selected.getId())) {
			users.add(selected);
		}
		notification.setUsers(users);

		List<String> options = new ArrayList<>();
		options.add(curentUser.getUsername());
		options.add(selected.getUsername());
		notification.setOptions(options);

		notificationFacade.createNotification(notification);
	}

	public void createUserDeleteNotification(UserDTO curentUser, UserDTO selected) {
		curentUser = userFacade.getUserByUsername(curentUser.getUsername());
		selected = userFacade.getUserByUsername(selected.getUsername());

		NotificationDTO notification = new NotificationDTO();
		notification.setType(NotificationEnum.USER_DELETED);

		List<UserDTO> users = new ArrayList<>();
		for (UserDTO user : userFacade.getAllUsers()) {// TODO:getAllUsersWithPrmission
			users.add(user);
		}
		notification.setUsers(users);

		List<String> options = new ArrayList<>();
		options.add(curentUser.getUsername());
		options.add(selected.getUsername());
		notification.setOptions(options);

		notificationFacade.createNotification(notification);
	}

	public void createBugUpdatedNotification(UserDTO curentUser, BugDTO selected) {
		curentUser = userFacade.getUserByUsername(curentUser.getUsername());
		selected = bugFacade.findBug(selected.getId());

		NotificationDTO notification = new NotificationDTO();
		notification.setType(NotificationEnum.BUG_UPDATED);

		List<UserDTO> users = new ArrayList<>();
		users.add(selected.getAuthor());
		if (selected.getAssigned() != null && !selected.getAuthor().getId().equals(selected.getAssigned().getId())) {
			users.add(selected.getAssigned());
		}
		notification.setUsers(users);

		List<String> options = new ArrayList<>();
		options.add(curentUser.getUsername());
		options.add(selected.getTitle());
		notification.setOptions(options);

		notificationFacade.createNotification(notification);
	}

	public void createBugClosedNotification(UserDTO curentUser, BugDTO selected) {
		curentUser = userFacade.getUserByUsername(curentUser.getUsername());
		selected = bugFacade.findBug(selected.getId());

		NotificationDTO notification = new NotificationDTO();
		notification.setType(NotificationEnum.BUG_CLOSED);

		List<UserDTO> users = new ArrayList<>();
		users.add(selected.getAuthor());
		if (selected.getAssigned() != null && !selected.getAuthor().getId().equals(selected.getAssigned().getId())) {
			users.add(selected.getAssigned());
		}
		notification.setUsers(users);

		List<String> options = new ArrayList<>();
		options.add(curentUser.getUsername());
		options.add(selected.getTitle());
		notification.setOptions(options);

		notificationFacade.createNotification(notification);
	}

	public void createBugStatusUpdatedNotification(UserDTO curentUser, BugDTO selected) {
		curentUser = userFacade.getUserByUsername(curentUser.getUsername());
		selected = bugFacade.findBug(selected.getId());

		NotificationDTO notification = new NotificationDTO();
		notification.setType(NotificationEnum.BUG_STATUS_UPDATED);

		List<UserDTO> users = new ArrayList<>();
		users.add(selected.getAuthor());
		if (selected.getAssigned() != null && !selected.getAuthor().getId().equals(selected.getAssigned().getId())) {
			users.add(selected.getAssigned());
		}
		notification.setUsers(users);

		List<String> options = new ArrayList<>();
		options.add(curentUser.getUsername());
		options.add(selected.getTitle());
		notification.setOptions(options);

		notificationFacade.createNotification(notification);
	}

	public void createUserDeactivatedNotification(UserDTO user) {
		user = userFacade.getUserByUsername(user.getUsername());

		NotificationDTO notification = new NotificationDTO();
		notification.setType(NotificationEnum.USER_DEACTIVATED);

		List<UserDTO> users = new ArrayList<>();
		for (UserDTO u : userFacade.getAllUsers()) {// TODO:getAllUsersWithRight
			users.add(u);
		}
		notification.setUsers(users);

		List<String> options = new ArrayList<>();
		options.add(user.getUsername());
		notification.setOptions(options);

		notificationFacade.createNotification(notification);
	}
}

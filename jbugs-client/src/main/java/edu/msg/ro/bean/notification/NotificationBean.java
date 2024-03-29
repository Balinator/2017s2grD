package edu.msg.ro.bean.notification;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import edu.msg.ro.bean.AbstractBean;
import edu.msg.ro.business.notification.boundry.NotificationFacade;
import edu.msg.ro.business.notification.dto.NotificationDTO;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.i18n.Translator;

@ManagedBean(name = "notificationBean")
@RequestScoped
public class NotificationBean extends AbstractBean implements Serializable {

	private static final long serialVersionUID = -7987787378760401439L;

	private static final int LIMIT = 5;

	@EJB
	protected Translator translator;

	@EJB
	private NotificationFacade notificationFacade;

	public int getLIMIT() {
		return LIMIT;
	}

	public List<NotificationDTO> getNotifications() {
		UserDTO user = getLoggedUser();
		if (user != null) {
			return notificationFacade.getAllNotificationForUser(user);
		}
		return new ArrayList<>();
	}

	public List<NotificationDTO> getSomeNotifications() {
		UserDTO user = getLoggedUser();
		if (user != null) {
			return notificationFacade.getSomeNotificationForUser(user, LIMIT);
		}
		return new ArrayList<>();
	}

	public String translateNotification(NotificationDTO dto) {
		Object[] args = new Object[dto.getOptions().size()];
		for (int i = 0; i < args.length; ++i) {
			args[i] = dto.getOptions().get(i);
		}

		return translateNotification(dto.getType().getKey(), args);
	}

	private String translateNotification(String key, Object[] args) {
		return translator.messageFormat(translator.translate(key), args);
	}
}

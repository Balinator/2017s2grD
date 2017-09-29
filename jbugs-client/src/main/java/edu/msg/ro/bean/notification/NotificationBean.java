package edu.msg.ro.bean.notification;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import edu.msg.ro.bean.AbstractBean;
import edu.msg.ro.business.notification.boundry.NotificationFacade;
import edu.msg.ro.business.notification.dto.NotificationDTO;
import edu.msg.ro.i18n.Translator;

@ManagedBean(name = "notificationBean")
@RequestScoped
public class NotificationBean extends AbstractBean implements Serializable {

	private static final long serialVersionUID = -7987787378760401439L;

	@EJB
	protected Translator translator;

	@EJB
	private NotificationFacade notificationFacade;

	public List<NotificationDTO> getNotifications() {
		return notificationFacade.getAllNotificationForUser(getLoggedUser());
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

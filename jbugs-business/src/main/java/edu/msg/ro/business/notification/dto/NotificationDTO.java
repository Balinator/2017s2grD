package edu.msg.ro.business.notification.dto;

import edu.msg.ro.business.common.dto.AbstractDTO;
import edu.msg.ro.persistence.notification.entity.Notification;
import edu.msg.ro.persistence.user.entity.User;

/**
 * DTO for {@link Notification} entity.
 *
 * @author balinc
 *
 */
public class NotificationDTO extends AbstractDTO {

	private int type;

	private User target;

	private String message;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public User getTarget() {
		return target;
	}

	public void setTarget(User target) {
		this.target = target;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

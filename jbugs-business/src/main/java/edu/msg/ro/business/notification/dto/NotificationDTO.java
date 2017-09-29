package edu.msg.ro.business.notification.dto;

import java.util.List;

import edu.msg.ro.business.common.dto.AbstractDTO;
import edu.msg.ro.business.notification.enums.NotificationEnum;
import edu.msg.ro.business.user.dto.UserDTO;

public class NotificationDTO extends AbstractDTO {
	private Long id;

	private NotificationEnum type;

	private List<UserDTO> users;

	private List<String> options;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NotificationEnum getType() {
		return type;
	}

	public void setType(NotificationEnum type) {
		this.type = type;
	}

	public List<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "NotificationDTO [id=" + id + ", type=" + type + "]";
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}
}

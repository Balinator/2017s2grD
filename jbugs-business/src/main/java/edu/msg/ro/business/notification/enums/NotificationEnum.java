package edu.msg.ro.business.notification.enums;

public enum NotificationEnum {
	WELLCOME_NEW_USER(1, "notification.wellcomeNewUser"), USER_UPDATED(2, "notification.userUpdated"), USER_DELETED(3,
			"notification.userDeleted"), BUG_UPDATED(4, "notification.bugUpdated"), BUG_CLOSED(5,
					"notification.bugClosed"), BUG_STATUS_UPDATED(6,
							"notification.bugStatusUpdated"), USER_DEACTIVATED(7, "notification.userDeactivated");

	private NotificationEnum(int type, String key) {
		typeId = type;
		this.key = key;
	}

	private int typeId;

	private String key;

	public int getTypeId() {
		return typeId;
	}

	public String getKey() {
		return key;
	}
}

package edu.msg.ro.business.notification.dao;

import javax.ejb.Stateless;

import edu.msg.ro.business.common.dao.AbstractDao;
import edu.msg.ro.persistence.notification.entity.Notification;

@Stateless
public class NotificationDAO extends AbstractDao<Notification> {

	@Override
	public Class<Notification> getEntityClass() {
		return Notification.class;
	}

}

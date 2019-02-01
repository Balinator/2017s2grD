package edu.msg.ro.business.notification.dao;

import javax.ejb.Stateless;

import edu.msg.ro.business.common.dao.AbstractDao;
import edu.msg.ro.persistence.notification.entity.NotificationOption;

@Stateless
public class NotificationOptionDAO extends AbstractDao<NotificationOption> {

	@Override
	public Class<NotificationOption> getEntityClass() {
		return NotificationOption.class;
	}

}

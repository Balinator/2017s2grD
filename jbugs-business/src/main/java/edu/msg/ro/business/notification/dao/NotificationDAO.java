package edu.msg.ro.business.notification.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import edu.msg.ro.business.common.dao.AbstractDao;
import edu.msg.ro.persistence.notification.entity.Notification;

@Stateless
public class NotificationDAO extends AbstractDao<Notification> {

	@Override
	public Class<Notification> getEntityClass() {
		return Notification.class;
	}

	public List<Notification> getAllNotificationForUser(Long userId) {
		TypedQuery<Notification> query = this.em.createQuery(Notification.QUERY_FIND_ALL_FOR_USER, Notification.class);
		query.setParameter("user_id", userId);
		return query.getResultList();
	}

	public void deleteQuery(Long id) {
		Query deleteQuery = this.em.createQuery(
				"DELETE FROM notification_users WHERE notification_users.idNotification = :notification_id");
		deleteQuery.setParameter("notification_id", id);
		deleteQuery.executeUpdate();
		deleteQuery = this.em.createQuery(
				"DELETE FROM notification_option WHERE notification_option.NOTIFICATION_ID = :notification_id");
		deleteQuery.setParameter("notification_id", id);
		deleteQuery.executeUpdate();
		deleteQuery = this.em.createQuery("DELETE FROM notification WHERE notification.ID = :notification_id");
		deleteQuery.setParameter("notification_id", id);
		deleteQuery.executeUpdate();
	}

}

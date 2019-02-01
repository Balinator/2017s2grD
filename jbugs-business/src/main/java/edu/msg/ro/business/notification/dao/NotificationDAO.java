package edu.msg.ro.business.notification.dao;

import java.util.Calendar;
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

	public List<Notification> getOldNotifications() {
		Query query = this.em.createQuery("SELECT n FROM Notification n WHERE n.created < :date");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -30);
		query.setParameter("date", calendar.getTime());
		return query.getResultList();
	}

	public List<Notification> getSomeNotificationForUser(Long userId, int limit) {
		TypedQuery<Notification> query = this.em.createQuery(Notification.QUERY_FIND_ALL_FOR_USER, Notification.class);
		query.setParameter("user_id", userId);
		return query.setMaxResults(limit).getResultList();
	}

}

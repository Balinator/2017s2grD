package edu.msg.ro.persistence.notification.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.CascadeOnDelete;

import edu.msg.ro.persistence.common.entity.AbstractEntity;
import edu.msg.ro.persistence.user.entity.User;

@NamedQueries(value = { @NamedQuery(name = Notification.FIND_ALL, query = "SELECT n FROM Notification n") })
@Entity
public class Notification extends AbstractEntity {

	public static final String QUERY_FIND_ALL_FOR_USER = "SELECT n FROM Notification n JOIN n.users nuu WHERE nuu.id = :user_id ORDER BY n.id DESC";
	public static final String FIND_ALL = "Notification.findAll";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private int type;

	@ManyToMany
	@CascadeOnDelete
	@JoinTable(name = "Notification_User", joinColumns = @JoinColumn(name = "idNotification"), inverseJoinColumns = {
			@JoinColumn(name = "idUser") })
	private List<User> users;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "notification")
	@JoinColumn
	private List<NotificationOption> options;

	@Temporal(TemporalType.DATE)
	private Date created;

	@Override
	public Long getId() {
		return id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<NotificationOption> getOptions() {
		return options;
	}

	public void setOptions(List<NotificationOption> options) {
		this.options = options;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
}

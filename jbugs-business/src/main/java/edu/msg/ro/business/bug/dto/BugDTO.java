package edu.msg.ro.business.bug.dto;

import edu.msg.ro.business.common.dto.AbstractDTO;
import edu.msg.ro.persistence.bug.entity.Bug;
import edu.msg.ro.persistence.user.entity.User;

/**
 * Mapper for {@link Bug} and {@link BugDTO}.
 *
 * @author balinc
 *
 */
public class BugDTO extends AbstractDTO {

	private String title;

	private String description;

	private String targetDate;

	private String severity;

	private User author;

	private int status;

	private User assigned;

	private String version;

	private String fixedIn;

	private byte[] attachment;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public User getAssigned() {
		return assigned;
	}

	public void setAssigned(User assigned) {
		this.assigned = assigned;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getFixedIn() {
		return fixedIn;
	}

	public void setFixedIn(String fixedIn) {
		this.fixedIn = fixedIn;
	}

	public byte[] getAttachment() {
		return attachment;
	}

	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}

}

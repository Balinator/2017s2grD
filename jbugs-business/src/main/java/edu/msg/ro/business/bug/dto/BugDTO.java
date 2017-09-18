package edu.msg.ro.business.bug.dto;

import java.util.Date;

import edu.msg.ro.business.common.dto.AbstractDTO;
import edu.msg.ro.business.user.dto.UserDTO;
import edu.msg.ro.persistence.bug.entity.Bug;

/**
 * Mapper for {@link Bug} and {@link BugDTO}.
 *
 * @author balinc
 *
 */
public class BugDTO extends AbstractDTO {

	private String title;

	private String description;

	private Date targetDate;

	private String severity;

	private UserDTO author;

	private String status;

	private UserDTO assigned;

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

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public UserDTO getAuthor() {
		return author;
	}

	public void setAuthor(UserDTO author) {
		this.author = author;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserDTO getAssigned() {
		return assigned;
	}

	public void setAssigned(UserDTO assigned) {
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

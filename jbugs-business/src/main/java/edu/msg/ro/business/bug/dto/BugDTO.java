package edu.msg.ro.business.bug.dto;

import java.util.Arrays;
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

	/**
	 * Get for title.
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set for title.
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get for description.
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set for description.
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get for targetdate.
	 * 
	 * @return
	 */
	public Date getTargetDate() {
		return targetDate;
	}

	/**
	 * Set for targetdate.
	 * 
	 * @param targetDate
	 */
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	/**
	 * Get for severity.
	 * 
	 * @return
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * Set for severity.
	 * 
	 * @param severity
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * Get for author.
	 * 
	 * @return
	 */
	public UserDTO getAuthor() {
		return author;
	}

	/**
	 * Set for author.
	 * 
	 * @param author
	 */
	public void setAuthor(UserDTO author) {
		this.author = author;
	}

	/**
	 * Get for Status.
	 * 
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set for status.
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * get for AssignedUser.
	 * 
	 * @return
	 */
	public UserDTO getAssigned() {
		return assigned;
	}

	/**
	 * Set for assignedUser.
	 * 
	 * @param assigned
	 */
	public void setAssigned(UserDTO assigned) {
		this.assigned = assigned;
	}

	/**
	 * Get for version.
	 * 
	 * @return
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Set for version.
	 * 
	 * @param version
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * Get for Fixedin.
	 * 
	 * @return
	 */
	public String getFixedIn() {
		return fixedIn;
	}

	/**
	 * Set for fixedin.
	 * 
	 * @param fixedIn
	 */
	public void setFixedIn(String fixedIn) {
		this.fixedIn = fixedIn;
	}

	/**
	 * get for attachment.
	 * 
	 * @return
	 */
	public byte[] getAttachment() {
		return attachment;
	}

	/**
	 * Set for attachment.
	 * 
	 * @param attachment
	 */
	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}

	/**
	 * toString.
	 * 
	 * @param attachment
	 */
	@Override
	public String toString() {
		return "BugDTO [title=" + title + ", description=" + description + ", targetDate=" + targetDate + ", severity="
				+ severity + ", author=" + author + ", status=" + status + ", assigned=" + assigned + ", version="
				+ version + ", fixedIn=" + fixedIn + ", attachment=" + Arrays.toString(attachment) + "]";
	}

}

package edu.msg.ro.business.bug.dto;

import java.util.Date;

import edu.msg.ro.business.common.dto.AbstractDTO;
import edu.msg.ro.business.user.dto.UserDTO;

public class CommentDTO extends AbstractDTO {
	private BugDTO bug;

	private UserDTO creator;

	private Date targetDate;

	private String message;

	public BugDTO getBug() {
		return bug;
	}

	public void setBug(BugDTO bug) {
		this.bug = bug;
	}

	public UserDTO getCreator() {
		return creator;
	}

	public void setCreator(UserDTO creator) {
		this.creator = creator;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

package edu.msg.ro.business.bug.dto;

import java.util.Date;

import edu.msg.ro.business.common.dto.AbstractDTO;
import edu.msg.ro.business.user.dto.UserDTO;

public class HistoryDTO extends AbstractDTO {

	private BugDTO modified;

	private String attribute;

	private String oldValue;

	private String newValue;

	private Date modificationDate;

	private UserDTO modifier;

	public BugDTO getModified() {
		return modified;
	}

	public void setModified(BugDTO modified) {
		this.modified = modified;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public UserDTO getModifier() {
		return modifier;
	}

	public void setModifier(UserDTO modifier) {
		this.modifier = modifier;
	}
}

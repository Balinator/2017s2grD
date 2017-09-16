package edu.msg.ro.enums;

/**
 * enum for bug status
 * 
 * @author varadp
 *
 */
public enum BugStatus {

	OPEN(0), PROGRESS(1), INFO(2), FIXED(3), REJECTED(4), CLOSED(5);

	private final int label;

	private BugStatus(int label) {
		this.label = label;
	}

	public int getLabel() {
		return label;
	}

}

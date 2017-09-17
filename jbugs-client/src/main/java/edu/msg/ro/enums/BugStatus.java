package edu.msg.ro.enums;

/**
 * enum for bug status
 * 
 * @author varadp
 *
 */
public enum BugStatus {

	NEW(0), OPEN(1), PROGRESS(2), INFO(3), FIXED(4), REJECTED(5), CLOSED(6);

	private final int label;

	private BugStatus(int label) {
		this.label = label;
	}

	public int getLabel() {
		return label;
	}

}

package edu.msg.ro.enums;

/**
 * Enum for bug status.
 * 
 * @author varadp
 *
 */
public enum BugStatus {

	NEW(0), OPEN(1), PROGRESS(2), INFO(3), FIXED(4), REJECTED(5), CLOSED(6);

	private final int label;

	/**
	 * Constructor
	 * 
	 * @param label
	 */
	private BugStatus(int label) {
		this.label = label;
	}

	/**
	 * get for label.
	 * 
	 * @return
	 */
	public int getLabel() {
		return label;
	}

}
